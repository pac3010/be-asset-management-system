package com.example.demo.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @Column
    private String name;

    @Column
    private String serial_number;

    @OneToMany(mappedBy = "asset")
    @JsonIgnore
    private List<AssetTransaction> assetTransactions;


    public Asset() {
    }

    public Asset(Integer id, AssetType assetType, Status status, String name, String serial_number,
            AssetTransaction assetTransaction) {
        this.id = id;
        this.assetType = assetType;
        this.status = status;
        this.name = name;
        this.serial_number = serial_number;
        this.assetTransaction = assetTransaction;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }

    public AssetTransaction getAssetTransaction() {
        return assetTransaction;
    }

    public void setAssetTransaction(AssetTransaction assetTransaction) {
        this.assetTransaction = assetTransaction;
    }

}
