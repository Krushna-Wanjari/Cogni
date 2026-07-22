/**
 * TODO: Implement the Strategy pattern.
 * ShoppingCart should accept any PaymentStrategy and delegate pay() to it.
 */
interface PaymentStrategy {
    void pay(double amount);
}

// TODO: class CreditCardPayment implements PaymentStrategy { ... print "Paid <amt> via Credit Card" }
// TODO: class UpiPayment implements PaymentStrategy { ... }
// TODO: class PaypalPayment implements PaymentStrategy { ... }

class ShoppingCart {
    private PaymentStrategy strategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void checkout(double amount) {
        // TODO: guard against null strategy, then delegate to strategy.pay(amount)
    }
}
