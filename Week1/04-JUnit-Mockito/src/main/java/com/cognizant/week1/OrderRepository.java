package com.cognizant.week1;

import java.util.Optional;

public interface OrderRepository {
    void save(Order order);
    Optional<Order> findById(String orderId);
    void delete(Order order);
    int getAvailableStock(String productId);
}
