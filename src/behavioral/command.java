package behavioral;

interface Action {
    void execute();
}

enum LightState { ON, OFF }
class Light{
    private LightState st = LightState.OFF;
    private void on() { System.out.println("switching on"); st = LightState.ON; }
    private void off() { System.out.println("switching off"); st = LightState.OFF; }
    public void toggle() {
        if(st == LightState.ON) off();
        else on();
    }
}

class ToggleCommand implements Action{
    private Light light;
    ToggleCommand(Light light) { this.light = light; }
    @Override
    public void execute() { this.light.toggle(); }
}

class Remote {
    Action action;
    Remote(Action action) { this.action = action; }
    void press() { this.action.execute(); }
}

public class command {
    public static void main(String[] args) {
        Light light = new Light();
        Action toggle = new ToggleCommand(light);
        Remote remote = new Remote(toggle);
        remote.press();
        remote.press();
    }
}
