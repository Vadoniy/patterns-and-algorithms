package org.selfstudy.pattern.decorator;

import java.math.BigDecimal;

/**
 * Kind of ConcreteComponent in Decorator pattern scheme
 */
public class Espresso extends Beverage {

    public Espresso() {
        this.description = "Espresso";
    }

    @Override
    public BigDecimal cost() {
        return BigDecimal.valueOf(1.99);
    }
}
