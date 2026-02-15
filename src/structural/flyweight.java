package structural;

import java.util.HashMap;
import java.util.Map;

class Style {
    String color;
    int font;
    int size;
}

class StyleMap {
    private static final Map<String, Style> styles = new HashMap<>();
    public static Style getStyle(String key) { return styles.get(key); }
    public static void addStyle(Style style) {
        String key = style.color + style.font + style.size;
        styles.put(key, style);
    }
}

class Character {
    char c;
    Style style;
    Character(char c, Style style) {
        this.c = c;
        this.style = style;
    }

    public void display() {
        System.out.println("character: " + c + " color: " + style.color + " font: " + style.font + " size: " + style.size);
    }
}

public class flyweight {
    public static void main(String[] args) {
        Style s = new Style();
        s.color = "red";s.font = 1;s.size = 12;
        StyleMap.addStyle(s);

        Character c = new Character('a', StyleMap.getStyle("red112"));
        c.display();
    }
}
