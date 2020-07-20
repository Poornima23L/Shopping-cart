package com.aplha.ShoppingCart.dao;

import com.aplha.ShoppingCart.model.CartItem;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public interface CartItemDao extends CassandraRepository<CartItem, Integer> {
    Optional<CartItem> findByCart_item_id(UUID cart_item_id);

    void deleteByCart_item_id(UUID cart_item_id);
}
