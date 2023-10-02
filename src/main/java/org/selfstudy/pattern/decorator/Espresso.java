package org.selfstudy.pattern.decorator;

import java.math.BigDecimal;

/**
 * Kind of ConcreteComponent in Decorator pattern scheme
 */
public class Espresso implements Beverage {

    @Override
    public BigDecimal cost() {
        return BigDecimal.valueOf(1.99);
    }

    @Override
    public String getDescription() {
        return "Espresso";
    }
}
