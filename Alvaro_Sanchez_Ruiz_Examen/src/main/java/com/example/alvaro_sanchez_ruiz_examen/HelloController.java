package com.example.alvaro_sanchez_ruiz_examen;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Button buttonRegistro, buttonAcceder;

    @FXML
    private TextField textFieldUsuario, textFieldPass;

    ObservableList<Persona> listaPersonas = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listaPersonas.add(new Persona("Admin", "admin1234", "admin@admin.es", 0000, "Admin"));

        buttonRegistro.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage ventanaDetalle = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("registro-view.fxml"));

                Scene scene = null;
                try {
                    Parent parent = fxmlLoader.load();
                    scene = new Scene(parent,600,400);
                    RegistroController registroController = fxmlLoader.getController();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                ventanaDetalle.setScene(scene);
                ventanaDetalle.show();
            }
        });

        buttonAcceder.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String rol = "";
                for (Persona item : listaPersonas) {
                    if (textFieldUsuario.getText().equals(item.getNombre()) && textFieldPass.getText().equals(item.getPass())){
                        rol = item.getRol();
                    }else{
                        System.out.println("Datos incorrectos");
                    }
                }

                System.out.println(rol);

                if (rol.equals("Admin")){
                    Stage ventanaDetalle = new Stage();
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("tabla-view.fxml"));

                    Scene scene = null;
                    try {
                        Parent parent = fxmlLoader.load();
                        scene = new Scene(parent,600,800);
                        TablaController tablaController = fxmlLoader.getController();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    ventanaDetalle.setScene(scene);
                    ventanaDetalle.show();
                }else{
                    System.out.println("Permisos insuficientes");
                }
            }
        });
    }

    public void agregarPersona(Persona persona){
        listaPersonas.add(persona);
    }

    public void mostrarPersonas(){
        for (Persona persona: listaPersonas) {
            System.out.println("[Persona]");
            System.out.println("Nombre: " + persona.getNombre());
            System.out.println("Pass: " + persona.getPass());
            System.out.println("Email: " + persona.getCorreo());
            System.out.println("Teléfono: " + persona.getTlf());
            System.out.println("Rol: " + persona.getRol());
        }
    }
}