package behavioral;

import java.util.ArrayList;
import java.util.List;

interface Mediator {
    void sendMessage(String message, Member member);
}

class ChatMediator implements Mediator {
    private List<Member> members;
    public ChatMediator() {members = new ArrayList<>();}

    public void addMember(Member member) {members.add(member);}

    @Override
    public void sendMessage(String message, Member sender) {
        for (Member member : members) {
            if (member != sender) {member.receive(message);}
        }
    }
}

abstract class Member {
    private String name;
    private Mediator mediator;

    public Member(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public String getName() {return name;}
    public Mediator getMediator() {return mediator;}
    public void send(String message) {}
    public void receive(String message) {}
}

class ChatMember extends Member {
    public ChatMember(String name, Mediator mediator) {super(name, mediator);}
    @Override
    public void send(String message) {
        System.out.println(getName() + " sends: " + message);
        getMediator().sendMessage(message, this);
    }
    @Override
    public void receive(String message) {System.out.println(getName() + " receives: " + message);}
}

public class MediatorPattern {
    public static void main(String[] args) {
        ChatMediator chatMediator = new ChatMediator();
        Member alice = new ChatMember("Alice", chatMediator);
        Member bob = new ChatMember("Bob", chatMediator);
        Member charlie = new ChatMember("Charlie", chatMediator);
        chatMediator.addMember(alice);
        chatMediator.addMember(bob);
        chatMediator.addMember(charlie);
        alice.send("Hello, everyone!");
    }
}
