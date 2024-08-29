package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_tr_damage_assessment")
public class DamageAssessment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "asset_transaction_id", referencedColumnName = "id")
    private AssetTransaction assetTransaction;

    @ManyToOne
    @JoinColumn(name = "damage_percentage_id", referencedColumnName = "id")
    private DamagePercentage damagePercentage;

    @Column
    private Boolean isBroken ;

    public DamageAssessment() {
    }

    public DamageAssessment(Integer id, AssetTransaction assetTransaction, DamagePercentage damagePercentage,
            Boolean isBroken) {
        this.id = id;
        this.assetTransaction = assetTransaction;
        this.damagePercentage = damagePercentage;
        this.isBroken = isBroken;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AssetTransaction getAssetTransaction() {
        return assetTransaction;
    }

    public void setAssetTransaction(AssetTransaction assetTransaction) {
        this.assetTransaction = assetTransaction;
    }

    public DamagePercentage getDamagePercentage() {
        return damagePercentage;
    }

    public void setDamagePercentage(DamagePercentage damagePercentage) {
        this.damagePercentage = damagePercentage;
    }

    public Boolean getIsBroken() {
        return isBroken;
    }

    public void setIsBroken(Boolean isBroken) {
        this.isBroken = isBroken;
    }

    
}
