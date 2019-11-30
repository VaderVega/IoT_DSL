package InternalDSL;

import static InternalDSL.Sensor.sensorType.*;
import static InternalDSL.Network.networkType.*;
import static InternalDSL.IoTSystemBuilder.*;
import static InternalDSL.Actuator.actuatorType.*;


public class Main {
    public static void main(String[] args) {

        IoTSystem("Climate control system")
                .sensor(
                        "Temperature sensor 1",
                        TEMPERATURE,
                        12
                )
                    .transmitValueUsing(BLUETOOTH)
                .sensor(
                        "Temperature sensor 2",
                        TEMPERATURE,
                        12
                )
                    .transmitValueUsing(BLUETOOTH)
                .sensor(
                        "Temperature sensor 3",
                        TEMPERATURE,
                        11
                )
                    .transmitValueUsing(BLUETOOTH)
                .sensor(
                        "Movement sensor",
                        MOVEMENT,
                        8
                )
                    .transmitValueUsing(LoRaWAN)
                .sensor(
                        "Humidity sensor",
                        HUMIDITY,
                        9
                )
                    .transmitValueUsing(WIFI)
                .actuator(
                        "Window opener",
                        STEPPERMOTOR
                        )
                    .recieveValueUsing(WIFI)
                .generateCode("src/main/resources/");


    }

}
