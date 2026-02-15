package behavioral;

import java.util.ArrayList;
import java.util.List;

class Member {
    private String name;
    private Mediate mediate;
    public Member(String name, Mediate mediate) { this.name = name; this.mediate = mediate; }

    public void send(String message) { mediate.send(message); }
    public void receive(String message) { System.out.println(this.name + " received: " + message); }

}

interface Mediate {
    void send(String message);
    void addMember(Member member);
}

class ChatMediate implements Mediate {
    private List<Member> members;
    public ChatMediate() { this.members = new ArrayList<>(); }

    public void addMember(Member member) { members.add(member); }
    @Override
    public void send(String message) {
        for(Member member : members) {member.receive(message);}
    }
}

public class mediator {
    public static void main(String[] args) {
        Mediate mediate = new ChatMediate();
        Member m1 = new Member("Alice", mediate);
        Member m2 = new Member("Bob", mediate);
        mediate.addMember(m1);
        mediate.addMember(m2);

        m1.send("Hello, Bob!");
    }
}
