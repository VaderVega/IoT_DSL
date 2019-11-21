#include "DHT.h"
#define DHTPIN 2
DHT dht(DHTPIN, DHT22);
#include "DHT.h"
#define DHTPIN 2
DHT dht(DHTPIN, DHT22);
#include "DHT.h"
#define DHTPIN 2
DHT dht(DHTPIN, DHT22);
void setup() {
Serial.begin(9600);
dht.begin();
Serial.begin(9600);
dht.begin();
Serial.begin(9600);
dht.begin();

}
void loop() {
float temperature = dht.readTemperature();
if (isnan(t)) {
   Serial.printli("Temperature reading error.");
   return;
Serial.print("Temperature: ");
Serial.print(t);
float temperature = dht.readTemperature();
if (isnan(t)) {
   Serial.printli("Temperature reading error.");
   return;
Serial.print("Temperature: ");
Serial.print(t);
float temperature = dht.readTemperature();
if (isnan(t)) {
   Serial.printli("Temperature reading error.");
   return;
Serial.print("Temperature: ");
Serial.print(t);

}