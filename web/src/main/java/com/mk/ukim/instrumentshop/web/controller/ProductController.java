package com.mk.ukim.instrumentshop.web.controller;

import com.mk.ukim.instrumentshop.model.Brand;
import com.mk.ukim.instrumentshop.model.Instrument;
import com.mk.ukim.instrumentshop.repo.BrandRepository;
import com.mk.ukim.instrumentshop.service.InstrumentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/instruments")
@Controller
public class ProductController {

    private final InstrumentService instrumentService;
    private final BrandRepository brandRepository;

    public ProductController(InstrumentService instrumentService, BrandRepository brandRepository) {
        this.instrumentService = instrumentService;
        this.brandRepository = brandRepository;
    }


    @GetMapping
    public String getProductPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<Instrument> products = this.instrumentService.findAll();
        model.addAttribute("products", products);
        model.addAttribute("bodyContent", "products");
        return "master-template";
    }


    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        this.instrumentService.deleteById(id);
        return "redirect:/instruments";
    }

    @GetMapping("/add-form")
    public String addProductPage(Model model) {
        List<Brand> brands = this.brandRepository.findAll();
        model.addAttribute("brands", brands);
        model.addAttribute("bodyContent", "addInstrument");
        return "master-template";
    }

    @PostMapping("/add")
    public String saveProduct(
            @RequestParam(required = false) Integer instrument_id,
            @RequestParam String instrument_name,
            @RequestParam String instrument_year,
            @RequestParam Integer brand_id
    ) {

        this.instrumentService.save(instrument_id,instrument_name, instrument_year,brand_id);

        return "redirect:/instruments";
    }


}
