package com.example.demo.model.dto;

public class AssetDTO {
    private Integer id;
    private String name;
    private String serialNumber;
    private Integer typeId;

    public AssetDTO() {
    }

    public AssetDTO(Integer id, String name, String serialNumber, Integer typeId) {
        this.id = id;
        this.name = name;
        this.serialNumber = serialNumber;
        this.typeId = typeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

}
