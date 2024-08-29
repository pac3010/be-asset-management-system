package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.AssetComponent;

@Repository
public interface AssetComponentRepository extends JpaRepository<AssetComponent, Integer>{
    
}
