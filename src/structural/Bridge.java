package structural;

interface Device {
    void turnOn();
    void turnOff();
    boolean isEnabled();
}
class TV implements Device {
    private boolean on = false;
    @Override
    public void turnOn() {on=true;}

    @Override
    public void turnOff() {on = false;}

    @Override
    public boolean isEnabled() {return on;}
}

abstract class Remote {
    private Device device;
    Remote(Device device) {
        this.device = device; // Default device
    }
    void togglePower(){
        if(device.isEnabled()) device.turnOff();
        else device.turnOn();
    }
}
class AdvancedRemote extends Remote {
    AdvancedRemote(Device device){
        super(device);
    }
    void mute() {
        System.out.println("Muting the device");
    }
}

public class Bridge {
    public static void main(String[] args) {
        Device tv = new TV();
        AdvancedRemote remote = new AdvancedRemote(tv);
        remote.togglePower();
        System.out.println("TV is on: " + tv.isEnabled());
        remote.mute();
        remote.togglePower();
        System.out.println("TV is on: " + tv.isEnabled());
    }
}
