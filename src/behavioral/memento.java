package behavioral;

import java.util.Stack;

class Editor {
    private String content;
    private History history;
    Editor() {this.content = "";this.history = new History();}
    String getContent() { return this.content; }
    public void undo() {this.content=history.restore();}
    public void update(String content) {
        this.content = this.content + content;
        history.add(this.content);
    }

}

class History{
    private Stack<String> st;
    History() { this.st = new Stack<>(); }
    String restore() {st.pop();return st.pop();}
    void add(String content) {st.add(content);}
}
public class memento {
    public static void main(String[] args) {
        Editor e = new Editor();
        e.update("a");
        e.update("b");
        System.out.println(e.getContent());
        e.undo();
        System.out.println(e.getContent());
    }
}
