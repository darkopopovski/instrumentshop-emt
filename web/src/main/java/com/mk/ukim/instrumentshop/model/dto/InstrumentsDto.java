package com.mk.ukim.instrumentshop.model.dto;

import lombok.Data;

@Data
public class InstrumentsDto {

    private Integer id;

    private String name;

    private String year;

    private Integer brand;

    public InstrumentsDto() {
    }

    public InstrumentsDto(Integer id,String name, String year, Integer brand) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.brand = brand;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Integer getBrand() {
        return brand;
    }

    public void setBrand(Integer brand) {
        this.brand = brand;
    }
}

