package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.DamageParameter;

@Repository
public interface DamageParameterRepository extends JpaRepository<DamageParameter, Integer>{
    
}
