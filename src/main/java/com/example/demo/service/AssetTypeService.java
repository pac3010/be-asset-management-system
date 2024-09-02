package com.example.demo.service;


import com.example.demo.model.AssetType;
import com.example.demo.service.generic.GenericService;

public interface AssetTypeService extends GenericService<AssetType, Integer>{
      public AssetType getIdByName(String statusName);
}
