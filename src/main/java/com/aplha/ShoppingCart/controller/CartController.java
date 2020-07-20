package com.aplha.ShoppingCart.controller;


import com.aplha.ShoppingCart.model.Cart;
import com.aplha.ShoppingCart.model.CartItem;
import com.aplha.ShoppingCart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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


    @DeleteMapping("/remove-from-cart")
    public ResponseEntity removeFromCart(@RequestParam("cart_id") UUID cart_id, @RequestParam("cart_item_id") UUID cart_item_id) {

        Cart cart = cartService.getCart(cart_id);

        cart = cartService.removeFromCart(cart_item_id, cart);
        return new ResponseEntity(cart, HttpStatus.OK);

    }

/*
    @PutMapping("/update-cart-item")
    public ResponseEntity updateCartItem(@RequestParam("item_quantity") int item_quantity, @RequestParam("cart_item_id") UUID cart_item_id) {


        Cart cart = cartService.getCart(cart_item_id);

        cart = cartService.updateCartItem(item_quantity, cart_item_id, cart);
        return new ResponseEntity(cart, HttpStatus.OK);
    }*/

    @GetMapping("/get-cart-item")
    public ResponseEntity getCartItem(@RequestParam("user_id") UUID user_id){
        Cart cart = cartService.getCart(user_id);
        cart = cartService.getCartItem(user_id, cart);
        return new ResponseEntity(cart, HttpStatus.OK);
    }
}

