package behavioral;

abstract class DataProcessor {
    public void process() {
        readData();
        processData();
        writeData();
    }
    protected void readData(){
        System.out.println("Reading data");
    }
    protected abstract void processData();
    protected abstract void writeData();
}

class CSVDataProcessor extends DataProcessor {
    @Override
    protected void processData() { System.out.println("Processing CSV data"); }
    @Override
    protected void writeData() { System.out.println("Writing CSV data"); }
}

class JSONDataProcessor extends DataProcessor {
    @Override
    protected void processData() { System.out.println("Processing JSON data"); }
    @Override
    protected void writeData() { System.out.println("Writing JSON data"); }
}

public class template {
    public static void main(String[] args) {
        DataProcessor csvProcessor = new CSVDataProcessor();
        csvProcessor.process();
        System.out.println();
        DataProcessor jsonProcessor = new JSONDataProcessor();
        jsonProcessor.process();
    }
}
