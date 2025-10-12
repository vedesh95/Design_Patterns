package creational.factory;

interface Chair {
    void sitOn();
}
interface Sofa {
    void lieOn();
}
class VictorianChair implements Chair {
    @Override
    public void sitOn() {
        System.out.println("Sitting on a Victorian Chair");
    }
}
class ModernChair implements Chair {
    @Override
    public void sitOn() {
        System.out.println("Sitting on a Modern Chair");
    }
}
class VictorianSofa implements Sofa {
    @Override
    public void lieOn() {
        System.out.println("Lying on a Victorian Sofa");
    }
}
class ModernSofa implements Sofa {
    @Override
    public void lieOn() {
        System.out.println("Lying on a Modern Sofa");
    }
}
interface FurnitureFactory {
    Chair createChair();
    Sofa createSofa();
}
class VictorianFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new VictorianChair();
    }
    @Override
    public Sofa createSofa() {
        return new VictorianSofa();
    }
}
class ModernFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new ModernChair();
    }
    @Override
    public Sofa createSofa() {
        return new ModernSofa();
    }
}
public class AbstractFactory {
    public static void main(String[] args) {
        FurnitureFactory victorianFactory = new VictorianFurnitureFactory();
        Chair victorianChair = victorianFactory.createChair();
        Sofa victorianSofa = victorianFactory.createSofa();
        victorianChair.sitOn();
        victorianSofa.lieOn();
    }
}
