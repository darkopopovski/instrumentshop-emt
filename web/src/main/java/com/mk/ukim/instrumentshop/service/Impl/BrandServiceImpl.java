package com.mk.ukim.instrumentshop.service.Impl;

import com.mk.ukim.instrumentshop.model.Brand;
import com.mk.ukim.instrumentshop.model.dto.BrandsDto;
import com.mk.ukim.instrumentshop.repo.BrandRepository;
import com.mk.ukim.instrumentshop.service.BrandService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<Brand> findAll() {
        return this.brandRepository.findAll();
    }

    @Override
    public Optional<Brand> findById(Integer id) {
        return this.brandRepository.findById(id);
    }

    @Override
    public Optional<Brand> findByName(String name) {
        return this.brandRepository.findByName(name);
    }

    @Override
    public Optional<Brand> save(Integer id, String name, String since) {
        Brand brand = new Brand(id,name,since);
        this.brandRepository.save(brand);
        return Optional.of(brand);
    }

    @Override
    public void deleteById(Integer id) {
        Brand brand = this.brandRepository.findById(id).get();
        this.brandRepository.delete(brand);
    }

    @Override
    public void refreshMaterializedView() {

    }

    @Override
    public Optional<Brand> save(BrandsDto productDto) {
        Brand brand = new Brand(productDto.getId(),productDto.getName(),productDto.getSince());
        this.brandRepository.save(brand);
        return Optional.of(brand);
    }
}
