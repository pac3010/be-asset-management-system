package com.example.demo.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.DamageAssessment;
import com.example.demo.repository.DamageAssessmentRepository;
import com.example.demo.service.DamageAssessmentService;

@Service
public class DamageAssessmentServiceImpl implements DamageAssessmentService{

    @Autowired
    private DamageAssessmentRepository damageAssessmentRepository;

    @Override
    public List<DamageAssessment> get() {
        return damageAssessmentRepository.findAll();
    }

    @Override
    public DamageAssessment get(Integer id) {
        return damageAssessmentRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean save(DamageAssessment entity) {
        damageAssessmentRepository.save(entity);
        return damageAssessmentRepository.findById(entity.getId()).isPresent();
    }

    @Override
    public Boolean delete(Integer id) {
        damageAssessmentRepository.deleteById(id);
        return damageAssessmentRepository.findById(id).isEmpty();
    }
    
}
