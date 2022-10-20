package com.example.calculadora;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    private double operando1 = 0.0;
    private double operando2 = 0.0;
    private double numResultado = 0.0;

    String operacion = "";

    @FXML
    private TextArea resultado;

    @FXML
    private GridPane gridCalculadora;

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

            dos.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    resultado.setText(resultado.getText()+dos.getText());
                }
            });

            tres.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    resultado.setText(resultado.getText()+tres.getText());
                }
            });

            cuatro.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    resultado.setText(resultado.getText()+cuatro.getText());
                }
            });


            cinco.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    resultado.setText(resultado.getText()+cinco.getText());
                }
            });

            seis.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    resultado.setText(resultado.getText()+seis.getText());
                }
            });

            siete.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    resultado.setText(resultado.getText()+siete.getText());
                }
            });

            ocho.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    resultado.setText(resultado.getText()+ocho.getText());
                }
            });

            nueve.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    resultado.setText(resultado.getText()+nueve.getText());
                }
            });

            cero.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    resultado.setText(resultado.getText()+cero.getText());
                }
            });

            ac.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    resultado.setText("");
                }
            });

            sumar.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    operando1 = Double.parseDouble(resultado.getText());
                    resultado.setText("");
                    operacion = "suma";
                }
            });

            restar.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    operando1 = Double.parseDouble(resultado.getText());
                    resultado.setText("");
                    operacion = "resta";
                }
            });

            igual.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    operando2 = Double.parseDouble(resultado.getText());
                    switch (operacion){
                        case "suma":
                            numResultado = operando1+operando2;
                            resultado.setText(String.valueOf(numResultado));
                            break;
                        case "resta":
                            numResultado = operando1-operando2;
                            resultado.setText(String.valueOf(numResultado));
                            break;
                    }
                }
            });

        /*for (Node item:gridCalculadora.getChildren()) {
            if (item instanceof Button){
                ((Button) item).setOnAction(new manejoPulsaciones());
            }
        }*/


    }
    /*class manejoPulsaciones implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent actionEvent) {

        }
    }*/
}