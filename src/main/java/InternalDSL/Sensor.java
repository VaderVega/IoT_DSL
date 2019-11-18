package InternalDSL;



public class Sensor extends Device {
    private sensorType type;


    public Sensor(String name, sensorType type) {
        super(name);
        this.type = type;
    }

    public enum sensorType {
        TEMPERATURE,
        HUMIDITY,
        LIGHT,
        MOVEMENT
    }
}
