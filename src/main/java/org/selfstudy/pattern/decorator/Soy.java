package org.selfstudy.pattern.decorator;

import java.math.BigDecimal;

/**
 * Kind of ConcreteDecorator in Decorator pattern scheme
 */
public class Soy extends CondimentDecorator {

    public Soy(Beverage beverage) {
        super(beverage);
        this.description = "Soy";
        this.price = BigDecimal.valueOf(0.15);
    }

    public static Beverage addSoyToBeverage(Beverage beverage) {
        return new Soy(beverage);
    }
}
