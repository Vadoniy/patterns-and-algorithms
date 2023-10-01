package org.selfstudy.pattern.decorator;

import java.math.BigDecimal;

/**
 * Kind of Component in Decorator pattern scheme
 */
public abstract class Beverage {

    String description = "Abstract beverage";

    public abstract BigDecimal cost();

    public String getDescription() {
        return description;
    }
}
