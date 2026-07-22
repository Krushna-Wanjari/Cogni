package com.cognizant.week1;

public class Order {
    private final String orderId;
    private final String customerEmail;
    private final String productId;
    private final int quantity;

    public Order(String orderId, String customerEmail, String productId, int quantity) {
        this.orderId = orderId;
        this.customerEmail = customerEmail;
        this.productId = productId;
        this.quantity = quantity;
    }

    public String getOrderId() { return orderId; }
    public String getCustomerEmail() { return customerEmail; }
    public String getProductId() { return productId; }
    public int getQuantity() { return quantity; }
}
