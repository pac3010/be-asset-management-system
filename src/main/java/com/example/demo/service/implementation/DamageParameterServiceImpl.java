package com.example.demo.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.DamageParameter;
import com.example.demo.repository.DamageParameterRepository;
import com.example.demo.service.DamageParameterService;

@Service
public class DamageParameterServiceImpl implements DamageParameterService{
    @Autowired
    private DamageParameterRepository damageParameterRepository;

    @Override
    public List<DamageParameter> get() {
        return damageParameterRepository.findAll();
    }

    @Override
    public DamageParameter get(Integer id) {
        return damageParameterRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean save(DamageParameter entity) {
        damageParameterRepository.save(entity);
        return damageParameterRepository.findById(entity.getId()).isPresent();
    }

    @Override
    public Boolean delete(Integer id) {
        damageParameterRepository.deleteById(id);
        return damageParameterRepository.findById(id).isEmpty();
    }

    
}
