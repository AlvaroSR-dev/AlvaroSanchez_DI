package com.example.alvaro_sanchez_ruiz_examen;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TablaController implements Initializable {
    @FXML
    TableView tablaPersonas;

    @FXML
    TableColumn columnaNombre, columnaCorreo, columnaRol;

    @FXML
    MenuItem menuGuest, menuUser, menuDeveloper, menuTest, menuAll;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        crearDatos();

        menuGuest.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

            }
        });
    }

    private void crearDatos() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        try {
            Parent parent = fxmlLoader.load();
            HelloController helloController = fxmlLoader.getController();
            columnaNombre.setCellValueFactory(new PropertyValueFactory<Persona, String>("nombre"));
            columnaCorreo.setCellValueFactory(new PropertyValueFactory<Persona, String>("correo"));
            columnaRol.setCellValueFactory(new PropertyValueFactory<Persona, String>("rol"));

            for (int i = 0; i < helloController.listaPersonas.size(); i++) {
                tablaPersonas.getItems().add(helloController.listaPersonas.get(i));
            }
            tablaPersonas.setItems(helloController.listaPersonas);
            System.out.println("Agregados");

            helloController.mostrarPersonas();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
