package behavioral;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

interface Observe {
    void update(String msg);
}
class Subscriber implements Observe {
    private String name;
    Subscriber(String name) {this.name = name;}
    @Override
    public void update(String msg) { System.out.println(name + " received notification: " + msg); }
}

class Product{
    public String name,description;
    public int id, price, quantity;

    public Product(String description, int id, String name, int price, int quantity) {
        this.description = description;
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}

interface Subscribe {
    void inform(Product p);
    void attach(Product p, Subscriber s);
    void detach(Product p, Subscriber s);
}
class Sale implements Subscribe{
    private Map<Product, List<Subscriber>> mp;
    public Sale() {this.mp = new HashMap<>();}

    @Override
    public void inform(Product p) {
        this.mp.get(p).forEach(x  -> x.update(p.name + " is available now"));}

    @Override
    public void attach(Product p, Subscriber s) { this.mp.get(p).add(s); }

    @Override
    public void detach(Product p, Subscriber s) { this.mp.get(p).remove(s); }

    public void add(Product p) {this.mp.put(p, new ArrayList<>()); }
    public void add(Product p, int q){
        if(p.quantity == 0 ){
            inform(p);
        }
        p.quantity += q;
    }
}

public class observer {
    public static void main(String[] args) {
        Sale sale = new Sale();
        Product p = new Product("milk", 1, "Nandini milk", 27, 0);
        sale.add(p);
        Subscriber subscriber = new Subscriber("sam");
        sale.attach(p, subscriber);
        sale.add(p, 1);
    }
}
