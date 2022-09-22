package com.mk.ukim.instrumentshop.service.Impl;


import com.mk.ukim.instrumentshop.model.Instrument;
import com.mk.ukim.instrumentshop.model.ShoppingCart;
import com.mk.ukim.instrumentshop.model.Users;
import com.mk.ukim.instrumentshop.model.enumerations.ShoppingCartStatus;
import com.mk.ukim.instrumentshop.model.exceptions.ProductAlreadyInShoppingCartException;
import com.mk.ukim.instrumentshop.repo.ShoppingCartRepository;
import com.mk.ukim.instrumentshop.repo.UsersRepository;
import com.mk.ukim.instrumentshop.service.InstrumentService;
import com.mk.ukim.instrumentshop.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final UsersRepository usersRepository;
    private final InstrumentService instrumentService;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository, UsersRepository usersRepository, InstrumentService instrumentService) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.usersRepository = usersRepository;
        this.instrumentService = instrumentService;
    }

    @Override
    public List<Instrument> listAllProductsInShoppingCart(Long cartId) {
        return this.shoppingCartRepository.findById(cartId).get().getInstruments();
    }

    @Override
    public ShoppingCart getActiveShoppingCart(String username) {
        Users user = this.usersRepository.findByUsername(username).get();

        return this.shoppingCartRepository
                .findByUserAndStatus(user, ShoppingCartStatus.CREATED)
                .orElseGet(() -> {
                    ShoppingCart cart = new ShoppingCart(user);
                    return this.shoppingCartRepository.save(cart);
                });
    }

    @Override
    public ShoppingCart addProductToShoppingCart(String username, Integer productId) {
        ShoppingCart shoppingCart = this.getActiveShoppingCart(username);
        Instrument product = this.instrumentService.findById(productId).get();
        if(shoppingCart.getInstruments()
                .stream().filter(i -> i.getInstrument_id().equals(productId))
                .collect(Collectors.toList()).size() > 0)
            throw new ProductAlreadyInShoppingCartException(productId, username);
        shoppingCart.getInstruments().add(product);
        return this.shoppingCartRepository.save(shoppingCart);
    }
}
