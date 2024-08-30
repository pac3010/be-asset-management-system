package com.example.demo.model.dto;

import com.example.demo.model.AssetComponent;

public class AssetComponentDTO {
    private Integer id;
    private String name;

    // Constructor to map fields from AssetComponent
    public AssetComponentDTO(AssetComponent assetComponent) {
        this.id = assetComponent.getId();
        this.name = assetComponent.getName();
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


}
