package creational.singleton;

public class Logger {
    private Logger(){
        // sleep to simulate resource-intensive object creation
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {}
    }
    private static Logger instance;
    public static Logger getInstanceNotThreadSafe(){
        if(instance == null){
            instance = new Logger();
        }
        return instance;
    }

    // Thread-safe version
    public synchronized static Logger getInstanceThreadSafe(){
        if(instance == null){
            instance = new Logger();
        }
        return instance;
    }

    // Double-checked locking version
    public static Logger getInstanceDoubleChecked(){
        if(instance == null){
            synchronized (Logger.class) {
                if(instance == null){
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("Log: " + message);
    }
}
