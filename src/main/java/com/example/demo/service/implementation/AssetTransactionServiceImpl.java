package com.example.demo.service.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Asset;
import com.example.demo.model.AssetTransaction;
import com.example.demo.model.Status;
import com.example.demo.model.dto.AssetTransactionIdBorrowTimeDTO;
import com.example.demo.repository.AssetRepository;
import com.example.demo.repository.AssetTransactionRepository;
import com.example.demo.service.AssetTransactionService;

@Service
public class AssetTransactionServiceImpl implements AssetTransactionService{

    @Autowired
    AssetTransactionRepository assetTransactionRepository;

    @Autowired
    private AssetRepository assetRepository;
    

    @Override
    public List<AssetTransaction> get() {
        return assetTransactionRepository.findAll();
    }

    @Override
    public AssetTransaction get(Integer id) {
        return assetTransactionRepository.findById(id).orElse(null);
    }
    
    @Override
    public Boolean save(AssetTransaction entity) {
        assetTransactionRepository.save(entity);
        return assetTransactionRepository.findById(entity.getId()).isPresent();
    }

    @Override
    public Boolean delete(Integer id) {
        assetTransactionRepository.deleteById(id);
        return assetTransactionRepository.findById(id).isEmpty();
    }

    
    @Override
    public AssetTransaction updateStatus(Integer id, Integer statusId) {
        // Find the AssetTransaction by ID
        AssetTransaction assetTransaction = assetTransactionRepository.findById(id).orElse(null);
    
        // Check if the AssetTransaction was found
        if (assetTransaction != null) {
            // Create a new Status object and set the statusId
            Status status = new Status();
            status.setId(statusId);
            
            // Set the new status to the AssetTransaction
            assetTransaction.setStatus(status);
            
            // Save the updated AssetTransaction back to the database
            return assetTransactionRepository.save(assetTransaction);
        } else {
            // Handle the case where the asset transaction is not found
            return null; // Or throw an exception, depending on your use case
        }
    }

    @Override
    public List<AssetTransactionIdBorrowTimeDTO> getIdAndBorrowTime() {
        return assetTransactionRepository.findAll().stream()
            .filter(assetTransaction -> 
                "Waiting For Manager Approval".equals(assetTransaction.getStatus().getName()) || 
                "Request Rejected by Manager".equals(assetTransaction.getStatus().getName())
            ) // Filter by the desired statuses
            .map(assetTransaction -> new AssetTransactionIdBorrowTimeDTO(
                assetTransaction.getId(),
                assetTransaction.getReqBorrowTime(),
                assetTransaction.getUser().getUsername(), // Get username from User
                assetTransaction.getStatus().getName(), // Get status name
                assetTransaction.getAsset() != null ? assetTransaction.getAsset().getName() : null // Get asset name (not asset type name)
            ))
            .collect(Collectors.toList());
    }
    

    @Override
    public List<AssetTransactionIdBorrowTimeDTO> getIdAndBorrowTimeBorrower(Integer userId) {
        return assetTransactionRepository.findAll().stream()
            .filter(assetTransaction -> 
                assetTransaction.getUser().getId().equals(userId) && // Filter by user ID
                (
                    "Waiting For Manager Approval".equals(assetTransaction.getStatus().getName()) || 
                    "Request Rejected by Manager".equals(assetTransaction.getStatus().getName()) ||
                    "Approved".equals(assetTransaction.getStatus().getName()) || 
                    "Request Rejected by Admin".equals(assetTransaction.getStatus().getName())
                )
            ) // Filter by the desired statuses 
            .map(assetTransaction -> new AssetTransactionIdBorrowTimeDTO(
                assetTransaction.getId(),
                assetTransaction.getReqBorrowTime(),
                assetTransaction.getUser().getUsername(), // Get username from User
                assetTransaction.getStatus().getName(), // Get status name
                assetTransaction.getAsset() != null ? assetTransaction.getAsset().getName() : null
            ))
            .collect(Collectors.toList());
    }
    
    }
    
    
    
    

