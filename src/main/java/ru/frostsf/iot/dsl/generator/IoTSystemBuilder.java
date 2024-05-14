package ru.frostsf.iot.dsl.generator;

import ru.frostsf.iot.dsl.model.Actuator;
import ru.frostsf.iot.dsl.model.Network;
import ru.frostsf.iot.dsl.model.Sensor;

public class IoTSystemBuilder {
    private IoTSystem system;

    public IoTSystemBuilder() {
        system = new IoTSystem();
    }

    public static IoTSystemBuilder IoTSystem(String name) {
        IoTSystem system = new IoTSystem();
        system.setName(name);

        return new IoTSystemBuilder();
    }

    public IoTSystemBuilder sensor(String name, Sensor.sensorType type, int portNumber) {
        system.addDevice(new Sensor(name, type, portNumber));
        return this;
    }

    public IoTSystemBuilder transmitValueUsing(Network.networkType type) {
        system.addNetworkToDevice(type);
        return this;
    }

    public IoTSystemBuilder actuator(String name, Actuator.actuatorType type, int ... portNumbers) {
        system.addDevice(new Actuator(name, type, portNumbers));
        return this;
    }

    public IoTSystemBuilder recieveValueUsing(Network.networkType type) {
        system.addNetworkToDevice(type);
        return this;
    }

    public IoTSystemBuilder generateCode(String path) {
        system.generateCode(path);
        return this;
    }



}
