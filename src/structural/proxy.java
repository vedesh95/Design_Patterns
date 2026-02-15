package structural;

interface Resource { void display(); }

class Image implements Resource{
    Image(String filename) { System.out.println("Loading... Resource Intensive Process "); }
    @Override
    public void display(){ System.out.println("Displaying image"); }
}

class ProxyImage implements Resource{
    private Image image;
    private String fileName;
    ProxyImage(String fileName) { this.fileName = fileName; }
    @Override
    public void display(){
        image = new Image(fileName);
        image.display();
    }
}

/*
* Provide a surrogate or placeholder for another object to control access to it.
*
* The real object is expensive to create or access (e.g., network, file, DB).
* You want to control or enhance access to the object.
* You need to add cross-cutting concerns (like logging, security, caching).
*
* Adds controlled access to objects
* Enables lazy loading, caching, or security easily
* */
public class proxy {
    public static void main(String[] args) {
        ProxyImage image = new ProxyImage("name.png");
        // image is actually loaded only when calling display
        image.display();
    }
}
