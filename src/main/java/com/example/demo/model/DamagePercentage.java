package com.example.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_m_damage_percentage")
public class DamagePercentage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @OneToOne
    @JoinColumn(name = "asset_component_id", referencedColumnName = "id")
    private AssetComponent assetComponent;

    @Column
    private Integer damage_percentage;

    @OneToMany(mappedBy = "damagePercentage")
    @JsonIgnore
    private List<DamageAssessment> damageAssessments;

    public DamagePercentage() {
    }

    public DamagePercentage(Integer id, AssetComponent assetComponent, Integer damage_percentage,
            List<DamageAssessment> damageAssessments) {
        this.id = id;
        this.assetComponent = assetComponent;
        this.damage_percentage = damage_percentage;
        this.damageAssessments = damageAssessments;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AssetComponent getAssetComponent() {
        return assetComponent;
    }

    public void setAssetComponent(AssetComponent assetComponent) {
        this.assetComponent = assetComponent;
    }

    public Integer getDamage_percentage() {
        return damage_percentage;
    }

    public void setDamage_percentage(Integer damage_percentage) {
        this.damage_percentage = damage_percentage;
    }

    public List<DamageAssessment> getDamageAssessments() {
        return damageAssessments;
    }

    public void setDamageAssessments(List<DamageAssessment> damageAssessments) {
        this.damageAssessments = damageAssessments;
    }

    
    
}
