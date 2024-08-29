package com.example.demo.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.AssetComponent;
import com.example.demo.repository.AssetComponentRepository;
import com.example.demo.service.AssetComponentService;

@Service
public class AssetComponentServiceImpl implements AssetComponentService{

    @Autowired
    private AssetComponentRepository assetComponentRepository;

    @Override
    public List<AssetComponent> get() {
        return assetComponentRepository.findAll();
    }

    @Override
    public AssetComponent get(Integer id) {
        return assetComponentRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean save(AssetComponent entity) {
        assetComponentRepository.save(entity);
        return assetComponentRepository.findById(entity.getId()).isPresent();
    }

    @Override
    public Boolean delete(Integer id) {
        assetComponentRepository.deleteById(id);
        return assetComponentRepository.findById(id).isEmpty();
    }
    
}
