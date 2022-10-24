package com.example.calculadora;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import java.io.*;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    private double operando1 = 0.0;
    private double operando2 = 0.0;
    private double numResultado = 0.0;

    String operacion = "";

    @FXML
    private TextArea resultado, registroArea;

    @FXML
    private GridPane gridCalculadora, panelSci, panelRegistro;

    @FXML
    private BorderPane borderPane;

    @FXML
    private Button sci, registro, uno, dos, tres, cuatro, cinco, seis, siete, ocho, nueve, cero, ac, positivoNegativo, modulo, dividir, multiplicar, restar, sumar, igual, numeroE, decimal, cerrarSci, sin, x, raiz, elevado, ln, e, cerrarRegistro, borrarRegistro;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            borderPane.getChildren().remove(panelSci);
            borderPane.getChildren().remove(panelRegistro);
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

            decimal.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    resultado.setText(resultado.getText()+decimal.getText());
                }
            });

            positivoNegativo.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    String[] resultadoSplit = resultado.getText().split("");
                    if (resultadoSplit[0] == "-"){
                        
                    }
                }
            });

            ac.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    resultado.setText("");
                }
            });

            sci.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    borderPane.setLeft(panelSci);
                }
            });

            cerrarSci.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    borderPane.getChildren().remove(panelSci);
                }
            });

            cerrarRegistro.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    borderPane.getChildren().remove(panelRegistro);
                }
            });

            registro.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    borderPane.setRight(panelRegistro);
                }
            });

            sumar.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    operando1 = Double.parseDouble(resultado.getText());
                    resultado.setText("");
                    operacion = "sumar";
                }
            });

            restar.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    operando1 = Double.parseDouble(resultado.getText());
                    resultado.setText("");
                    operacion = "restar";
                }
            });

            multiplicar.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    operando1 = Double.parseDouble(resultado.getText());
                    resultado.setText("");
                    operacion = "multiplicar";
                }
            });

            dividir.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    operando1 = Double.parseDouble(resultado.getText());
                    resultado.setText("");
                    operacion = "dividir";
                }
            });

            modulo.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    operando1 = Double.parseDouble(resultado.getText());
                    resultado.setText("");
                    operacion = "modulo";
                }
            });

            igual.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    operando2 = Double.parseDouble(resultado.getText());
                    switch (operacion){
                        case "sumar":
                            numResultado = operando1+operando2;
                            resultado.setText(String.valueOf(numResultado));
                            break;
                        case "restar":
                            numResultado = operando1-operando2;
                            resultado.setText(String.valueOf(numResultado));
                            break;
                        case "multiplicar":
                            numResultado = operando1*operando2;
                            resultado.setText(String.valueOf(numResultado));
                            break;
                        case "dividir":
                            numResultado = operando1/operando2;
                            resultado.setText(String.valueOf(numResultado));
                            break;
                        case "modulo":
                            numResultado = operando1%operando2;
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