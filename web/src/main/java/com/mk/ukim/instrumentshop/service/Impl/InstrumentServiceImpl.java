package com.mk.ukim.instrumentshop.service.Impl;


import com.mk.ukim.instrumentshop.model.Brand;
import com.mk.ukim.instrumentshop.model.Instrument;
import com.mk.ukim.instrumentshop.model.dto.InstrumentsDto;
import com.mk.ukim.instrumentshop.repo.BrandRepository;
import com.mk.ukim.instrumentshop.repo.InstrumentRepository;
import com.mk.ukim.instrumentshop.service.InstrumentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstrumentServiceImpl implements InstrumentService {

    private final InstrumentRepository instrumentRepository;
    private final BrandRepository brandRepository;


    public InstrumentServiceImpl(InstrumentRepository instrumentRepository, BrandRepository brandRepository) {
        this.instrumentRepository = instrumentRepository;
        this.brandRepository = brandRepository;
    }

    @Override
    public List<Instrument> findAll() {
        return this.instrumentRepository.findAll();
    }

    @Override
    public Optional<Instrument> findById(Integer id) {
        return this.instrumentRepository.findById(id);
    }

    @Override
    public Optional<Instrument> findByName(String name) {
        return this.instrumentRepository.findByName(name);
    }

    @Override
    public Optional<Instrument> save(Integer id, String name, String year, Integer Id) {
        Brand brand = this.brandRepository.findById(Id).get();
        Instrument instrument = new Instrument(id,name,year,brand);
        this.instrumentRepository.save(instrument);
        return Optional.of(instrument);
    }

    @Override
    public void deleteById(Integer id) {
            Instrument instrument = this.instrumentRepository.findById(id).get();
            this.instrumentRepository.delete(instrument);
    }

    @Override
    public void refreshMaterializedView() {

    }

    @Override
    public Optional<Instrument> save(InstrumentsDto productDto) {
        Brand brand = this.brandRepository.findById(productDto.getBrand()).get();

        Instrument product = new Instrument(productDto.getId(), productDto.getName(), productDto.getYear(), brand);
        this.instrumentRepository.save(product);
        //this.refreshMaterializedView();

        //this.applicationEventPublisher.publishEvent(new ProductCreatedEvent(product));
        return Optional.of(product);
    }
}
