package structural;

interface Image{
    void display();
}

class RealImage {
    RealImage(String filename) {
        loadFromDisk(filename);
    }
    private void loadFromDisk(String filename) {}
    void display() {System.out.println("Displaying image");}
}

class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;
    ProxyImage(String filename) {this.filename = filename;}

    @Override
    public void display() {
        if(realImage == null) realImage = new RealImage(filename);
        realImage.display();
    }
}

public class Proxy {
    public static void main(String[] args) {
        Image image = new ProxyImage("test_image.jpg");
        // Image will be loaded from disk only when display is called
        image.display();
    }
}
