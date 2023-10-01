package org.selfstudy.pattern.observer;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CurrentConditionDisplay implements Observer, DisplayElement {
    final Logger log = Logger.getLogger(CurrentConditionDisplay.class.getName());
    private float temperature;
    private float humidity;
    private Subject weatherData;

    public CurrentConditionDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        log.setLevel(Level.INFO);
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        log.log(Level.INFO, """
                Current conditions:
                temperature: {0} C degrees
                humidity: {1}% humidity""", new Float[]{temperature, humidity});
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    @Override
    public void update() {
        this.temperature = weatherData.getTemperature();
        this.humidity = weatherData.getHumidity();
        display();
    }
}
