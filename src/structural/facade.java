package structural;

import java.util.List;

class Projecter {
    void on() { System.out.println("switch on projecter");}
    void off() { System.out.println("switch off projecter");}
}

class Curtain {
    void open() { System.out.println("open curtains"); }
    void close() { System.out.println("close curtains"); }
}

class Lights {
    void on() { System.out.println("switch on lights");}
    void off() { System.out.println("switch off lights");}
}

class HomeTheater{
    Projecter projecter;
    Curtain curtain;
    Lights lights;

    public HomeTheater(Curtain curtain, Lights lights, Projecter projecter) {
        this.curtain = curtain;
        this.lights = lights;
        this.projecter = projecter;
    }

    void on(){
        this.projecter.on();
        this.lights.on();
        this.curtain.close();
    }
}
public class facade {
    public static void main(String[] args) {
        HomeTheater homeTheater = new HomeTheater(new Curtain(), new Lights(), new Projecter());
        homeTheater.on();
    }
}
