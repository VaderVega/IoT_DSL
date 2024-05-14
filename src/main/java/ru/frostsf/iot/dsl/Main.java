package ru.frostsf.iot.dsl;

import static ru.frostsf.iot.dsl.model.Sensor.sensorType.*;

import ru.frostsf.iot.dsl.model.Actuator.actuatorType;
import ru.frostsf.iot.dsl.model.Network.networkType;
import ru.frostsf.iot.dsl.generator.IoTSystemBuilder;


public class Main {
    public static void main(String[] args) {

        IoTSystemBuilder.IoTSystem("Climate control system")
                .sensor(
                        "Temperature sensor 1",
                        TEMPERATURE,
                        12
                )
                    .transmitValueUsing(networkType.BLUETOOTH)
                .sensor(
                        "Temperature sensor 2",
                        TEMPERATURE,
                        12
                )
                    .transmitValueUsing(networkType.BLUETOOTH)
                .sensor(
                        "Temperature sensor 3",
                        TEMPERATURE,
                        11
                )
                    .transmitValueUsing(networkType.BLUETOOTH)
                .sensor(
                        "Movement sensor",
                        MOVEMENT,
                        8
                )
                    .transmitValueUsing(networkType.LoRaWAN)
                .actuator(
                        "Window opener",
                        actuatorType.STEPPERMOTOR,
                        8,9,10,11)
                    .recieveValueUsing(networkType.WIFI)
                .generateCode("src/main/resources/");


    }

}
