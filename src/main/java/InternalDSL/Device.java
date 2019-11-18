package InternalDSL;

import java.util.HashSet;
import java.util.Set;

public class Device {
    private String name;
    private double value;
    private Set<Network.networkType> networkType = new HashSet<>();

    public Device(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setNetworkType(Network.networkType type) {
        networkType.add(type);
    }
}
