package org.selfstudy.pattern.decorator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class DecoratorUnitTest {

    @Test
    public void test() {
        final var beverage1 = new Espresso();
        Assertions.assertEquals(BigDecimal.valueOf(1.99), beverage1.cost());
        Assertions.assertEquals("Espresso $1.99", beverage1.getDescription() + " $" + beverage1.cost());

        final var beverage2 = Whip.addWhipToBeverage(Mocha.addMochaToBeverage(Mocha.addMochaToBeverage(new DarkRoast())));
        Assertions.assertEquals(BigDecimal.valueOf(1.49), beverage2.cost());
        Assertions.assertEquals("Dark roasted coffee, Mocha, Mocha, Whip $1.49", beverage2.getDescription() + " $" + beverage2.cost());

        final var beverage3 = Whip.addWhipToBeverage(Mocha.addMochaToBeverage(Soy.addSoyToBeverage(new HouseBlend())));

        Assertions.assertEquals("House blend coffee, Soy, Mocha, Whip $1.34", beverage3.getDescription() + " $" + beverage3.cost());
        Assertions.assertEquals(BigDecimal.valueOf(1.34), beverage3.cost());

        final var beverage4 = Whip.addWhipToBeverage(Milk.addMilkToBeverage(Mocha.addMochaToBeverage(new Decaf())));
        Assertions.assertEquals("Decaffeinated, Mocha, Milk, Whip $1.45", beverage4.getDescription() + " $" + beverage4.cost());
        Assertions.assertEquals(BigDecimal.valueOf(1.45), beverage4.cost());
    }
}
