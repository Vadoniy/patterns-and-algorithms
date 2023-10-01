package org.selfstudy.pattern.decorator;

import java.math.BigDecimal;

/**
 * Kind of Component interface in Decorator pattern scheme
 */
public interface Beverage {

    BigDecimal cost();

    String getDescription();
}
