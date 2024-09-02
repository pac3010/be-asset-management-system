package com.example.demo.model.dto;

import com.example.demo.model.AssetComponent;

public class AssetComponentDTO {
    private Integer id;
    private String name;
    private Integer damagePercentage;

    // Constructor to map fields from AssetComponent
    public AssetComponentDTO(AssetComponent assetComponent) {
        this.id = assetComponent.getId();
        this.name = assetComponent.getName();
        this.damagePercentage = assetComponent.getDamagePercentage();
        
    }

    public AssetComponentDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDamagePercentage() {
        return damagePercentage;
    }

    public void setDamagePercentage(Integer damagePercentage) {
        this.damagePercentage = damagePercentage;
    }

    


}
