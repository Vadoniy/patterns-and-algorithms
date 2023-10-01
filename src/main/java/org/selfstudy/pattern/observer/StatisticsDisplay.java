package org.selfstudy.pattern.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StatisticsDisplay implements Observer, DisplayElement {
    final Logger log = Logger.getLogger(StatisticsDisplay.class.getName());
    private final List<Float> temperatureStats = new ArrayList<>();
    private final List<Float> humidityStats = new ArrayList<>();
    private final List<Float> pressureStats = new ArrayList<>();
    private Subject weatherData;

    public StatisticsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        log.setLevel(Level.INFO);
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        final var averageTemperature = temperatureStats.stream().mapToDouble(Float::doubleValue).sum() / temperatureStats.size();
        final var averageHumidity = humidityStats.stream().mapToDouble(Float::doubleValue).sum() / humidityStats.size();
        final var averagePressure = pressureStats.stream().mapToDouble(Float::doubleValue).sum() / pressureStats.size();
        log.log(Level.INFO, """
                        Statistic for last {0} conditions:
                        Average temperature: {1} C degrees
                        Average humidity: {2}% humidity
                        Average pressure: {3}% humidity""",
                new String[]{String.valueOf(temperatureStats.size()),
                        String.valueOf(averageTemperature),
                        String.valueOf(averageHumidity),
                        String.valueOf(averagePressure)});
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        temperatureStats.add(temperature);
        humidityStats.add(humidity);
        pressureStats.add(pressure);
        display();
    }

    @Override
    public void update() {
        temperatureStats.add(weatherData.getTemperature());
        humidityStats.add(weatherData.getHumidity());
        pressureStats.add(weatherData.getPressure());
        display();
    }
}
