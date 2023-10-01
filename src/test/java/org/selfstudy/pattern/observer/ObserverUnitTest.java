package org.selfstudy.pattern.observer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class ObserverUnitTest {

    @Test
    public void test() {
        final var weatherData = new ObservableWeatherData();
        final var currentConditionDisplay = new CurrentConditionDisplay(weatherData);
        final var statisticsDisplay = new StatisticsDisplay(weatherData);

        final var loggerCurrent = Logger.getLogger(CurrentConditionDisplay.class.getName());
        final var handlerCurrent = new TestLogHandler();
        handlerCurrent.setLevel(Level.INFO);
        loggerCurrent.addHandler(handlerCurrent);

        final var loggerStatistics = Logger.getLogger(StatisticsDisplay.class.getName());
        final var handlerStatistics = new TestLogHandler();
        handlerStatistics.setLevel(Level.INFO);
        loggerStatistics.addHandler(handlerStatistics);

        final var random = new Random();
        final var testTemperature = random.nextFloat(200);
        final var testHumidity = random.nextFloat(100);
        final var testPressure = random.nextFloat(800);
        weatherData.setMeasurements(testTemperature, testHumidity, testPressure);


        List<LogRecord> currentLogRecords = handlerCurrent.getLogRecords();
        Assertions.assertEquals(currentLogRecords.size(), 1);
        Assertions.assertTrue(Arrays.stream(currentLogRecords.get(0).getParameters()).anyMatch(o -> (float) o == testTemperature));
        Assertions.assertTrue(Arrays.stream(currentLogRecords.get(0).getParameters()).anyMatch(o -> (float) o == testHumidity));
        Assertions.assertFalse(Arrays.stream(currentLogRecords.get(0).getParameters()).anyMatch(o -> (float) o == testPressure));

        List<LogRecord> statisticsLogRecords = handlerStatistics.getLogRecords();
        Assertions.assertEquals(statisticsLogRecords.size(), 1);
    }

    class TestLogHandler extends Handler {
        private final List<String> logMessages = new ArrayList<>();
        private final List<LogRecord> logRecords = new ArrayList<>();

        @Override
        public void publish(LogRecord record) {
            logMessages.add(record.getMessage());
            logRecords.add(record);
        }

        @Override
        public void flush() {
        }

        @Override
        public void close() throws SecurityException {
        }

        public List<String> getLogMessages() {
            return logMessages;
        }

        public List<LogRecord> getLogRecords() {
            return logRecords;
        }
    }
}
