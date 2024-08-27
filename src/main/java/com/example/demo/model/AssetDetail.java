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
    private String component_name;

    @Column
    private Integer component_percentage;

    @Column
    private Boolean is_broken;

    public AssetDetail() {
    }

    public AssetDetail(Integer id, Asset asset, String component_name, Integer component_percentage,
            Boolean is_broken) {
        this.id = id;
        this.asset = asset;
        this.component_name = component_name;
        this.component_percentage = component_percentage;
        this.is_broken = is_broken;
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

    public String getComponent_name() {
        return component_name;
    }

    public void setComponent_name(String component_name) {
        this.component_name = component_name;
    }

    public Integer getComponent_percentage() {
        return component_percentage;
    }

    public void setComponent_percentage(Integer component_percentage) {
        this.component_percentage = component_percentage;
    }

    public Boolean getIs_broken() {
        return is_broken;
    }

    public void setIs_broken(Boolean is_broken) {
        this.is_broken = is_broken;
    }
    
}
