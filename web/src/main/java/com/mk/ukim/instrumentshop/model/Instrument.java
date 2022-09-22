package com.mk.ukim.instrumentshop.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Instrument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer instrument_id;

    String instrument_name;
    String instrument_year;

    @ManyToOne
    @JoinColumn(name="brand_id", nullable=false)
    private Brand brand;

    public Instrument(Integer instrument_id, String instrument_name, String instrument_year, Brand brand) {
        this.instrument_id = instrument_id;
        this.instrument_name = instrument_name;
        this.instrument_year = instrument_year;
        this.brand = brand;
    }

    public Integer getInstrument_id() {
        return instrument_id;
    }

    public void setInstrument_id(Integer instrument_id) {
        this.instrument_id = instrument_id;
    }

    public String getInstrument_name() {
        return instrument_name;
    }

    public void setInstrument_name(String instrument_name) {
        this.instrument_name = instrument_name;
    }

    public String getInstrument_year() {
        return instrument_year;
    }

    public void setInstrument_year(String instrument_year) {
        this.instrument_year = instrument_year;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
