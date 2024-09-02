package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.model.AssetType;

@Repository
public interface AssetTypeRepository extends JpaRepository<AssetType, Integer>{
    AssetType findByName(String name);
}
