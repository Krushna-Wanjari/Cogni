# Design Patterns — Exercises

Implement 5 classic patterns. Each `.java` file has a `// TODO` skeleton — fill it in,
then run `Main.java` to see all of them demoed together.

## 1. Singleton — `Singleton.java`
Build a thread-safe `ConfigManager` singleton that holds a `Map<String,String>` of app
settings. Only one instance should ever exist. Use double-checked locking or an enum
(pick one, be ready to explain why).

## 2. Factory Method — `ShapeFactory.java`
Build a `Shape` interface with `Circle`, `Square`, `Rectangle` implementations, each with
a `draw()` and `area()` method. `ShapeFactory.getShape(String type)` returns the right one.

## 3. Observer — `Observer.java`
Build a `StockTicker` (subject) that notifies multiple `Investor` (observer) objects
whenever a stock price changes. Investors should be able to subscribe/unsubscribe.

## 4. Strategy — `PaymentStrategy.java`
Build a `PaymentStrategy` interface with `CreditCardPayment`, `UpiPayment`, `PaypalPayment`.
A `ShoppingCart` should accept a strategy at checkout time and call `pay(amount)`.

## 5. Decorator — `CoffeeDecorator.java`
Build a `Coffee` interface with a base `SimpleCoffee`, then `MilkDecorator` and
`SugarDecorator` that wrap a `Coffee` and add to its `cost()` and `description()`.

## Stretch (optional, good interview prep)
- Convert Singleton to a Builder pattern for a `UserProfile` object with 6+ optional fields.
- Add a `PremiumInvestor` in Observer that only gets notified on >5% price swings.

## Why these five
Singleton + Factory + Observer + Strategy + Decorator are the ones Cognizant's Deepskilling
assessments draw from most often (per past DN cohort trackers) — Factory and Observer
especially show up in the MCQ + coding round.
