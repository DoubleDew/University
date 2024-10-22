#include <arduinoFFT.h>
#include <FastLED.h>

#define SAMPLES 128             // Must be a power of 2
#define SAMPLING_FREQUENCY 40000 // Sampling frequency
#define MIC_IN A0               // Use A0 for mic input
#define LED_PIN 2               // Data pin to LEDS
#define NUM_LEDS 36             // Total number of LEDs
#define BRIGHTNESS 150          // LED brightness
#define LED_TYPE WS2811
#define COLOR_ORDER GRB 
#define xres 6                  // Number of columns in the display
#define yres 6                  // Number of rows in the display
#define SMOOTHING_FACTOR 0.8    // Smoothing factor for frequency stabilization

double vReal[SAMPLES];
double vImag[SAMPLES];
double peakFrequency = 0.0;    // Variable to store peak frequency
double peakAmplitude = 0.0;    // Variable to store peak amplitude
double smoothedFrequency = 0.0; // Smoothed peak frequency
unsigned long previousMillis = 0;
const long interval = 200;     // Interval for updating LED display (in milliseconds)

CRGB leds[NUM_LEDS];           // Create LED object
ArduinoFFT<double> FFT = ArduinoFFT<double>();  // Create FFT object

void setup() {
  pinMode(MIC_IN, INPUT);
  Serial.begin(115200);           // Initialize Serial
  delay(3000);                    // Power-up safety delay
  FastLED.addLeds<LED_TYPE, LED_PIN, COLOR_ORDER>(leds, NUM_LEDS).setCorrection(TypicalLEDStrip); // Initialize LED strip
  FastLED.setBrightness(BRIGHTNESS);
}

void loop() {
  unsigned long currentMillis = millis();
  if (currentMillis - previousMillis >= interval) {
    previousMillis = currentMillis;
    Visualizer(); 
    FastLED.show();
    delay(200);
  }
}

void Visualizer() {
  // Collect Samples
  getSamples();
  
  // Update Display
  displayUpdate();
}

void getSamples() {
  unsigned long sampling_period_us = round(1000000*(1.0/SAMPLING_FREQUENCY)); // Calculate every sampling period in microseconds
  for(int i = 0; i < SAMPLES; i++) {
    unsigned long startMicros = micros();
    vReal[i] = analogRead(MIC_IN);
    vImag[i] = 0;
    while(micros() - startMicros < sampling_period_us){
      // Wait to maintain the sampling frequency
    }
  }

  // FFT
  FFT.windowing(vReal, SAMPLES, FFT_WIN_TYP_HAMMING, FFT_FORWARD);
  FFT.compute(vReal, vImag, SAMPLES, FFT_FORWARD);
  FFT.complexToMagnitude(vReal, vImag, SAMPLES);

  // Find peak frequency and amplitude
  peakFrequency = 0.0;
  peakAmplitude = 0.0;
  for(int i = 2; i < SAMPLES/2; i++) {
    double magnitude = vReal[i];
    if (magnitude > peakAmplitude) {
      peakAmplitude = magnitude;
      peakFrequency = (i * 1.0 * SAMPLING_FREQUENCY) / SAMPLES; // Calculate frequency in Hz
    }
  }

  // Apply smoothing to the frequency
  smoothedFrequency = (SMOOTHING_FACTOR * smoothedFrequency) + ((1.0 - SMOOTHING_FACTOR) * peakFrequency);
}

void displayUpdate() {
  // Check if peak frequency is within the specified range and amplitude is above the threshold
  if (smoothedFrequency >= 500 && smoothedFrequency <= 3000) {
    int color;
    if (smoothedFrequency >= 500 && smoothedFrequency < 950) {
      color = map(smoothedFrequency, 500, 850, 0, 42); // Red to yellow
    } else if (smoothedFrequency >= 951 && smoothedFrequency < 1350) {
      color = map(smoothedFrequency, 951, 1350, 43, 85); // Yellow to green
    } else if (smoothedFrequency >= 1351 && smoothedFrequency < 1750) {
      color = map(smoothedFrequency, 1351, 1750, 86, 128); // Green to cyan
    } else if (smoothedFrequency >= 1751 && smoothedFrequency < 2150) {
      color = map(smoothedFrequency, 1751, 2150, 129, 170); // Cyan to blue
    } else if (smoothedFrequency >= 2151 && smoothedFrequency < 2550) {
      color = map(smoothedFrequency, 2151, 2550, 171, 213); // Blue to magenta
    } else {
      color = map(smoothedFrequency, 2551, 2900, 214, 255); // Magenta to red
    }

    int intensity = map(peakAmplitude, 0, 1024, 0, yres); // Map amplitude to LED intensity

    Serial.print("Peak Frequency: ");
    Serial.print(peakFrequency);
    Serial.print(" Hz, Smoothed Frequency: ");
    Serial.print(smoothedFrequency);
    Serial.print(" Hz, Hue: ");
    Serial.println(color);

    // Update LEDs based on intensity
    for(int i = 0; i < NUM_LEDS; i++) {
      if (i % xres < intensity) {
        leds[i] = CHSV(color, 255, BRIGHTNESS); // Set LED color and brightness
      } else {  
        leds[i] = CRGB::Black; // Turn off LEDs if intensity is lower than LED position
      }
    }
  } else {
    // If peak frequency is outside the specified range or amplitude is below the threshold, turn off all LEDs
    for(int i = 0; i < NUM_LEDS; i++) {
      leds[i] = CRGB::Black;
    }
  }
}
