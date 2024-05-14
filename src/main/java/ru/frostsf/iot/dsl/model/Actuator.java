package ru.frostsf.iot.dsl.model;


import java.util.Arrays;
import java.util.List;


public class Actuator extends Device {
    private actuatorType actuatorType;
    private List<Integer> portNumbers;

    public Actuator(String name, actuatorType type, int... ports) {
        super(name);
        actuatorType = type;
        Arrays.stream(ports).forEach(s->portNumbers.add(s));

    }

    public Actuator.actuatorType getActuatorType() {
        return actuatorType;
    }

    public List<Integer> getPort() {
        return portNumbers;
    }

    public String getName() {
        return super.getName().replaceAll(" ","");
    }

    public enum actuatorType {
        DISPLAY,
        RELAY,
        STEPPERMOTOR,
        SERVOMACHINE,
        ELECTROENGINE
    }
}
