package com.mk.ukim.instrumentshop.repo;

import com.mk.ukim.instrumentshop.model.ShoppingCart;
import com.mk.ukim.instrumentshop.model.Users;
import com.mk.ukim.instrumentshop.model.enumerations.ShoppingCartStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

    Optional<ShoppingCart> findByUserAndStatus(Users user, ShoppingCartStatus status);

}