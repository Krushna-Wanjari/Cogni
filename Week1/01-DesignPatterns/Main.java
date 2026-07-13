public class Main {
    public static void main(String[] args) {
        System.out.println("=== Singleton ===");
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println("Same instance? " + (s1 == s2));

        System.out.println("\n=== Factory Method ===");
        Shape c = ShapeFactory.getShape("circle");
        // c.draw(); c will be null until you implement the factory — uncomment once ready

        System.out.println("\n=== Observer ===");
        StockTicker ticker = new StockTicker("INFY", 1500.0);
        Investor a = new Investor("Krushna");
        ticker.subscribe(a);
        ticker.setPrice(1550.0);

        System.out.println("\n=== Strategy ===");
        ShoppingCart cart = new ShoppingCart();
        // cart.setPaymentStrategy(new UpiPayment());
        // cart.checkout(999.0);

        System.out.println("\n=== Decorator ===");
        Coffee coffee = new SimpleCoffee();
        // coffee = new MilkDecorator(coffee);
        // coffee = new SugarDecorator(coffee);
        System.out.println(coffee.description() + " = " + coffee.cost());
    }
}
