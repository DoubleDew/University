#include <ArduinoMqttClient.h>
#include <WiFi101.h>
#include "arduino_secrets.h"

WiFiClient wifiClient;
MqttClient mqttClient(wifiClient);
const char broker[] = "test.mosquitto.org";
int port = 1883;
const char topic[] = "real_unique_topic";
const char topic2[] = "real_unique_topic2";
const char topic3[] = "real_unique_topic3";

const long interval = 8000;
unsigned long previousMillis = 0;
int count = 0;

void setup() {
  Serial.begin(9600);
  while(!Serial){
    ;
  }

  Serial.print("Attempting to connect to: ");
  Serial.println(ssid);
  while(WiFi.begin(ssid, pass) != WL_CONNECTED){
    Serial.print(".");
    delay(5000);
  }

  Serial.println("Connected");
  Serial.println();
  Serial.println("Attempting to connect to MQTT broker: ");
  Serial.println(broker);
  if(!mqttClient.connect(broker, port)){
    Serial.println("Failed with error ");
    Serial.println(mqttClient.connectError());
    while(1);
  }
  Serial.println("Connected to broker");
  Serial.println();

void loop() {
  mqttClient.poll();
  unsigned long currentMillis = millis();
  if(currentMillis - previousMillis >= interval){
    previousMillis = currentMillis;
    int Rvalue = analogRead(A0);
    int Rvalue1 = analogRead(A1);
    int Rvalue2 = analogRead(A2);

    Serial.print("Sending message to topic: ");
    Serial.println(topic);
    Serial.println(Rvalue);
    Serial.print("Sending message to topic: ");
    Serial.println(topic2);
    Serial.println(Rvalue2);
    Serial.print("Sending message to topic: ");
    Serial.println(topic3);
    Serial.println(Rvalue3);

    mqttClient.beginMessage(topic);
    mqttClient.print(Rvalue);
    mqttClient.endMessage();
    mqttClient.beginMessage(topic2);
    mqttClient.print(Rvalue2);
    mqttClient.endMessage();
    mqttClient.beginMessage(topic3);
    mqttClient.print(Rvalue3);
    mqttClient.endMessage();
    Serial.println();
  }

}
