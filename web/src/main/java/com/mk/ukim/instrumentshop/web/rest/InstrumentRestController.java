package com.mk.ukim.instrumentshop.web.rest;

import com.mk.ukim.instrumentshop.model.Instrument;
import com.mk.ukim.instrumentshop.model.dto.InstrumentsDto;
import com.mk.ukim.instrumentshop.service.InstrumentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RequestMapping("/api/products")
public class InstrumentRestController {

    private final InstrumentService productService;

    public InstrumentRestController(InstrumentService productService) {
        this.productService = productService;
    }

    @GetMapping
    private List<Instrument> findAll() {
        return this.productService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instrument> findById(@PathVariable Integer id) {
        return this.productService.findById(id)
                .map(product -> ResponseEntity.ok().body(product))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Instrument> save(@RequestBody InstrumentsDto productDto) {
        return this.productService.save(productDto)
                .map(product -> ResponseEntity.ok().body(product))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Integer id) {
        this.productService.deleteById(id);
        if(this.productService.findById(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
}
