package org.selfstudy.pattern.decorator;

/**
 * Kind of Decorator in Decorator pattern scheme
 */
public abstract class CondimentDecorator extends Beverage {

    Beverage beverage;

    public abstract String getDescription();
}
