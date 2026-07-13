package com.cognizant.week1;

import java.util.Optional;
import java.util.UUID;

/**
 * This class is already complete — you don't need to change it.
 * Your job (in OrderServiceTest.java) is to test it using JUnit 5 + Mockito.
 */
public class OrderService {

    private final OrderRepository repository;
    private final NotificationService notificationService;

    public OrderService(OrderRepository repository, NotificationService notificationService) {
        this.repository = repository;
        this.notificationService = notificationService;
    }

    public String placeOrder(String customerEmail, String productId, int quantity) {
        int available = repository.getAvailableStock(productId);
        if (available < quantity) {
            throw new IllegalStateException("Insufficient stock for product " + productId);
        }

        String orderId = UUID.randomUUID().toString();
        Order order = new Order(orderId, customerEmail, productId, quantity);
        repository.save(order);
        notificationService.sendConfirmation(customerEmail, orderId);
        return orderId;
    }

    public boolean cancelOrder(String orderId) {
        Optional<Order> existing = repository.findById(orderId);
        if (existing.isEmpty()) {
            return false;
        }
        repository.delete(existing.get());
        return true;
    }
}
