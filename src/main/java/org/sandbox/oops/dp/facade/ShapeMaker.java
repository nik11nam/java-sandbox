package org.sandbox.oops.dp.facade;

/**
 * https://stackabuse.com/structural-design-patterns-in-java/#facade
 */
public class ShapeMaker {
    private Shape circle;
    private Shape rectangle;
    private Shape square;

    public ShapeMaker() {
        ShapeFactory shapeFactory = new ShapeFactory();

        circle = shapeFactory.getShape("circle");
        rectangle = shapeFactory.getShape("rectangle");
        square = shapeFactory.getShape("square");
    }

    public void drawCircle(){
        circle.draw();
    }
    public void drawRectangle(){
        rectangle.draw();
    }
    public void drawSquare(){
        square.draw();
    }

    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();

        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }
}
