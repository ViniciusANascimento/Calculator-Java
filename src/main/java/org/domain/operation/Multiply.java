package org.domain.operation;

import lombok.AllArgsConstructor;

@AllArgsConstructor

public class Multiply implements IOperation {
    @Override
    public Double operation(Double valueOne, Double valueTwo){

        return valueOne * valueTwo;
    }

}
