package com.example.demo.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.AssetDetail;
import com.example.demo.repository.AssetDetailRepository;
import com.example.demo.service.AssetDetailService;

@Service
public class AssetDetailServiceImpl implements AssetDetailService{

    @Autowired
    AssetDetailRepository assetDetailRepository;

    @Override
    public List<AssetDetail> get() {
        return assetDetailRepository.findAll();
    }

    @Override
    public AssetDetail get(Integer id) {
        return assetDetailRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean save(AssetDetail entity) {
        assetDetailRepository.save(entity);
        return assetDetailRepository.findById(entity.getId()).isPresent();
    }

    @Override
    public Boolean delete(Integer id) {
        assetDetailRepository.deleteById(id);
        return assetDetailRepository.findById(id).isEmpty();
    }
    
}
