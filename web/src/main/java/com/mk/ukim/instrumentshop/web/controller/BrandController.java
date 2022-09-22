package com.mk.ukim.instrumentshop.web.controller;


import com.mk.ukim.instrumentshop.model.Brand;
import com.mk.ukim.instrumentshop.model.Instrument;
import com.mk.ukim.instrumentshop.repo.BrandRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/brands")
@Controller
public class BrandController {

    private final BrandRepository brandRepository;

    public BrandController(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @GetMapping
    public String getProductPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<Brand> products = this.brandRepository.findAll();
        model.addAttribute("products", products);
        model.addAttribute("bodyContent", "brands");
        return "master-template";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        this.brandRepository.deleteById(id);
        return "redirect:/brand";
    }

}
