package org.domain;

import lombok.Getter;
import lombok.Setter;
import org.domain.exception.DivideZeroValueException;
import org.domain.exception.OperationInvalidException;
import org.domain.operation.Divide;
import org.domain.operation.Minus;
import org.domain.operation.Multiply;
import org.domain.operation.Sum;

import java.util.InputMismatchException;
import java.util.Scanner;

@Setter
@Getter
public class Calculator {
    private Double valueOne = 0.0;
    private Double valueTwo = 0.0;
    private Double result = 0.0;
    private int option;

    private Sum sum = new Sum();
    private Minus minus = new Minus();
    private Multiply multiply = new Multiply();
    private Divide divide = new Divide();

    public Double selectOperation(int option){
        switch (option){
            //Sum
            case  1:
                //sum
                return this.result = sum.operation(this.valueOne,this.valueTwo);
            case 2:
                //minus
                return this.result = minus.operation(this.valueOne,this.valueTwo);
            case 3:
                //multiply
                return this.result = multiply.operation(this.valueOne,this.valueTwo);
            case 4:
                //divide
                try {
                    return this.result = divide.operation(this.valueOne, this.valueTwo);
                }catch (DivideZeroValueException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 5:
                //percent code
            case 6:
                System.out.println("Thank you for using the calculator :) ");
                break;
            default:
               throw new OperationInvalidException("Operation Invalid !");
        };
        return 0.0;
    }

    public void calculatorOperation(){
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Please select you operation : ");
            System.out.println(" 1 - Sum, 2 - Minus, 3 - Multiply, 4 - Divide !");
            try {
                setOption(scanner.nextInt());

                if (!verifyOperation()) break;

                applicationRunning();
                System.out.println("Please, enter next value");
                setValueTwo(scanner.nextDouble());


                selectOperation(this.option);

                System.out.println("Result : " + getResult());
                System.out.println("Continue ? 1 - Yes, 2 - No");
                continueApplication(scanner.nextInt());
            }
            catch (InputMismatchException e){
                throw  new OperationInvalidException("Invalid operation !");
            }
        }while (this.option != 6);

    }
    private boolean verifyOperation(){
        if(this.option > 5){
            setOption(0);
            selectOperation(getOption());
            return false;
        }
        return true;
    }
    private void continueApplication(int operationContinue){
        if(operationContinue == 2)
        {
            System.out.println("Thank you !");
            setOption(5);
        } else if (operationContinue == 1) {
            System.out.println("OK, continue application");
        }
        else{
            System.out.println("Invalid Operation");
            System.out.println("Continue ? 1 - Yes, 2 - No");
            Scanner scanner = new Scanner(System.in);
            continueApplication(scanner.nextInt());
        }
    }

    private void applicationRunning(){
        if(this.result == null ){
            System.out.println("Please, enter the value");
            Scanner scanner = new Scanner(System.in);
            setValueOne(scanner.nextDouble());
        }else{
            setValueOne(getResult());
        }
    }
}
