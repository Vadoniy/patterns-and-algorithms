package org.selfstudy.pattern.decorator;

import java.math.BigDecimal;
import java.util.StringJoiner;

/**
 * Kind of Decorator abstract class/interface in Decorator pattern scheme.
 * In the example abstract class is used for fields declaration.
 */
public abstract class CondimentDecorator implements Beverage {
    Beverage beverage;
    String description;
    BigDecimal price;

    public CondimentDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return new StringJoiner(", ").add(beverage.getDescription()).add(description).toString();
    }

    @Override
    public BigDecimal cost() {
        if (price == null) {
            return beverage.cost();
        }
        return beverage.cost().add(price);
    }
}
