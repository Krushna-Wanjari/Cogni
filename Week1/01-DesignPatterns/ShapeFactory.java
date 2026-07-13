/**
 * TODO: Implement the Factory Method pattern.
 *
 * 1. Create interface Shape with methods: void draw(); double area();
 * 2. Create Circle, Square, Rectangle implementing Shape (add constructors for the
 *    dimensions you need, e.g. Circle(double radius)).
 * 3. Implement ShapeFactory.getShape(String type) below to return the right Shape
 *    for "circle" / "square" / "rectangle" (case-insensitive), or throw
 *    IllegalArgumentException for anything else.
 */
public class ShapeFactory {

    public static Shape getShape(String type) {
        // TODO: switch on type.toLowerCase() and return the matching Shape
        throw new UnsupportedOperationException("TODO: implement getShape");
    }
}

interface Shape {
    void draw();
    double area();
}

// TODO: class Circle implements Shape { ... }
// TODO: class Square implements Shape { ... }
// TODO: class Rectangle implements Shape { ... }
