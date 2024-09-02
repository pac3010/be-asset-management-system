package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Asset;
import com.example.demo.model.AssetType;


@Repository
public interface AssetRepository extends JpaRepository<Asset, Integer>{
    Asset findByName(String name);
}
