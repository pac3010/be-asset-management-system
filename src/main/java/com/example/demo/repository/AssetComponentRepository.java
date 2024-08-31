package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.AssetComponent;

@Repository
public interface AssetComponentRepository extends JpaRepository<AssetComponent, Integer> {
    @Query("SELECT ac FROM AssetComponent ac WHERE ac.assetType.id = :assetTypeId")
    List<AssetComponent> findByAssetTypeId(@Param("assetTypeId") Integer assetTypeId);
}
