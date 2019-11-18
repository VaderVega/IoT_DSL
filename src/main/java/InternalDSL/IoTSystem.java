package InternalDSL;

import java.util.ArrayList;
import java.util.List;

public class IoTSystem {
    private List<Device> devices = new ArrayList<>();

    public int getDevicesNumber() {
        return devices.size();
    }

    public List<Device> getDevices() {
        return devices;
    }

    public Device getDevice(int i) {
        return devices.get(i);
    }

    public void addNetworkToDevice(Network.networkType type) {
        devices.get(devices.size() - 1).setNetworkType(type);
    }



    public void addDevice(Device d) {
        devices.add(d);
    }
}
