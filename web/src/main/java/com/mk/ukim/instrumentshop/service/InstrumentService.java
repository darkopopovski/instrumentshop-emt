package com.mk.ukim.instrumentshop.service;

import com.mk.ukim.instrumentshop.model.Instrument;
import com.mk.ukim.instrumentshop.model.dto.InstrumentsDto;

import java.util.List;
import java.util.Optional;

public interface InstrumentService {

    List<Instrument> findAll();

    Optional<Instrument> findById(Integer id);

    Optional<Instrument> findByName(String name);

    public Optional<Instrument> save(Integer id,String name, String year, Integer authorId);

    void deleteById(Integer id);
    void refreshMaterializedView();
    Optional<Instrument> save(InstrumentsDto productDto);


}
