package behavioral;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Editor {
    private String content = "";
    History history = new History();

    public void type(String words) {this.content += words;}
    public String getContent() { return content; }
    public void save() { history.push(new Memento(content)); }
    public void restore() {
        Memento memento = history.pop();
        if (memento != null) {content = memento.getContent();}
    }
}
class Memento {
    private final String content;
    public Memento(String content) { this.content = content; }
    public String getContent() { return content; }
}
class History {
    private final Stack<Memento> history = new Stack<>();
    public void push(Memento memento) { history.push(memento); }
    public Memento pop() {
        if (!history.isEmpty()) return history.pop();
        return null;
    }
}
public class MementoPattern {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.type("This is the first sentence. ");
        editor.save();
        editor.type("This is the second sentence. ");
        editor.save();
        editor.type("This is the third sentence. ");
        editor.restore();
        System.out.println("After 1st Undo: " + editor.getContent());
        editor.restore();
        System.out.println("After 2ndse Undo: " + editor.getContent());

        Map<String, String> sampleMap = new HashMap<>();
        sampleMap.put("key1", "value1");
        sampleMap.put("key2", "value2");
        System.out.println("Sample Map: " + sampleMap);


    }
}