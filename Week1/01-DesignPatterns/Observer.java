import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Implement the Observer pattern.
 * StockTicker is the Subject. Investor is the Observer.
 */
interface InvestorObserver {
    void update(String stockSymbol, double newPrice);
}

class StockTicker {
    private final List<InvestorObserver> observers = new ArrayList<>();
    private double price;
    private final String symbol;

    public StockTicker(String symbol, double initialPrice) {
        this.symbol = symbol;
        this.price = initialPrice;
    }

    public void subscribe(InvestorObserver observer) {
        // TODO: add to observers list
    }

    public void unsubscribe(InvestorObserver observer) {
        // TODO: remove from observers list
    }

    public void setPrice(double newPrice) {
        this.price = newPrice;
        // TODO: notify all observers with (symbol, newPrice)
    }
}

class Investor implements InvestorObserver {
    private final String name;

    public Investor(String name) {
        this.name = name;
    }

    @Override
    public void update(String stockSymbol, double newPrice) {
        // TODO: print something like "<name> notified: <symbol> is now <price>"
    }
}
