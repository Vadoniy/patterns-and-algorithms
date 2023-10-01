package org.selfstudy.pattern.decorator;

import java.math.BigDecimal;

/**
 * Kind of ConcreteDecorator in Decorator pattern scheme
 */
public class Mocha extends CondimentDecorator {

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
        this.description = "Mocha";
        this.price = BigDecimal.valueOf(0.2);
    }

    public static Beverage addMochaToBeverage(Beverage beverage) {
        return new Mocha(beverage);
    }
}
