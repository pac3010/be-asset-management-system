package com.example.demo.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.AssetStatus;
import com.example.demo.repository.AssetStatusRepository;
import com.example.demo.service.AssetStatusService;

@Service
public class AssetStatusServiceImpl implements AssetStatusService{

    @Autowired
    private AssetStatusRepository assetStatusRepository;

    @Override
    public List<AssetStatus> get() {
        return assetStatusRepository.findAll();
    }

    @Override
    public AssetStatus get(Integer id) {
        return assetStatusRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean save(AssetStatus entity) {
        assetStatusRepository.save(entity);
        return assetStatusRepository.findById(entity.getId()).isPresent();
    }

    @Override
    public Boolean delete(Integer id) {
        assetStatusRepository.deleteById(id);
        return assetStatusRepository.findById(id).isEmpty();
    }
    
}
