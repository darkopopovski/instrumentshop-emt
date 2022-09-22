package com.mk.ukim.instrumentshop.service;

import com.mk.ukim.instrumentshop.model.Brand;
import com.mk.ukim.instrumentshop.model.Instrument;
import com.mk.ukim.instrumentshop.model.dto.BrandsDto;
import com.mk.ukim.instrumentshop.model.dto.InstrumentsDto;

import java.util.List;
import java.util.Optional;

public interface BrandService {

    List<Brand> findAll();

    Optional<Brand> findById(Integer id);

    Optional<Brand> findByName(String name);

    public Optional<Brand> save(Integer id,String name, String since);

    void deleteById(Integer id);
    void refreshMaterializedView();
    Optional<Brand> save(BrandsDto productDto);
}
