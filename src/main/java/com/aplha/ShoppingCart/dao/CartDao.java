package com.aplha.ShoppingCart.dao;

import com.aplha.ShoppingCart.model.Cart;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Component
public interface CartDao extends CassandraRepository<Cart, UUID> {

    @AllowFiltering
    Cart findByUser(UUID user_id);
}
