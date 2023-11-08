package org.sandbox.oops.dp.facade;

public class ShapeFactory {

    public Shape getShape(String shape) {
        if (shape == null) return null;

        if (shape.equalsIgnoreCase("circle")) {
            return new Circle();
        } else if (shape.equalsIgnoreCase("square")) {
            return new Square();
        } else if (shape.equalsIgnoreCase("rectangle")) {
            return new Rectangle();
        }
        return null;
    }

}
