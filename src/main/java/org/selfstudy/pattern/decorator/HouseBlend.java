package org.selfstudy.pattern.decorator;

import java.math.BigDecimal;

/**
 * Kind of ConcreteComponent in Decorator pattern scheme
 */
public class HouseBlend implements Beverage {

    @Override
    public BigDecimal cost() {
        return BigDecimal.valueOf(0.89);
    }

    @Override
    public String getDescription() {
        return "House blend coffee";
    }
}