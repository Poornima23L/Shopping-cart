package com.aplha.ShoppingCart.service;

import com.aplha.ShoppingCart.dao.CartDao;
import com.aplha.ShoppingCart.dao.CartItemDao;
import com.aplha.ShoppingCart.dao.ItemDao;
import com.aplha.ShoppingCart.model.Cart;
import com.aplha.ShoppingCart.model.CartItem;
import com.aplha.ShoppingCart.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CartService {

    @Autowired
    CartDao cartDao;

    @Autowired
    CartItemDao cartItemDao;

    @Autowired
    ItemDao itemDao;


        public Cart createCart(UUID user_id){
            Cart cart = new Cart();
            UUID cart_id = UUID.randomUUID();
            cart.setCart_id(cart_id);
            cart.setUser(user_id);
            return cartDao.save(cart);
        }

    public Cart getCart(UUID user_id) {
            Cart cart = cartDao.findByUser(user_id);
            return cart;
    }

    public Cart addToCart(UUID item_id, Cart cart) {

        Item item = itemDao.findByItem_id(item_id);
        CartItem cartItem = new CartItem();
        cartItem.setCart(cart.getCart_id());
        cartItem.setItem(item_id);
        cartItem.setItem_quantity(1);
        cartItem.setItem_price(item.getItem_price());
        cartItem.setTotal_price(cartItem.getItem_quantity() * cartItem.getItem_price());
        cartItemDao.save(cartItem);

        List<Integer> cartItems = new ArrayList<>();
        cartItems.add(cartItem.getCart_item_id());

        cart.setCart_items(cartItems);
        cart.setTotal_quantity(cart.getTotal_quantity()+cartItem.getItem_quantity());
        cart.setTotal_price(cart.getTotal_price()+cartItem.getTotal_price());

        return cartDao.save(cart);

    }

    public Cart removeFromCart(UUID item_id, Cart cart) {
        Item item = itemDao.findByItem_id(item_id);
        CartItem cartItem = new CartItem();
        cartItem.setCart(cart.getCart_id());
        cartItem.setItem(item_id);
        cartItem.setItem_quantity(cartItem.getItem_quantity()-1);
        cartItem.setItem_price(item.getItem_price());
        cartItem.setTotal_price(cartItem.getItem_quantity() * cartItem.getItem_price());
        cartItemDao.save(cartItem);

        List<Integer> cartItems = new ArrayList<>();
        cartItems.add(cartItem.getCart_item_id());

        cart.setCart_items(cartItems);
        cart.setTotal_quantity(cart.getTotal_quantity()+cartItem.getItem_quantity());
        cart.setTotal_price(cart.getTotal_price()+cartItem.getTotal_price());

        return cartDao.save(cart);
    }
}
