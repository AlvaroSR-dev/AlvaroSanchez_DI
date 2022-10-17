package com.pestanias.pestanias;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    // elementos gráficos
    @FXML
    private TabPane panelPestanias;
    @FXML
    private Button botonNormal, botonNormalDos, calcular;

    @FXML
    private ToggleButton botonToggle;
    private DropShadow sombraExterior;

    @FXML
    private RadioButton radio1, radio2, radio3, suma, resta, mult;

    @FXML
    private  TextField textField, num1, num2;

    @FXML
    private Text resultado;

    private ToggleGroup grupoRadios;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // se ejecuca cuando se asocia la parte grafica y la logica --> setContentView


        instancias();
        configurarBotones();
        acciones();


    }

    private void configurarBotones() {
        // ImageView --> Image
        botonNormal.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("power_on.png"))));
        botonNormal.setBackground(null);

        botonNormalDos.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("power_off.png"))));
        botonNormalDos.setBackground(null);
    }

    private void instancias() {
        sombraExterior = new DropShadow();
        grupoRadios = new ToggleGroup();
        grupoRadios.getToggles().addAll(radio1, radio2, radio3);
    }

    private void acciones() {
        botonNormal.setOnAction(new ManejoPulsaciones());
        botonNormalDos.setOnAction(new ManejoPulsaciones());
        botonNormal.addEventHandler(MouseEvent.MOUSE_ENTERED, new ManejoRaton());
        botonNormal.addEventHandler(MouseEvent.MOUSE_EXITED, new ManejoRaton());
        botonNormalDos.addEventHandler(MouseEvent.MOUSE_ENTERED, new ManejoRaton());
        botonNormalDos.addEventHandler(MouseEvent.MOUSE_EXITED, new ManejoRaton());
        botonNormal.addEventHandler(MouseEvent.MOUSE_CLICKED, new ManejoRaton());
        botonNormal.addEventHandler(MouseEvent.MOUSE_PRESSED, new ManejoRaton());
        botonToggle.setOnAction(new ManejoPulsaciones());
        botonToggle.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {

            }
        });
    }

    class ManejoRaton implements EventHandler<MouseEvent>{
        @Override
        public void handle(MouseEvent mouseEvent) {

            if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED){
                //System.out.println("Evento raton entrante");
                if (mouseEvent.getSource() == botonNormal){
                    botonNormal.setEffect(sombraExterior);
                } else if (mouseEvent.getSource() == botonNormalDos){
                    botonNormalDos.setEffect(sombraExterior);
                }
            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_EXITED){
                //System.out.println("Evento raton saliente");
                if (mouseEvent.getSource() == botonNormal){
                    botonNormal.setEffect(null);
                } else if (mouseEvent.getSource() == botonNormalDos){
                    botonNormalDos.setEffect(null);
                }
            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_CLICKED){
                botonNormal.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("power_on.png"))));
            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_PRESSED){
                botonNormal.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("power_off.png"))));
            }
        }
    }

    class ManejoPulsaciones implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent actionEvent) {
            //System.out.println("Boton pulsado");
            if (actionEvent.getSource() == botonNormal){
                System.out.println("El boton que ha pulsado ha sido el uno");
            } else if (actionEvent.getSource() == botonNormalDos){
                System.out.println("El boton que ha pulsado ha sido el dos");

            } else if (actionEvent.getSource() == botonToggle){
                System.out.println(botonToggle.isSelected());
                botonNormal.setDisable(botonToggle.isSelected());
                botonNormalDos.setDisable(botonToggle.isSelected());
            }
        }
    }

    private void calculadora(){

    }
}