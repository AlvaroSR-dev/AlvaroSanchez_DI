package com.example.calculadora;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private TextArea resultado;

    @FXML
    private Button sci, registro, uno, dos, tres, cuatro, cinco, seis, siete, ocho, nueve, cero, ac, positivoNegativo, modulo, dividir, multiplicar, restar, sumar, igual, numeroE, decimal;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            uno.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    resultado.setText(resultado.getText()+uno.getText());
                }
            });
    }
}