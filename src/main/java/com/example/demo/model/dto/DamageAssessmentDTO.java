package com.example.demo.model.dto;

public class DamageAssessmentDTO {
    private Integer assetComponentId;
    private Boolean isBroken;
    
    public DamageAssessmentDTO() {
    }

    public DamageAssessmentDTO(Integer assetComponentId, Boolean isBroken) {
        this.assetComponentId = assetComponentId;
        this.isBroken = isBroken;
    }

    public Integer getAssetComponentId() {
        return assetComponentId;
    }

    public void setAssetComponentId(Integer assetComponentId) {
        this.assetComponentId = assetComponentId;
    }

    public Boolean getIsBroken() {
        return isBroken;
    }

    public void setIsBroken(Boolean isBroken) {
        this.isBroken = isBroken;
    }
}
