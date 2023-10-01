package org.selfstudy.pattern.decorator;

import java.math.BigDecimal;

/**
 * Kind of ConcreteDecorator in Decorator pattern scheme
 */
public class Whip extends CondimentDecorator {

    public Whip(Beverage beverage) {
        super(beverage);
        this.description = "Whip";
        this.price = BigDecimal.valueOf(0.1);
    }

    public static Beverage addWhipToBeverage(Beverage beverage) {
        return new Whip(beverage);
    }
}
