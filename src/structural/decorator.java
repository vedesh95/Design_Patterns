package structural;

interface Item {
    String getDescription();
    int getPrice();
}

class Pizza implements Item {
    @Override
    public String getDescription() { return "Pizza"; }
    @Override
    public int getPrice() { return 300; }
}

class Jalapenos implements Item {
    Item item;
    Jalapenos(Item item) {this.item = item;}
    @Override
    public String getDescription() { return this.item.getDescription() + " + Jalapenos"; }
    @Override
    public int getPrice() { return this.item.getPrice() + 55; }
}

class Cheese implements Item {
    Item item;
    Cheese(Item item) {this.item = item;}
    @Override
    public String getDescription() { return this.item.getDescription() + " + Cheese"; }
    @Override
    public int getPrice() { return this.item.getPrice() + 40; }
}

public class decorator {
    public static void main(String[] args) {
        Item pizza = new Pizza();
        pizza = new Jalapenos(pizza);
        pizza = new Cheese(pizza);
        System.out.println(pizza.getDescription());
        System.out.println(pizza.getPrice());
    }
}
