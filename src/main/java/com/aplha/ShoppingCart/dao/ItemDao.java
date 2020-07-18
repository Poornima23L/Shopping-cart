package com.aplha.ShoppingCart.dao;

import com.aplha.ShoppingCart.model.Item;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import java.util.Optional;
import java.util.UUID;

@Component
public interface ItemDao extends CassandraRepository<Item, UUID> {

    @Query("SELECT * FROM ITEM WHERE item_id = :item_id")
    Item findByItem_id(UUID item_id);
}
