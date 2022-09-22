package com.mk.ukim.instrumentshop.web.rest;

import com.mk.ukim.instrumentshop.model.Brand;
import com.mk.ukim.instrumentshop.model.Instrument;
import com.mk.ukim.instrumentshop.model.dto.BrandsDto;
import com.mk.ukim.instrumentshop.model.dto.InstrumentsDto;
import com.mk.ukim.instrumentshop.repo.BrandRepository;
import com.mk.ukim.instrumentshop.service.BrandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RequestMapping("/api/brands")
public class BrandRestController {

    private final BrandRepository brandRepository;
    private final BrandService brandService;

    public BrandRestController(BrandRepository brandRepository, BrandService brandService) {
        this.brandRepository = brandRepository;
        this.brandService = brandService;
    }


    @GetMapping
    private List<Brand> findAll() {
        return this.brandRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Brand> findById(@PathVariable Integer id) {
        return this.brandRepository.findById(id)
                .map(brand -> ResponseEntity.ok().body(brand))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Brand> save(@RequestBody BrandsDto productDto) {
        return this.brandService.save(productDto)
                .map(product -> ResponseEntity.ok().body(product))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Integer id) {
        this.brandService.deleteById(id);
        if(this.brandService.findById(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

}
