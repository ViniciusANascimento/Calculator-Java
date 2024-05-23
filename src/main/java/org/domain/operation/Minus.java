package org.domain.operation;

public class Minus implements IOperation{
    @Override
    public Double operation(Double valueOne, Double valueTwo) {

        return valueOne - valueTwo;
    }
}
