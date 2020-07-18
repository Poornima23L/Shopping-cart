package com.aplha.ShoppingCart.controller;

import com.aplha.ShoppingCart.model.Cart;
import com.aplha.ShoppingCart.model.Item;
import com.aplha.ShoppingCart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.UUID;

@RestController
public class CartController {

    @Autowired
    CartService cartService;

    @RequestMapping("/hello")
    public String index() {
        return "Application Works!!";

    }

    @PostMapping("/add-to-cart")
    public ResponseEntity add_to_cart(@RequestParam("user_id") UUID user_id, @RequestParam("item_id") UUID item_id) {

        Cart cart = cartService.getCart(user_id);

        if (cart == null) {
            cart = cartService.createCart(user_id);
        }
        cart = cartService.addToCart(item_id, cart);
        return new ResponseEntity(cart, HttpStatus.OK);
    }

    @PostMapping("/remove-from-cart")
    public ResponseEntity removeFromCart(@RequestParam("user_id") UUID user_id, @RequestParam("item_id") UUID item_id) {

        Cart cart = cartService.getCart(user_id);

        cart = cartService.removeFromCart(item_id, cart);
        return new ResponseEntity(cart, HttpStatus.OK);

    }
}
