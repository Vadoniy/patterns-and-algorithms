package org.selfstudy.pattern.decorator;

import java.math.BigDecimal;

/**
 * Kind of ConcreteDecorator in Decorator pattern scheme
 */
public class Soy extends CondimentDecorator {

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public BigDecimal cost() {
        return beverage.cost().add(BigDecimal.valueOf(0.15));
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }
}
