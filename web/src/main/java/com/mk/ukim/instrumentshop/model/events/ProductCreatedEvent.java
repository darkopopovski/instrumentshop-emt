package com.mk.ukim.instrumentshop.model.events;

import com.mk.ukim.instrumentshop.model.Instrument;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.time.LocalDateTime;

@Getter
public class ProductCreatedEvent extends ApplicationEvent {

    private LocalDateTime when;

    public ProductCreatedEvent(Instrument source) {
        super(source);
        this.when = LocalDateTime.now();
    }

    public ProductCreatedEvent(Instrument source, LocalDateTime when) {
        super(source);
        this.when = when;
    }
}

