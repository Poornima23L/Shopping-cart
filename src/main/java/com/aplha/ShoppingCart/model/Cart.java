package com.aplha.ShoppingCart.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.UUID;

@Data
@Table
public class Cart {

    @PrimaryKey
    @Column(name = "cart_id")
    private UUID cart_id;

    @Column(name = "user")
    private UUID user;

    @Column(name = "total_quantity")
    private int total_quantity;

    @Column(name = "total_price")
    private double total_price;

    @OneToMany(mappedBy ="cart",fetch = FetchType.EAGER)
    @JsonIgnore
    @Column(name = "cart_items")
    private List<Integer> cart_items;

    public UUID getCart_id() {
        return cart_id;
    }

    public void setCart_id(UUID cart_id) {
        this.cart_id = cart_id;
    }

    public int getTotal_quantity() {
        return total_quantity;
    }

    public void setTotal_quantity(int total_quantity) {
        this.total_quantity = total_quantity;
    }

    public UUID getUser() {
        return user;
    }

    public void setUser(UUID user) {
        this.user = user;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public List<Integer> getCart_items(UUID user_id) {
        return cart_items;
    }

    public void setCart_items(List<Integer> cart_items) {
        this.cart_items = cart_items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cart_id=" + cart_id +
                ", user=" + user +
                ", total_quantity=" + total_quantity +
                ", total_price=" + total_price +
                ", cart_items=" + cart_items +
                '}';
    }
}
