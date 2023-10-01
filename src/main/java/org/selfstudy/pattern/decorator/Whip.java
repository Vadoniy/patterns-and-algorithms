package org.selfstudy.pattern.decorator;

import java.math.BigDecimal;

/**
 * Kind of ConcreteDecorator in Decorator pattern scheme
 */
public class Whip extends CondimentDecorator {

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public BigDecimal cost() {
        return beverage.cost().add(BigDecimal.valueOf(0.1));
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }
}
