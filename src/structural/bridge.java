package structural;



/*
* avoid permutation explosion of subclasses. N remotes and M devices → N × M classes
* Both abstraction and implementation may change over time.
* */

interface Device{
    void toggle();
}
// added over time
interface AdvanceDevice extends Device {
    void mute();
}

enum DeviceStatus { ON, OFF};

class Radio implements Device{
    DeviceStatus st = DeviceStatus.OFF;
    @Override
    public void toggle() {st = st == DeviceStatus.ON ? DeviceStatus.OFF : DeviceStatus.ON;}
}

class TV implements AdvanceDevice{
    DeviceStatus st = DeviceStatus.OFF;
    @Override
    public void toggle() {st = st == DeviceStatus.ON ? DeviceStatus.OFF : DeviceStatus.ON;}

    @Override
    public void mute() { System.out.println("muting");}
}

abstract class Remote {
    Device device;
    Remote(Device device) {this.device = device;}
    void toggle() {device.toggle();}
}

// added over time
class AdvancedRemote extends Remote{
    Device device;
    AdvancedRemote(Device device) {super(device);}
    void mute(){
        ((AdvanceDevice) device).mute();
    }
}
public class bridge {
    public static void main(String[] args) {
        Device device = new TV();
        Remote remote = new AdvancedRemote(device);
        ((AdvanceDevice) device).mute();
    }
}
