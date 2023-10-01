package org.selfstudy.pattern.observer;

public interface Observer {

    void update(float temperature, float humidity, float pressure);

    void update();
}
