package InternalDSL;


public class Actuator extends Device {
    actuatorType actuatorType;

    public Actuator(String name, actuatorType type) {
        super(name);
        actuatorType = type;
    }

    public enum actuatorType {
        DISPLAY,
        RELAY,
        STEPPERMOTOR,
        SERVOMACHINE,
        ELECTROENGINE
    }
}
