package InternalDSL;

public class IoTSystemBuilder {
    private IoTSystem system;

    public IoTSystemBuilder() {
        system = new IoTSystem();
    }

    //Start the IoT DSL with this method:
    public static IoTSystemBuilder IoTSystem(String name) {
        IoTSystem system = new IoTSystem();
        system.setName(name);

        return new IoTSystemBuilder();
    }

    public IoTSystemBuilder sensor(String name, Sensor.sensorType type) {
        system.addDevice(new Sensor(name, type));
        return this;
    }

    public IoTSystemBuilder transmitValueUsing(Network.networkType type) {
        system.addNetworkToDevice(type);
        return this;
    }

    public IoTSystemBuilder actuator(String name, Actuator.actuatorType type) {
        system.addDevice(new Actuator(name, type));
        return this;
    }

    public IoTSystemBuilder recieveValueUsing(Network.networkType type) {
        system.addNetworkToDevice(type);
        return this;
    }

    public IoTSystemBuilder generateCode(String path) {
        system.writeCodeToFile(path);
        return this;
    }



}
