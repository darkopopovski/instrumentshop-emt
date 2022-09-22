package com.mk.ukim.instrumentshop.repo;

import com.mk.ukim.instrumentshop.model.Instrument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface InstrumentRepository extends JpaRepository<Instrument, Integer> {

    @Query(value ="select instrument_name from Instrument where instrument_name=?",nativeQuery = true)
    Optional<Instrument> findByName(String name);


    @Query(value ="delete from Instrument where instrument_name=?",nativeQuery = true)
    void deleteByName(String name);

}