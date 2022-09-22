package com.mk.ukim.instrumentshop.service;

import com.mk.ukim.instrumentshop.model.Instrument;
import com.mk.ukim.instrumentshop.model.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {

    List<Instrument> listAllProductsInShoppingCart(Long cartId);

    ShoppingCart getActiveShoppingCart(String username);

    public ShoppingCart addProductToShoppingCart(String username, Integer productId);
}
