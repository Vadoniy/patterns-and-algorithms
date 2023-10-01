package org.selfstudy.pattern.decorator;

import java.math.BigDecimal;

/**
 * Kind of ConcreteComponent in Decorator pattern scheme
 */
public class DarkRoast extends Beverage {

    public DarkRoast() {
        this.description = "Dark roasted coffee";
    }

    @Override
    public BigDecimal cost() {
        return BigDecimal.valueOf(0.99);
    }
}
