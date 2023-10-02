package org.selfstudy.pattern.decorator;

import java.math.BigDecimal;

/**
 * Kind of ConcreteComponent in Decorator pattern scheme
 */
public class Decaf implements Beverage {

    @Override
    public BigDecimal cost() {
        return BigDecimal.valueOf(1.05);
    }

    @Override
    public String getDescription() {
        return "Decaffeinated";
    }
}
