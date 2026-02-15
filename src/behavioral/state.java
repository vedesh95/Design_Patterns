package behavioral;

import java.util.*;

class Item {
    private String code;
    private int price;
    Item(String code, int price) { this.code = code; this.price = price; }

    public String getCode() { return code; }
    public int getPrice() { return price; }
}
class VendingMachine {
    private MachineState state;
    private List<Item> products;
    private Item selectedItem;

    VendingMachine() { this.state = new IdleState(this); this.products = new ArrayList<>(); }

    void receiveProductCode(String code) {
        state.receiveProductCode(code);
    }
    void receiveMoney(int money) { state.receiveMoney(money); }
    void dispense() { state.dispense(); }

    void addProduct(Item item) { this.products.add(item); }

    public List<Item> getProducts() { return products; }
    public Item getSelectedItem() { return selectedItem; }
    public void setSelectedItem(Item selectedItem) { this.selectedItem = selectedItem; }
    public void setState(MachineState state) { this.state = state; }
}
interface MachineState{
    void receiveProductCode(String code);
    void receiveMoney(int money);
    void dispense();
}

class IdleState implements MachineState{
    private VendingMachine machine;
    IdleState(VendingMachine machine) { this.machine = machine; }

    @Override
    public void receiveProductCode(String code) {
        this.machine.setSelectedItem(this.machine.getProducts().stream().filter(x -> x.getCode().equals(code)).findFirst().orElseThrow(() -> new RuntimeException("invalid code")));
        this.machine.setState(new ReceivingMoneyState(this.machine));
    }

    @Override
    public void receiveMoney(int money) { throw new RuntimeException("invalid operation"); }
    @Override
    public void dispense() { throw new RuntimeException("invalid operation"); }
}

class ReceivingMoneyState implements MachineState{
    private VendingMachine machine;
    ReceivingMoneyState(VendingMachine machine) { this.machine = machine; }

    @Override
    public void receiveProductCode(String code) { throw new RuntimeException("invalid operation"); }

    @Override
    public void receiveMoney(int money) {
        if(money == this.machine.getSelectedItem().getPrice()) {
            this.machine.setState(new DispensingState(this.machine));
        }
    }

    @Override
    public void dispense() { throw new RuntimeException("invalid operation"); }
}

class DispensingState implements MachineState{
    private VendingMachine machine;
    DispensingState(VendingMachine machine) { this.machine = machine; }

    @Override
    public void receiveProductCode(String code) { throw new RuntimeException("invalid operation"); }

    @Override
    public void receiveMoney(int money) { throw new RuntimeException("invalid operation"); }

    @Override
    public void dispense() {
        System.out.println("dispensing " + this.machine.getSelectedItem().getCode());
        this.machine.setState(new IdleState(this.machine));
    }
}

public class state {
    public static void main(String[] args) {
        Item item1 = new Item("Coke", 10);
        Item item2 = new Item("Pepsi", 15);
        VendingMachine machine = new VendingMachine();
        machine.addProduct(item1);
        machine.addProduct(item2);

        machine.receiveProductCode("Coke");
        machine.receiveMoney(10);
        machine.dispense();
    }
}
