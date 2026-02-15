package creational;

interface Writer { public void write(); }
interface Eraser { public void erase(); }

class PhysicalWriter implements  Writer{
    @Override
    public void write() { System.out.println("physically drawing"); }
}

class DigitalWriter implements  Writer{
    @Override
    public void write() { System.out.println("digitally drawing"); }
}

class PhysicalEraser implements Eraser {
    @Override
    public void erase() { System.out.println("physically erasing"); }
}

class DigialEraser implements Eraser {
    @Override
    public void erase() { System.out.println("digitally erasing"); }
}

interface Kit {
    Writer getWriter();
    Eraser getEraser();
}

class PhysicalKit implements Kit{
    @Override
    public Writer getWriter() { return new PhysicalWriter(); }

    @Override
    public Eraser getEraser() { return new PhysicalEraser();}
}

class DigitalKit implements Kit{
    @Override
    public Writer getWriter() { return new DigitalWriter(); }

    @Override
    public Eraser getEraser() { return new DigialEraser();}
}

public class abstractfactory {
    public static void main(String[] args) {
        Kit digitalKit = new DigitalKit();
        Writer writer = digitalKit.getWriter();
        Eraser eraser = digitalKit.getEraser();

        writer.write();
        eraser.erase();
    }
}

