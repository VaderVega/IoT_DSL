package InternalDSL;

public class IoTSystemBuilder {
    private IoTSystem system;

    public IoTSystemBuilder() {
        system = new IoTSystem();
    }

    //Start the IoT DSL with this method:
    public static IoTSystemBuilder IoTSystem(Device... devices) {
        IoTSystem system = new IoTSystem();
        for (Device d : devices)
            system.addDevice(d);

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



}
