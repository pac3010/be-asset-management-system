package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.AssetTransaction;

@Repository
public interface AssetTransactionRepository extends JpaRepository<AssetTransaction, Integer>{
    
}
