#include <SPI.h>
#include <WiFi101.h>

char ssid[] = "DoubleDew";
char pass[] = "doubledew!";
int keyIndex = 0;
int status = WL_IDLE_STATUS;
WiFiServer server(80);

WiFiClient client = server.available();

int ledPin = 2;

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  pinMode(ledPin, OUTPUT);
  while(!Serial);

  enableWiFi();
  connectWiFi();

  server.begin();
  printWiFiStatus();
}

void loop() {
  // put your main code here, to run repeatedly:
  client = server.available();

  if(client){
    printWEB();
  }
}

void printWiFiStatus(){
  Serial.print("SSID: ");
  Serial.println(WiFi.SSID());

  IPAddress ip = WiFi.localIP();
  Serial.print("IP Address: ");
  Serial.println(ip);

  long rssi = WiFi.RSSI();
  Serial.print("signal strength (RSSI):");
  Serial.print(rssi);
  Serial.println(" dBm");

  Serial.print("Open: ");
  Serial.println(ip);
}

void enableWiFi(){
  String fv = WiFi.firmwareVersion();
  if(fv < "1.0.0"){
    Serial.println("Upgrade");
  }
}

void connectWiFi(){
  while(status != WL_CONNECTED){
    Serial.print("Attempting to connect to: ");
    Serial.println(ssid);
    status = WiFi.begin(ssid, pass);

    delay(10000);
  }
}

void printWEB(){
  if(client){
    Serial.println("new client");
    String currentLine = "";
    while(client.connected()){
      if(client.available()){
        char c = client.read();
        Serial.write(c);
        if(c == '\n'){
          if(currentLine.length() == 0){
            client.println("HTTP/1.1 200 OK");
            client.println("Content-type:text/html");
            client.println();

            client.print("Click <a href=\"/H\">here</a> to turn the LED on<br>");
            client.print("Click <a href=\"/L\">here</a> to turn the LED off<br><br>");

            int randomReading = analogRead(A1);
            client.print("Random reading from analog pin:");
            client.print(randomReading);

            client.println();
            break;
          }else{
            currentLine = "";
          }
        }else if(c != '\r'){
          currentLine += c;
        }

        if(currentLine.endsWith("Get /H")) digitalWrite(ledPin, HIGH);
        if(currentLine.endsWith("Get /L")) digitalWrite(ledPin, LOW);
      }
    }

    client.stop();
    Serial.println("Client disconnected.");
  }
}