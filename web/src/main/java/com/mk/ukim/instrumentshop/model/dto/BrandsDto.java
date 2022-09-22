package com.mk.ukim.instrumentshop.model.dto;

import lombok.Data;

@Data
public class BrandsDto {

    Integer id;
    String name;
    String since;

    public BrandsDto(Integer id, String name, String since) {
        this.id = id;
        this.name = name;
        this.since = since;
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

    public String getSince() {
        return since;
    }

    public void setSince(String since) {
        this.since = since;
    }
}
