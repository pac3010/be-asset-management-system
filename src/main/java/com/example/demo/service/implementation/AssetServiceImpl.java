package com.example.demo.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Asset;
import com.example.demo.repository.AssetRepository;
import com.example.demo.service.AssetService;

@Service
public class AssetServiceImpl implements AssetService{

    @Autowired
    AssetRepository assetRepository;

    @Override
    public List<Asset> get() {
        return assetRepository.findAll();
    }

    @Override
    public Asset get(Integer id) {
        return assetRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean save(Asset entity) {
        assetRepository.save(entity);
        return assetRepository.findById(entity.getId()).isPresent();
    }

    @Override
    public Boolean delete(Integer id) {
        assetRepository.deleteById(id);
        return assetRepository.findById(id).isEmpty();
    }

    @Override
       // Update an existing asset
       public Asset updateAsset(Integer id, Asset assetDetails) {
        Asset asset = assetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asset not found"));

        asset.setName(assetDetails.getName());
        asset.setSerial_number(assetDetails.getSerial_number());
        asset.setAssetType(assetDetails.getAssetType());
        asset.setStatus(assetDetails.getStatus());

        return assetRepository.save(asset);
    }

    @Override
    public Asset getIdByName(String assetName) {
        return assetRepository.findByName(assetName);
    }

    
}
