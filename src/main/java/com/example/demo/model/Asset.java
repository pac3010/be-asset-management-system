package com.example.demo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_m_asset")
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "asset_type_id", referencedColumnName = "id")
    private AssetType assetType;

    @ManyToOne
    @JoinColumn(name = "asset_status_id", referencedColumnName = "id")
    private AssetStatus assetStatus;

    @Column
    private String name;

    @Column
    private Integer damage_percentage;

    @OneToOne(mappedBy = "asset")
    @JsonIgnore
    private AssetDetail assetDetail;

    public Asset() {
    }

    public Asset(Integer id, AssetType assetType, AssetStatus assetStatus, String name, Integer damage_percentage,
            AssetDetail assetDetail) {
        this.id = id;
        this.assetType = assetType;
        this.assetStatus = assetStatus;
        this.name = name;
        this.damage_percentage = damage_percentage;
        this.assetDetail = assetDetail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AssetType getAssetType() {
        return assetType;
    }

    public void setAssetType(AssetType assetType) {
        this.assetType = assetType;
    }

    public AssetStatus getAssetStatus() {
        return assetStatus;
    }

    public void setAssetStatus(AssetStatus assetStatus) {
        this.assetStatus = assetStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDamage_percentage() {
        return damage_percentage;
    }

    public void setDamage_percentage(Integer damage_percentage) {
        this.damage_percentage = damage_percentage;
    }

    public AssetDetail getAssetDetail() {
        return assetDetail;
    }

    public void setAssetDetails(AssetDetail assetDetail) {
        this.assetDetail = assetDetail;
    }

    
}
