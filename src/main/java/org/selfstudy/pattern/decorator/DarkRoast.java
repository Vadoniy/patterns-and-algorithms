package org.selfstudy.pattern.decorator;

import java.math.BigDecimal;

/**
 * Kind of ConcreteComponent in Decorator pattern scheme
 */
public class DarkRoast implements Beverage {

    @Override
    public BigDecimal cost() {
        return BigDecimal.valueOf(0.99);
    }

    @Override
    public String getDescription() {
        return "Dark roasted coffee";
    }
}
