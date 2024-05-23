package org.domain.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import lombok.Getter;
import lombok.Setter;
import org.domain.Calculator;
import org.domain.exception.OperationInvalidException;

import java.util.Objects;

@Getter
@Setter
public class DisplayController  {
    private int operationId;
    private Double temporaryValue = 0.0;
    @FXML
    Calculator calculator = new Calculator();
    @FXML
    private TextField informationText;
    @FXML
    private TextField resultText;

    @FXML
    public void handleNumberAction(javafx.event.ActionEvent actionEvent) {
        Button clickedButton = (Button) actionEvent.getSource();
        resultText.appendText(clickedButton.getText());
    }

    public void handleOptionAction(javafx.event.ActionEvent actionEvent) {
        Button clickedButton = (Button) actionEvent.getSource();
        this.setOperationId(operationOption(clickedButton.getText().charAt(0)));
        attributiveValue();
        informationText.appendText(clickedButton.getText());
    }

    private void attributiveValue(){
        validateValue();
        //se o valor base e resultado forem 0 vai atribuir valor a resultado
        if((calculator.getValueOne() == 0.0 && calculator.getResult() == 0.0)){
            this.setTemporaryValue(Double.parseDouble(resultText.getText()));
            calculator.setValueOne(temporaryValue);
            informationText.setText(Double.toString(calculator.getValueOne()));
            resultText.clear();

        }else {
            iqualOperation();
            informationText.setText(Double.toString(calculator.getValueOne()));
            resultText.clear();
        }
    }
    private int operationOption(char operationOption){
        switch (operationOption){
            case '+':
                return 1;
            case '-':
                return 2;
            case 'X':
                return 3;
            case'/':
                return 4;
            case '%':
                return 5;
            default:
                throw new OperationInvalidException("Invalid Operation !");
        }
    }

    public void inversionButtonAction(ActionEvent actionEvent) {
        this.calculator.setResult(this.calculator.getResult() *-1);
        informationText.setText(Double.toString(calculator.getValueOne()));
    }

    public void decimalButtonAction(ActionEvent actionEvent) {

    }
    private void iqualOperation(){
        setTemporaryValue(Double.parseDouble(resultText.getText()));
        calculator.setValueTwo(this.getTemporaryValue());
        calculator.selectOperation(getOperationId());
        calculator.setValueOne(calculator.getResult());
    }
    private void validateValue(){
        if(Objects.equals(resultText.getText(), "")){
            resultText.setText("0");
        } else if (
                Objects.equals(informationText.getText(),"")){
            informationText.setText("0");
        }
    }

    public void iqualButtonAction(ActionEvent actionEvent) {
        attributiveValue();
    }

    public void clearAllButtonAction(ActionEvent actionEvent) {
        resultText.clear();
        informationText.clear();
        this.calculator.setResult(0.0);
    }

    public void clearButtonAction(ActionEvent actionEvent) {
        resultText.clear();
    }
}
