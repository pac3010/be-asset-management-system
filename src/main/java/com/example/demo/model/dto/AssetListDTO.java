package com.example.demo.model.dto;

import com.example.demo.model.Asset;

public class AssetListDTO {
    private Integer id;
    private String serialNumber;
    private String name;
    private String type;
    private String status;

    public AssetListDTO(){

    }
    public AssetListDTO(Asset asset) {
        this.id = asset.getId();
        this.serialNumber = asset.getSerialNumber();
        this.name = asset.getName();
        this.type = asset.getAssetType().getName();
        this.status = asset.getStatus().getName();
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getSerialNumber() {
        return serialNumber;
    }
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
