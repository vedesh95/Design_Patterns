package creational;

interface Prototype extends Cloneable {
    Prototype deepclone();
    Prototype shallowclone();
}

class EnlargeShape{
    public void enlarge() {
        System.out.println("Enlarging shape");
    }
}
class Shape implements Prototype{
    private int x;
    private int y;
    private EnlargeShape enlargeshape;
    Shape(int x, int y){
        this.x = x;
        this.y = y;
        enlargeshape = new EnlargeShape();
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public EnlargeShape getEnlargeShape() { return enlargeshape; }

    @Override
    public Shape deepclone() {
        return new Shape(x, y);
    }

    @Override
    public Shape shallowclone() {
        try {
            return (Shape) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}

public class PrototypeDemo {
    public static void main(String[] args) {
        Shape original = new Shape(10, 20);
        Shape deepCloned = original.deepclone();
        Shape shallowCloned = original.shallowclone();

        System.out.println(shallowCloned==original); // false
        System.out.println(deepCloned==original); // false
        System.out.println(shallowCloned.getEnlargeShape()==original.getEnlargeShape()); // true
        System.out.println(deepCloned.getEnlargeShape()==original.getEnlargeShape()); // false
    }
}
