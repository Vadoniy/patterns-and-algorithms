package org.selfstudy.pattern.decorator;

import java.math.BigDecimal;

/**
 * Kind of ConcreteDecorator in Decorator pattern scheme
 */
public class Milk extends CondimentDecorator {

    public Milk(Beverage beverage) {
        this.beverage = beverage;
        this.description = "Milk";
        this.price = BigDecimal.valueOf(0.1);
    }

    public static Beverage addMilkToBeverage(Beverage beverage) {
        return new Milk(beverage);
    }
}