package org.selfstudy.pattern.decorator;

import java.math.BigDecimal;

/**
 * Kind of ConcreteComponent in Decorator pattern scheme
 */
public class HouseBlend extends Beverage {

    public HouseBlend() {
        this.description = "House blend coffee";
    }

    @Override
    public BigDecimal cost() {
        return BigDecimal.valueOf(0.89);
    }
}
