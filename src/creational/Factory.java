package creational;

interface Drawer {
    public void draw();
}

class Pen implements Drawer {
    @Override
    public void draw() {
        System.out.println("Drawing with a pen");
    }
}

class Pencil implements Drawer {
    @Override
    public void draw() {
        System.out.println("Drawing with a pencil");
    }
}

enum DrawerType {
    PEN, PENCIL
}
class DrawerFactory {
    public static Drawer getDrawer(DrawerType type) {
         switch (type) {
             case PEN:
                 return new Pen();
             case PENCIL:
                 return new Pencil();
             default:
                 throw new IllegalArgumentException("Unknown drawer type");
         }
    }
}

public class Factory {
    public static void main(String[] args) {
        Drawer drawer = DrawerFactory.getDrawer(DrawerType.PEN);
        drawer.draw();
    }
}
