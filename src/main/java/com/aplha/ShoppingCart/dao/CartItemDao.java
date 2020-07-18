package com.aplha.ShoppingCart.dao;

import com.aplha.ShoppingCart.model.CartItem;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Component;

@Component
public interface CartItemDao extends CassandraRepository<CartItem, Integer> {
}
