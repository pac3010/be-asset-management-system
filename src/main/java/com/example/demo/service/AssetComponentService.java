package com.example.demo.service;

import java.util.List;

import com.example.demo.model.AssetComponent;
import com.example.demo.service.generic.GenericService;

public interface AssetComponentService extends GenericService<AssetComponent, Integer> {
    public List<AssetComponent> getComponentAsset(Integer assetTypeId);
}
