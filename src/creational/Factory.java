package creational;

interface ObjectShape {
    void draw();
}
class Rectangle implements ObjectShape {
    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}
class Circle implements ObjectShape {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}
class ShapeFactory {
    public static ObjectShape getShape(String shapeType) {
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        } else {
            throw new IllegalArgumentException("Unknown shape type");
        }
    }
}

public class Factory{
    public static void main(String[] args) {
        ObjectShape circle = ShapeFactory.getShape("CIRCLE");
        circle.draw();

        ObjectShape rectangle = ShapeFactory.getShape("RECTANGLE");
        rectangle.draw();
    }
}