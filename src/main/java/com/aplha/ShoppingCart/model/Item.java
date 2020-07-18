package com.aplha.ShoppingCart.model;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.UUID;

@Data
@Table
public class Item {

    @PrimaryKey
    @Column(name = "item_id")
    private UUID item_id;

    @Column(name = "item_name")
    private String item_name;

    @Column(name = "item_description")
    private String item_description;

    @Column(name = "item_stock")
    private int item_stock;

    @Column(name = "item_price")
    private double item_price;

    public UUID getItem_id() {
        return item_id;
    }

    public void setItem_id(UUID item_id) {
        this.item_id = item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_description() {
        return item_description;
    }

    public void setItem_description(String item_description) {
        this.item_description = item_description;
    }

    public int getItem_stock() {
        return item_stock;
    }

    public void setItem_stock(int item_stock) {
        this.item_stock = item_stock;
    }

    public double getItem_price() {
        return item_price;
    }

    public void setItem_price(double item_price) {
        this.item_price = item_price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "item_id=" + item_id +
                ", item_name='" + item_name + '\'' +
                ", item_description='" + item_description + '\'' +
                ", item_stock=" + item_stock +
                ", item_price=" + item_price +
                '}';
    }
}
