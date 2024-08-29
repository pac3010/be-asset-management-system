package com.example.demo.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.DamagePercentage;
import com.example.demo.repository.DamagePercentageRepository;
import com.example.demo.service.DamagePercentageService;

@Service
public class DamagePercentageServiceImpl implements DamagePercentageService{

    @Autowired
    private DamagePercentageRepository damagePercentageRepository;

    @Override
    public List<DamagePercentage> get() {
        return damagePercentageRepository.findAll();
    }

    @Override
    public DamagePercentage get(Integer id) {
        return damagePercentageRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean save(DamagePercentage entity) {
        damagePercentageRepository.save(entity);
        return damagePercentageRepository.findById(entity.getId()).isPresent();
    }

    @Override
    public Boolean delete(Integer id) {
        damagePercentageRepository.deleteById(id);
        return damagePercentageRepository.findById(id).isEmpty();
    }
    
}
