package org.selfstudy.pattern.decorator;

import java.math.BigDecimal;

/**
 * Kind of ConcreteComponent in Decorator pattern scheme
 */
public class Decaf extends Beverage {

    public Decaf() {
        this.description = "Decaffeinated";
    }

    @Override
    public BigDecimal cost() {
        return BigDecimal.valueOf(1.05);
    }
}
