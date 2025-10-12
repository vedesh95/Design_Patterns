package structural;

interface Coffee {
    int cost();
    String description();

}

class SimpleCoffee implements Coffee {
    @Override
    public int cost() {return 5;}

    @Override
    public String description() {return "Simple Coffee";}
}

class CoffeeDecorator implements Coffee {
    protected Coffee coffee;
    CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }
    @Override
    public int cost() {return coffee.cost();}
    @Override
    public String description() {return coffee.description();}
}

class MilkDecorator extends CoffeeDecorator {
    MilkDecorator(Coffee coffee) {
        super(coffee);
    }
    @Override
    public int cost() {return super.cost() + 2;}
    @Override
    public String description() {return super.description() + ", Milk";}
}

class SugarDecorator extends CoffeeDecorator {
    SugarDecorator(Coffee coffee) {
        super(coffee);
    }
    @Override
    public int cost() {return super.cost() + 1;}
    @Override
    public String description() {return super.description() + ", Sugar";}
}

public class Decorator {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.description() + " Cost: " + coffee.cost());
        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.description() + " Cost: " + coffee.cost());
        coffee = new SugarDecorator(coffee);
        System.out.println(coffee.description() + " Cost: " + coffee.cost());
    }
}
