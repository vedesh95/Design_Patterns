package structural;

// client interface
interface Target {
    public String add(String s1, String s2);
}

// class with incompatible interface
class Adaptee {
    public int add(int a, int b) {
        return a + b;
    }
}

class Adapter implements Target {
    private Adaptee adaptee;
    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public String add(String s1, String s2) {
        return String.valueOf(adaptee.add(Integer.parseInt(s1), Integer.parseInt(s2)));
    }
}

class Client implements Target {
    private Target target;
    public Client(Target target) {
        this.target = target;
    }

    @Override
    public String add(String s1, String s2){
        return target.add(s1, s2);
    }
}

public class AdapterPattern {
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Target adapter = new Adapter(adaptee);
        Client client = new Client(adapter);

        System.out.println(client.add("10", "20")); // Output: 30
    }
}
