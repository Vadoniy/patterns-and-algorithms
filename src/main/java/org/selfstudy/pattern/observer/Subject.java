package org.selfstudy.pattern.observer;

public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
    float getTemperature();
    float getHumidity();
    float getPressure();
}
