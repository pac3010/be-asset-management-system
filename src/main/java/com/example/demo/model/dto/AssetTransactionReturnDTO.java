package com.example.demo.model.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.example.demo.model.AssetTransaction;

public class AssetTransactionReturnDTO {
    private Integer id;
    private String username;
    private String assetName;
    private LocalDateTime reqBorrowTime;
    private LocalDateTime reqReturnTime;
    private LocalDateTime outTime;
    private LocalDateTime returnTime;
    private String status;
    
    public AssetTransactionReturnDTO() {
    }

    public AssetTransactionReturnDTO(AssetTransaction assetTransaction) {
        this.id = assetTransaction.getId();
        this.username = assetTransaction.getUser().getUsername();
        this.assetName = assetTransaction.getAsset().getName();
        this.reqBorrowTime = assetTransaction.getReqBorrowTime();
        this.reqReturnTime = assetTransaction.getReqReturnTime();
        this.outTime = assetTransaction.getOutTime();
        this.returnTime = assetTransaction.getReturnTime();
        this.status = assetTransaction.getStatus().getName();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    

    
}
