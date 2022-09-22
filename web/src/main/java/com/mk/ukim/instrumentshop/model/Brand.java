package com.mk.ukim.instrumentshop.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer brand_id;

    String brand_name;
    String brand_since;

    public Brand(Integer brand_id, String brand_name, String brand_since) {
        this.brand_id = brand_id;
        this.brand_name = brand_name;
        this.brand_since = brand_since;
    }

    public Integer getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(Integer brand_id) {
        this.brand_id = brand_id;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public String getBrand_since() {
        return brand_since;
    }

    public void setBrand_since(String brand_since) {
        this.brand_since = brand_since;
    }
}
