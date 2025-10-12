package creational.singleton;

public class Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstanceNotThreadSafe();
        Logger threadSafeLogger1 = Logger.getInstanceThreadSafe();
        Logger doubleCheckedLogger1 = Logger.getInstanceDoubleChecked();
    }
}
