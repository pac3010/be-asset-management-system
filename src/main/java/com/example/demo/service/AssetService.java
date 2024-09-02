package com.example.demo.service;

import com.example.demo.model.Asset;
import com.example.demo.service.generic.GenericService;

public interface AssetService extends GenericService<Asset, Integer>{
    public Asset updateAsset(Integer id, Asset assetDetails);
   public Asset getIdByName(String statusName);
}
