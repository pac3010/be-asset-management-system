package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_tr_asset_transaction")
public class AssetTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "admin_id", referencedColumnName = "id")
    private User admin;

    @ManyToOne
    @JoinColumn(name = "asset_id", referencedColumnName = "id")
    private Asset asset;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @Column
    private LocalDateTime reqBorrowTime;

    @Column
    private LocalDateTime reqReturnTime;

    @Column
    private LocalDateTime outTime;

    @Column
    private LocalDateTime returnTime;

    @OneToMany(mappedBy = "assetTransaction")
    @JsonIgnore
    private List<DamageAssessment> damageAssessments;


    public AssetTransaction() {
    }


    public AssetTransaction(Integer id, User user, User admin, Asset asset, Status status, LocalDateTime reqBorrowTime,
            LocalDateTime reqReturnTime, LocalDateTime outTime, LocalDateTime returnTime) {
        this.id = id;
        this.user = user;
        this.admin = admin;
        this.asset = asset;
        this.status = status;
        this.reqBorrowTime = reqBorrowTime;
        this.reqReturnTime = reqReturnTime;
        this.outTime = outTime;
        this.returnTime = returnTime;
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        this.user = user;
    }


    public User getAdmin() {
        return admin;
    }


    public void setAdmin(User admin) {
        this.admin = admin;
    }


    public Asset getAsset() {
        return asset;
    }


    public void setAsset(Asset asset) {
        this.asset = asset;
    }


    public Status getStatus() {
        return status;
    }


    public void setStatus(Status status) {
        this.status = status;
    }


    public LocalDateTime getReqBorrowTime() {
        return reqBorrowTime;
    }


    public void setReqBorrowTime(LocalDateTime reqBorrowTime) {
        this.reqBorrowTime = reqBorrowTime;
    }


    public LocalDateTime getReqReturnTime() {
        return reqReturnTime;
    }


    public void setReqReturnTime(LocalDateTime reqReturnTime) {
        this.reqReturnTime = reqReturnTime;
    }


    public LocalDateTime getOutTime() {
        return outTime;
    }


    public void setOutTime(LocalDateTime outTime) {
        this.outTime = outTime;
    }


    public LocalDateTime getReturnTime() {
        return returnTime;
    }


    public void setReturnTime(LocalDateTime returnTime) {
        this.returnTime = returnTime;
    }

    
    
}
