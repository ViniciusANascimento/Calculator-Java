package org.domain.operation;

import org.domain.exception.DivideZeroValueException;

public class Divide implements IOperation{
    @Override
    public Double operation(Double valueOne, Double valueTwo) {

        if (valueTwo == 0){
            throw new DivideZeroValueException("No possible divide by zero value !");
        }
        Double result = valueOne / valueTwo;

        return result;
    }
}
