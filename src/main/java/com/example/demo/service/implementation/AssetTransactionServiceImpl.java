package com.example.demo.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.AssetTransaction;
import com.example.demo.model.Status;
import com.example.demo.repository.AssetTransactionRepository;
import com.example.demo.service.AssetTransactionService;

@Service
public class AssetTransactionServiceImpl implements AssetTransactionService{

    @Autowired
    AssetTransactionRepository assetTransactionRepository;

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
    
    
    
    
}
