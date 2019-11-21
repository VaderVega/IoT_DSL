package InternalDSL;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IoTSystem {
    private String name;

    private StringBuilder includeAndDefineCommands = new StringBuilder();
    private StringBuilder setupPart = new StringBuilder();
    private StringBuilder loopPart = new StringBuilder();



    private List<Device> devices = new ArrayList<>();

    public int getDevicesNumber() {
        return devices.size();
    }

    public List<Device> getDevices() {
        return devices;
    }

    public Device getDevice(int i) {
        return devices.get(i);
    }

    public void addNetworkToDevice(Network.networkType type) {
        devices.get(devices.size() - 1).setNetworkType(type);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addDevice(Device d) {
        devices.add(d);
    }

    private void addNetworkCode(Network.networkType networkType) {
        switch (networkType) {
            case WIFI:
                includeAndDefineCommands.append(
                        "#include <SoftwareSerial.h>\n" +
                        "SoftwareSerial mySerial(8, 9);\n" +
                        "#define WIFI_SERIAL    mySerial\n"
                );
                setupPart.append(
                        "Serial.begin(9600);\n" +
                        "while (!Serial) {  }\n" +
                        "Serial.println(\"Serial init OK);\n" +
                        "WIFI_SERIAL.begin(115200);\n"
                );
                loopPart.append(
                        "if (WIFI_SERIAL.avalaible()) {\n" +
                        "   Serial.write(WIFI_SERIAL.read());\n" +
                        "}\n" +
                        "if (Serial.avaliable()) {\n" +
                        "   WIFI_SERIAL.write(Serial.read());\n" +
                        "}\n"
                );
                break;
            case BLUETOOTH:
                includeAndDefineCommands.append(
                        "#include <SoftwareSerial.h>\n" +
                        "char incomingByte;\n"
                );
                setupPart.append(
                        "Serial.begin(9600);\n" +
                        "Serial.println(Bluetooth connection is working.);\n"
                );
                loopPart.append(
                        "if (Serial.avaliable() > 0) {\n" +
                        "   incomingByte = Serial.read();\n" +
                        "}"
                );
                break;
            case LoRaWAN:
                break;

        }
    }

    private void addSensorCode(Sensor.sensorType sensorType) {
        switch (sensorType) {
            case TEMPERATURE:
                includeAndDefineCommands.append(
                        "#include \"DHT.h\"\n" +
                        "#define DHTPIN 2\n" +
                        "DHT dht(DHTPIN, DHT22);\n"
                );
                setupPart.append(
                        "Serial.begin(9600);\n" +
                        "dht.begin();\n"
                );
                loopPart.append(
                        "float temperature = dht.readTemperature();\n" +
                        "if (isnan(t)) {\n" +
                        "   Serial.printli(\"Temperature reading error.\");\n" +
                        "   return;\n" +
                        "Serial.print(\"Temperature: \");\n" +
                        "Serial.print(t);\n"
                );
                break;
            case LIGHT:
                break;
            case HUMIDITY:
                break;
            case MOVEMENT:
                break;
        }
    }


    private String generateCode() {
        String resultCode = "";
        for (Device d : devices) {
            addNetworkToDevice(d.getNetworkType());
            if (d instanceof Sensor) {
                addSensorCode(((Sensor) d).getSensorType());
            } else if (d instanceof Actuator) {

            }
        }

        return resultCode = includeAndDefineCommands.toString() +
                "void setup() {\n" +
                setupPart.toString() + "\n" +
                "}" + "\n" +
                "void loop() {\n"
                + loopPart.toString() + "\n" +
                "}";
    }

    public void writeCodeToFile(String path) {
        String code = generateCode();
        char [] charCode = code.toCharArray();
        try (FileOutputStream fileOutputStream = new FileOutputStream(path)) {
            for (char c : charCode) {
                fileOutputStream.write(c);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
