package com.mk.ukim.instrumentshop.listeners;


import com.mk.ukim.instrumentshop.model.events.ProductCreatedEvent;
import com.mk.ukim.instrumentshop.service.InstrumentService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ProductEventHandles {

    private final InstrumentService productService;

    public ProductEventHandles(InstrumentService productService) {
        this.productService = productService;
    }

    @EventListener
    public void onProductCreated(ProductCreatedEvent event) {
        this.productService.refreshMaterializedView();
    }
}

