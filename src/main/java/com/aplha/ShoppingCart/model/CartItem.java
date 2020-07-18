package com.aplha.ShoppingCart.model;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
public class CartItem {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "cart_item_id")
    private int cart_item_id;

    @Column(name = "item")
    private UUID item;

    @ManyToOne
    @Column(name = "cart")
    private UUID cart;

    @Column(name = "item_quantity")
    private int item_quantity;

    @Column(name = "item_price")
    private double item_price;

    @Column(name = "total_price")
    private double total_price;

    public int getCart_item_id() {
        return cart_item_id;
    }

    public void setCart_item_id(int cart_item_id) {
        this.cart_item_id = cart_item_id;
    }

    public UUID getItem() {
        return item;
    }

    public void setItem(UUID item) {
        this.item = item;
    }

    public UUID getCart() {
        return cart;
    }

    public void setCart(UUID cart) {
        this.cart = cart;
    }

    public int getItem_quantity() {
        return item_quantity;
    }

    public void setItem_quantity(int item_quantity) {
        this.item_quantity = item_quantity;
    }

    public double getItem_price() {
        return item_price;
    }

    public void setItem_price(double item_price) {
        this.item_price = item_price;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "cart_item_id=" + cart_item_id +
                ", item=" + item +
                ", cart=" + cart +
                ", item_quantity=" + item_quantity +
                ", item_price=" + item_price +
                ", total_price=" + total_price +
                '}';
    }
}
