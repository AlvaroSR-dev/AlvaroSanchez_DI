package com.example.calculadora;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javax.script.*;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    int numResultado = 0;
    ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
    ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("Nashorn");

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

            sumar.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    resultado.setText(resultado.getText()+sumar.getText());
                }
            });

            restar.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    resultado.setText(resultado.getText()+restar.getText());
                }
            });



            igual.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    try {
                        numResultado = (int) scriptEngine.eval(resultado.getText());
                    } catch (ScriptException e) {
                        e.printStackTrace();
                    }

                    System.out.println(numResultado);
                }
            });
    }
}