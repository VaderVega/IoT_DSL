package InternalDSL;

public class SensorBuilder {

    Sensor sensor;

    public SensorBuilder() {
        sensor = new Sensor();
    }

    public static Sensor Sensor(String name, Sensor.sensorType type) {


        return new Sensor();
    }



    public SensorBuilder transmitValueUsing(Network.networkType type) {

        return this;
    }
}
