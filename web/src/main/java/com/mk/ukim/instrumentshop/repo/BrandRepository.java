package com.mk.ukim.instrumentshop.repo;

import com.mk.ukim.instrumentshop.model.Brand;
import com.mk.ukim.instrumentshop.model.Instrument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand, Integer> {

    @Query(value ="select brand_name from Brand where brand_name=?",nativeQuery = true)
    Optional<Brand> findByName(String name);


    @Query(value ="delete from Brand where brand_name=?",nativeQuery = true)
    void deleteByName(String name);

}