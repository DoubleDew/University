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

  mqttClient.onMessage(onMqttMessage);
  Serial.println("Subscribing to topic: ");
  Serial.println(topic);
  Serial.println();
  mqttClient.subscribe(topic);
  mqttClient.subscribe(topic2);
  mqttClient.subscribe(topic3);

  Serial.println("Topic: ");
  Serial.println(topic);
  Serial.println("Topic: ");
  Serial.println(topic2);
  Serial.println("Topic: ");
  Serial.println(topic3);
  Serial.println();

}

void loop() {
  mqttClient.poll();
}

void onMqttMessage(int messageSize){
  Serial.println("Recieved a message with topic: '");
  Serial.print(mqttClient.messageTopic());
  Serial.print("', length ");
  Serial.print(messageSize);
  Serial.println(" bytes:");
  while(mqttClient.available()){
    Serial.print((char)mqttClient.read());
  }

  Serial.println();
  Serial.println();
}