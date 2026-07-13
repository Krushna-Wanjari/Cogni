package com.cognizant.week1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private OrderRepository repository;

    @Mock
    private NotificationService notificationService;

    @InjectMocks
    private OrderService orderService;

    // A sample order used across a couple of tests
    private final String customerEmail = "krushna@example.com";
    private final String productId = "PROD-1";

    @BeforeEach
    void setUp() {
        // nothing needed yet — @Mock and @InjectMocks handle wiring automatically
    }

    @Test
    void placeOrder_returnsOrderId_whenStockIsSufficient() {
        // TODO 1:
        // - stub repository.getAvailableStock(productId) to return e.g. 10
        // - call orderService.placeOrder(customerEmail, productId, 2)
        // - assertNotNull the returned order id
        // - verify(repository, times(1)).save(any(Order.class))
    }

    @Test
    void placeOrder_throwsException_whenStockIsInsufficient() {
        // TODO 2:
        // - stub repository.getAvailableStock(productId) to return e.g. 1
        // - assertThrows(IllegalStateException.class, () -> orderService.placeOrder(customerEmail, productId, 5))
        // - verify(repository, never()).save(any(Order.class))
    }

    @Test
    void placeOrder_sendsConfirmationNotification() {
        // TODO 3:
        // - stub repository.getAvailableStock(productId) to return enough stock
        // - call orderService.placeOrder(customerEmail, productId, 1)
        // - verify(notificationService).sendConfirmation(eq(customerEmail), anyString())
    }

    @Test
    void cancelOrder_returnsFalse_whenOrderDoesNotExist() {
        // TODO 4:
        // - stub repository.findById("missing-id") to return Optional.empty()
        // - assertFalse(orderService.cancelOrder("missing-id"))
        // - verify(repository, never()).delete(any(Order.class))
    }

    @Test
    void cancelOrder_returnsTrue_andDeletes_whenOrderExists() {
        // TODO 5:
        // - build an Order object, stub repository.findById(order.getOrderId()) to return Optional.of(order)
        // - assertTrue(orderService.cancelOrder(order.getOrderId()))
        // - verify(repository).delete(order)
    }
}
