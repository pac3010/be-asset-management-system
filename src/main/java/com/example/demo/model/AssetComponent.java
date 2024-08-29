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

@Entity
@Table(name = "tb_m_asset_component")
public class AssetComponent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "asset_type_id", referencedColumnName = "id")
    private AssetType assetType;

    @Column
    private String name;

    @OneToOne(mappedBy = "assetComponent")
    private DamagePercentage damagePercentage;

    public AssetComponent() {
    }

    public AssetComponent(Integer id, AssetType assetType, String name, DamagePercentage damagePercentage) {
        this.id = id;
        this.assetType = assetType;
        this.name = name;
        this.damagePercentage = damagePercentage;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DamagePercentage getDamagePercentage() {
        return damagePercentage;
    }

    public void setDamagePercentage(DamagePercentage damagePercentage) {
        this.damagePercentage = damagePercentage;
    }

    
}
