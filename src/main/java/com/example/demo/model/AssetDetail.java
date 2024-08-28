package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_tr_asset_detail")
public class AssetDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @OneToOne
    @JoinColumn(name = "asset_id", referencedColumnName = "id")
    private Asset asset;

    @Column
    private String componentName;

    @Column
    private Integer componentPercentage;

    @Column
    private Boolean isBroken;

    public AssetDetail() {
    }

    public AssetDetail(Integer id, Asset asset, String componentName, Integer componentPercentage, Boolean isBroken) {
        this.id = id;
        this.asset = asset;
        this.componentName = componentName;
        this.componentPercentage = componentPercentage;
        this.isBroken = isBroken;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public Integer getComponentPercentage() {
        return componentPercentage;
    }

    public void setComponentPercentage(Integer componentPercentage) {
        this.componentPercentage = componentPercentage;
    }

    public Boolean getIsBroken() {
        return isBroken;
    }

    public void setIsBroken(Boolean isBroken) {
        this.isBroken = isBroken;
    }

    
    
}
