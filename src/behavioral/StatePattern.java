package behavioral;

interface State {
    void handle(Context context);
}
class OnState implements State {
    @Override
    public void handle(Context context) {
        System.out.println("The device is ON.");
        context.setState(new OffState());
    }
}
class OffState implements State {
    @Override
    public void handle(Context context) {
        System.out.println("The device is OFF.");
        context.setState(new OnState());
    }
}
class Context {
    private State state;
    public Context(State state) {this.state = state;}
    public void setState(State state) {this.state = state;}
    public void request() {state.handle(this);}
}
public class StatePattern {
    public static void main(String[] args) {
        Context context = new Context(new OffState());
        context.request(); // The device is OFF.
        context.request(); // The device is ON.
        context.request(); // The device is OFF.
    }
}
