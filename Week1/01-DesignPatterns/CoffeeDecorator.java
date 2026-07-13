/**
 * TODO: Implement the Decorator pattern.
 */
interface Coffee {
    double cost();
    String description();
}

class SimpleCoffee implements Coffee {
    @Override
    public double cost() { return 50.0; }

    @Override
    public String description() { return "Coffee"; }
}

abstract class CoffeeDecorator implements Coffee {
    protected final Coffee wrapped;

    protected CoffeeDecorator(Coffee wrapped) {
        this.wrapped = wrapped;
    }
}

// TODO: class MilkDecorator extends CoffeeDecorator {
//     adds 10.0 to cost(), appends ", Milk" to description()
// }

// TODO: class SugarDecorator extends CoffeeDecorator {
//     adds 5.0 to cost(), appends ", Sugar" to description()
// }
