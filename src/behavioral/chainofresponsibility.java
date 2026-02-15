package behavioral;

enum LOG_LEVEL {
    INFO, WARN, ERROR
}

abstract class Logger {
    protected Logger next;
    LOG_LEVEL level;
    public void log(String message, LOG_LEVEL level) {
        if (this.level == level) { System.out.println(this.level + ": "  + message); }
        else if (next != null) { next.log(message, level); }
    }
    public void setNext(Logger next) { this.next = next; }
    public void handle(String message, LOG_LEVEL level) { log(message, level); }
}

class ErrorLogger extends Logger {
    ErrorLogger(Logger next) { this.next = next; this.level = LOG_LEVEL.ERROR; }
}

class WarnLogger extends Logger {
    WarnLogger(Logger next) { this.next = next; this.level = LOG_LEVEL.WARN; }
}

class InfoLogger extends Logger {
    InfoLogger(Logger next) { this.next = next; this.level = LOG_LEVEL.INFO; }
}

public class chainofresponsibility {
    public static void main(String[] args) {
        Logger logger = new InfoLogger(new WarnLogger(new ErrorLogger(null)));
        logger.handle("This is an info message", LOG_LEVEL.INFO);
        logger.handle("This is a warning message", LOG_LEVEL.WARN);
        logger.handle("This is an error message", LOG_LEVEL.ERROR);
    }
}
