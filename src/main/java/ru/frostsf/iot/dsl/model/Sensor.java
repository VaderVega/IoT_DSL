package ru.frostsf.iot.dsl.model;


public class Sensor extends Device {
    private sensorType type;
    int port;


    public Sensor(String name, sensorType type, int port) {
        super(name);
        this.type = type;
        this.port = port;
    }

    public int getPort() {
        return port;
    }

    public String getName() {
        return super.getName().replaceAll(" ","");
    }

    public sensorType getSensorType() {
        return type;
    }

    public enum sensorType {
        TEMPERATURE,
        HUMIDITY,
        LIGHT,
        MOVEMENT
    }
}
