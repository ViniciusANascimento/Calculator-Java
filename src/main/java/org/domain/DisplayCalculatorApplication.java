package org.domain;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DisplayCalculatorApplication extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        System.out.println(DisplayCalculatorApplication.class.descriptorString());
        //Inserido o caminho de onde o arquivo FXML estava carregando no TARGET
        String caminho = "../../../display/display-calculator.fxml";
        System.out.println(DisplayCalculatorApplication.class.getResource("../../../display/display-calculator.fxml"));
        //Carregando o arquivo do FXML
        FXMLLoader fxmlLoader = new FXMLLoader(DisplayCalculatorApplication.class.getResource(caminho));
        //Configurando o tamanho da tela
        Scene scene = new Scene(fxmlLoader.load(),400,480);
        //Informo que a tela seja ancorada, ou seja, que ela não estoure o tamanho da tela informada.
        fxmlLoader.setRoot(new AnchorPane());
        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
