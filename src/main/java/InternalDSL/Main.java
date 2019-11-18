package InternalDSL;

import static InternalDSL.Sensor.sensorType.*;
import static InternalDSL.Network.networkType.*;
import static InternalDSL.IoTSystemBuilder.*;
import static InternalDSL.Actuator.actuatorType.*;


public class Main {
    public static void main(String[] args) {

        IoTSystem()
                .sensor(
                        "Temperature sensor 1",
                        TEMPERATURE
                )
                    .transmitValueUsing(BLUETOOTH)
                .sensor(
                        "Temperature sensor 2",
                        TEMPERATURE
                )
                    .transmitValueUsing(BLUETOOTH)
                .sensor(
                        "Temperature sensor 3",
                        TEMPERATURE
                )
                    .transmitValueUsing(BLUETOOTH)
                .sensor(
                        "Movement sensor",
                        MOVEMENT
                )
                    .transmitValueUsing(LoRaWAN)
                .sensor(
                        "Humidity sensor",
                        HUMIDITY
                )
                    .transmitValueUsing(WIFI)
                .actuator(
                        "Window opener",
                        STEPPERMOTOR
                        )
                    .recieveValueUsing(WIFI);




    }

}
