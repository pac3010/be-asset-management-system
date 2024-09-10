package com.example.demo.model.dto;

import java.time.LocalDateTime;


public class AssetTransactionIdBorrowTimeDTO {
    private Integer id;
    private LocalDateTime reqBorrowTime;
    private String username; // Property for username
    private String status; // Property for status
    private String assetName;


    // Constructors
    public AssetTransactionIdBorrowTimeDTO() {}

   


    public AssetTransactionIdBorrowTimeDTO(Integer id, LocalDateTime reqBorrowTime, String username, String status,
            String assetName) {
        this.id = id;
        this.reqBorrowTime = reqBorrowTime;
        this.username = username;
        this.status = status;
        this.assetName = assetName;
    }




    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getReqBorrowTime() {
        return reqBorrowTime;
    }

    public void setReqBorrowTime(LocalDateTime reqBorrowTime) {
        this.reqBorrowTime = reqBorrowTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }




    public String getAssetName() {
        return assetName;
    }




    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }




}
