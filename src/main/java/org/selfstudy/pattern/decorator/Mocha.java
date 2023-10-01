package org.selfstudy.pattern.decorator;

import java.math.BigDecimal;

/**
 * Kind of ConcreteDecorator in Decorator pattern scheme
 */
public class Mocha extends CondimentDecorator {

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public BigDecimal cost() {
        return beverage.cost().add(BigDecimal.valueOf(0.2));
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }
}
