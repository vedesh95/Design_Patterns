package behavioral;

import java.util.ArrayList;
import java.util.List;

class User{
    String name;
    public User(String name) {this.name = name;}
    public void update() {System.out.println("User " + name + " notified about new Item in sale.");}
}

interface Sale{
    void addItem();
    void notifyUsers();
    void attach(User user);
    void detach(User user);
}

class EarlySale implements Sale{
    private List<User> users = new ArrayList<>();
    @Override
    public void addItem() {notifyUsers();}
    @Override
    public void notifyUsers() {
        for(User user : users) user.update();
    }
    @Override
    public void attach(User user) {users.add(user);}
    @Override
    public void detach(User user) {users.remove(user);}
}

public class Observer {
    public static void main(String[] args) {
        Sale sale = new EarlySale();
        User user1 = new User("Alice");
        User user2 = new User("Bob");
        sale.attach(user1);
        sale.attach(user2);
        sale.addItem();
    }
}
