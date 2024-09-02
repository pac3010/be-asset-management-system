package com.example.demo.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Asset;
import com.example.demo.model.AssetType;
import com.example.demo.repository.AssetTypeRepository;
import com.example.demo.service.AssetTypeService;

@Service
public class AssetTypeServiceImpl implements AssetTypeService{

    @Autowired
    private AssetTypeRepository assetTypeRepository;
    @Override
    public List<AssetType> get() {
        return assetTypeRepository.findAll();
    }

    @Override
    public AssetType get(Integer id) {
        return assetTypeRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean save(AssetType entity) {
        assetTypeRepository.save(entity);
        return assetTypeRepository.findById(entity.getId()).isPresent();
    }

    @Override
    public Boolean delete(Integer id) {
        assetTypeRepository.deleteById(id);
        return assetTypeRepository.findById(id).isEmpty();
    }

    @Override
    public AssetType getIdByName(String assetName) {
        return assetTypeRepository.findByName(assetName);
    }

   
    
}
