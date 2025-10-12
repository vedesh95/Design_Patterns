package structural;

import java.util.HashMap;
import java.util.Map;

class Style {
    private String color;
    private int font;
    private int size;
    public Style(String color, int font, int size) {
        this.color = color;
        this.font = font;
        this.size = size;
    }
    public String getColor() {return color;}
    public int getFont() {return font;}
    public int getSize() {return size;}
}

class FlyweightFactory {
    private static final Map<String, Style> styles = new HashMap<>();
    public static Style getStyle(String color, int font, int size) {
        String key = color + font + size;
        if(!styles.containsKey(key)) styles.put(key, new Style(color, font, size));
        return styles.get(key);
    }
}

class Character {
    private char symbol;
    private Style style; // intrinsic(shared)
    private int x;
    private int y; // extrinsic
    public Character(char symbol, Style style) {
        this.symbol = symbol;
        this.style = style;
    }
    public void display(int x, int y) {
        System.out.println("Character: " + symbol + " at (" + x + "," + y + ") with style [Color: " + style.getColor() + ", Font: " + style.getFont() + ", Size: " + style.getSize() + "]");
    }
}
public class Flyweight {
    public static void main(String[] args) {
        String document = "ABCA";
        int x = 0, y = 0;
        for(char c : document.toCharArray()) {
            Style style = FlyweightFactory.getStyle("Red", 12, 14);
            Character character = new Character(c, style);
            character.display(x, y);
            x += 10; // Increment x for next character
        }
    }
}
