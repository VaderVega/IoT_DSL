package InternalDSL;

import java.util.HashSet;
import java.util.Set;

public class Device {
    private String name;
    private double value;
    private Network.networkType networkType;

    public Device(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public void setNetworkType(Network.networkType type) {
        networkType = type;
    }

    public Network.networkType getNetworkType() {
        return networkType;
    }
}
