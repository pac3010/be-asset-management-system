package com.example.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_m_asset_type")
public class AssetType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String name;

    @OneToMany(mappedBy = "assetType")
    @JsonIgnore
    private List<Asset> assets;

    @OneToMany(mappedBy = "assetType")
    @JsonIgnore
    private List<AssetComponent> assetComponents;

    public AssetType() {
    }

    public AssetType(Integer id, String name, List<Asset> assets, List<AssetComponent> assetComponents) {
        this.id = id;
        this.name = name;
        this.assets = assets;
        this.assetComponents = assetComponents;
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

    public List<Asset> getAssets() {
        return assets;
    }

    public void setAssets(List<Asset> assets) {
        this.assets = assets;
    }

    public List<AssetComponent> getAssetComponents() {
        return assetComponents;
    }

    public void setAssetcComponents(List<AssetComponent> assetComponents) {
        this.assetComponents = assetComponents;
    }

    
    
}
