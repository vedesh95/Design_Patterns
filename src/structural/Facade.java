package structural;

class Amplifier {
    void on() {System.out.println("Amplifier is ON");}
    void off() {System.out.println("Amplifier is OFF");}
    void setVolume(int level) {System.out.println("Amplifier volume set to " + level);}
}
class Tuner {
    void on() {System.out.println("Tuner is ON");}
    void off() {System.out.println("Tuner is OFF");}
    void setFrequency(double frequency) {System.out.println("Tuner frequency set to " + frequency);}
}
class DVDPlayer {
    void on() {System.out.println("DVD Player is ON");}
    void off() {System.out.println("DVD Player is OFF");}
    void play(String movie) {System.out.println("Playing movie: " + movie);}
    void stop() {System.out.println("Stopping movie");}
}
class Projector {
    void on() {System.out.println("Projector is ON");}
    void off() {System.out.println("Projector is OFF");}
    void setInput(String input) {System.out.println("Projector input set to " + input);}
}

class HomeTheaterFacade {
    private Amplifier amp;
    private Tuner tuner;
    private DVDPlayer dvd;
    private Projector projector;

    public HomeTheaterFacade(Amplifier amp, Tuner tuner, DVDPlayer dvd, Projector projector) {
        this.amp = amp;
        this.tuner = tuner;
        this.dvd = dvd;
        this.projector = projector;
    }

    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        projector.on();
        projector.setInput("low light");
        amp.on();
        amp.setVolume(10);
        tuner.on();
        tuner.setFrequency(101.1);
        dvd.on();
        dvd.play(movie);
    }

    public void endMovie() {
        System.out.println("Shutting movie theater down...");
        dvd.stop();
        dvd.off();
        tuner.off();
        amp.off();
        projector.off();
    }
}

public class Facade {
    public static void main(String[] args) {
        Amplifier amp = new Amplifier();
        Tuner tuner = new Tuner();
        DVDPlayer dvd = new DVDPlayer();
        Projector projector = new Projector();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(amp, tuner, dvd, projector);
        homeTheater.watchMovie("Inception");
        System.out.println("... Movie is playing ...");
        homeTheater.endMovie();
    }
}

