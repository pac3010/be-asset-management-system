package com.example.demo.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Status;
import com.example.demo.repository.StatusRepository;
import com.example.demo.service.StatusService;

@Service
public class StatusServiceImpl implements StatusService{

    @Autowired
    private StatusRepository statusRepository;

    @Override
    public List<Status> get() {
        return statusRepository.findAll();
    }

    @Override
    public Status get(Integer id) {
        return statusRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean save(Status entity) {
        statusRepository.save(entity);
        return statusRepository.findById(entity.getId()).isPresent();
    }

    @Override
    public Boolean delete(Integer id) {
        statusRepository.deleteById(id);
        return statusRepository.findById(id).isEmpty();
    }

    @Override
    public Status getIdByName(String statusName) {
        return statusRepository.findByName(statusName);
    }
    
    @Override
    public Status getIdByName(String statusName) {
        return statusRepository.findByName(statusName);
    }
}
