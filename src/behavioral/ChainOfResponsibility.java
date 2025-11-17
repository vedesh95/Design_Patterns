package behavioral;
abstract class Logger{
    public static int ERROR = 3;
    public static int DEBUG = 2;
    public static int INFO = 1;
    protected int level;
    Logger(int level) {this.level = level;}
    protected Logger nextLogger;

    public void logMessage(int level, String message) {
        if(this.level == level) {write(message);return;}
        if(nextLogger != null) {nextLogger.logMessage(level,message);}
    }
    abstract protected void write(String message);
    public void setNextLogger(Logger nextLogger) {this.nextLogger = nextLogger;}
}

class ErrorLogger extends Logger{
    ErrorLogger(int level) {super(level);}
    @Override
    protected void write(String message) {System.out.println("Error: " + message);}
}

class DebugLogger extends Logger{
    DebugLogger(int level) {super(level);}
    @Override
    protected void write(String message) {System.out.println("Debug: " + message);}
}

class InfoLogger extends Logger{
    InfoLogger(int level) {super(level);}
    @Override
    protected void write(String message) {System.out.println("Info: " + message);}
}

public class ChainOfResponsibility {
    public static void main(String[] args) {
        Logger errorLogger = new ErrorLogger(Logger.ERROR);
        Logger debugLogger = new DebugLogger(Logger.DEBUG);
        Logger infoLogger = new InfoLogger(Logger.INFO);

        errorLogger.setNextLogger(debugLogger);
        debugLogger.setNextLogger(infoLogger);

        errorLogger.logMessage(Logger.INFO, "This is an information.");
        errorLogger.logMessage(Logger.DEBUG, "This is a debug level information.");
        errorLogger.logMessage(Logger.ERROR, "This is an error information.");
    }
}
