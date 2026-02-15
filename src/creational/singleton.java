package creational;


class Cache{
    private Cache(){}
    private static Cache instance;

    public static Cache getInstance() {
        if (instance == null) {
            instance = new Cache();
        }
        return instance;
    }

    // thread-safe but may have performance issues due to synchronization overhead.
    public static synchronized Cache getInstanceSynchronized() {
        if (instance == null) {
            instance = new Cache();
        }
        return instance;
    }

    // double-checked locking
    public static Cache getInstanceDoubleChecked() {
        if (instance == null) {
            synchronized (Cache.class) {
                if (instance == null) {
                    instance = new Cache();
                }
            }
        }
        return instance;
    }

}

public class singleton { }
