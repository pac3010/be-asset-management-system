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
    private LocalDateTime request_time;

    @Column
    private LocalDateTime out_time;

    @Column
    private LocalDateTime return_time;

    @Column
    private Boolean is_approved_manager;

    @Column
    private Boolean is_approved_admin;

    public AssetTransaction() {
    }

    public AssetTransaction(Integer id, User user, User admin, AssetType asset, LocalDateTime request_time,
            LocalDateTime out_time, LocalDateTime return_time, Boolean is_approved_manager, Boolean is_approved_admin) {
        this.id = id;
        this.user = user;
        this.admin = admin;
        this.asset = asset;
        this.request_time = request_time;
        this.out_time = out_time;
        this.return_time = return_time;
        this.is_approved_manager = is_approved_manager;
        this.is_approved_admin = is_approved_admin;
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

    public LocalDateTime getRequest_time() {
        return request_time;
    }

    public void setRequest_time(LocalDateTime request_time) {
        this.request_time = request_time;
    }

    public LocalDateTime getOut_time() {
        return out_time;
    }

    public void setOut_time(LocalDateTime out_time) {
        this.out_time = out_time;
    }

    public LocalDateTime getReturn_time() {
        return return_time;
    }

    public void setReturn_time(LocalDateTime return_time) {
        this.return_time = return_time;
    }

    public Boolean getIs_approved_manager() {
        return is_approved_manager;
    }

    public void setIs_approved_manager(Boolean is_approved_manager) {
        this.is_approved_manager = is_approved_manager;
    }

    public Boolean getIs_approved_admin() {
        return is_approved_admin;
    }

    public void setIs_approved_admin(Boolean is_approved_admin) {
        this.is_approved_admin = is_approved_admin;
    }

    


    
}
