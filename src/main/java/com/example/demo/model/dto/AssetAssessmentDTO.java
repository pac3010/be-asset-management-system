package com.example.demo.model.dto;

public class AssetAssessmentDTO {
    private Boolean isBroken;
    private Integer statusId;
    
    public AssetAssessmentDTO() {
    }

    public AssetAssessmentDTO(Boolean isBroken, Integer statusId) {
        this.isBroken = isBroken;
        this.statusId = statusId;
    }

    public Boolean getIsBroken() {
        return isBroken;
    }

    public void setIsBroken(Boolean isBroken) {
        this.isBroken = isBroken;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    
}
