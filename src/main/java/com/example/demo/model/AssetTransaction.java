package com.example.demo.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
    private AssetType asset;

    @Column
    private LocalDateTime reqBorrowTime;

    @Column
    private LocalDateTime reqReturnTime;

    @Column
    private LocalDateTime outTime;

    @Column
    private LocalDateTime returnTime;

    @Column
    private Boolean isApprovedManager;

    @Column
    private Boolean isApprovedAdmin;

    @Column
    private Boolean isReturnApproved;

    public AssetTransaction() {
    }

    public AssetTransaction(Integer id, User user, User admin, AssetType asset, LocalDateTime reqBorrowTime,
            LocalDateTime reqReturnTime, LocalDateTime outTime, LocalDateTime returnTime, Boolean isApprovedManager,
            Boolean isApprovedAdmin, Boolean isReturnApproved) {
        this.id = id;
        this.user = user;
        this.admin = admin;
        this.asset = asset;
        this.reqBorrowTime = reqBorrowTime;
        this.reqReturnTime = reqReturnTime;
        this.outTime = outTime;
        this.returnTime = returnTime;
        this.isApprovedManager = isApprovedManager;
        this.isApprovedAdmin = isApprovedAdmin;
        this.isReturnApproved = isReturnApproved;
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

    public AssetType getAsset() {
        return asset;
    }

    public void setAsset(AssetType asset) {
        this.asset = asset;
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

    public Boolean getIsApprovedManager() {
        return isApprovedManager;
    }

    public void setIsApprovedManager(Boolean isApprovedManager) {
        this.isApprovedManager = isApprovedManager;
    }

    public Boolean getIsApprovedAdmin() {
        return isApprovedAdmin;
    }

    public void setIsApprovedAdmin(Boolean isApprovedAdmin) {
        this.isApprovedAdmin = isApprovedAdmin;
    }

    public Boolean getIsReturnApproved() {
        return isReturnApproved;
    }

    public void setIsReturnApproved(Boolean isReturnApproved) {
        this.isReturnApproved = isReturnApproved;
    }

    
}
