package com.example.alvaro_sanchez_ruiz_examen;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.google.gson.Gson;

public class RegistroController implements Initializable {
    @FXML
    private Button buttonRegistrar, buttonCerrar;

    @FXML
    private TextField textFieldNombreRegistro, textFieldPassRegistro, textFieldEmailRegistro, textFieldTlfRegistro;

    @FXML
    private ComboBox<String> comboBoxRegistro;

    ObservableList<String> listaCombo = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            rellenarComboBox();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        buttonRegistrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String nombre = textFieldNombreRegistro.getText();
                String pass = textFieldPassRegistro.getText();
                String email = textFieldEmailRegistro.getText();
                int tlf = Integer.parseInt(textFieldTlfRegistro.getText());
                String rol = comboBoxRegistro.getValue();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
                try {
                    Parent parent = fxmlLoader.load();
                    HelloController helloController = fxmlLoader.getController();
                    helloController.listaPersonas.add(new Persona(nombre, pass, email, tlf, rol));
                    System.out.println("Registrado correctamente");

                    helloController.mostrarPersonas();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        buttonCerrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

            }
        });
    }

    private void rellenarComboBox() throws IOException {
        String url = "https://run.mocky.io/v3/48686b58-bd41-4f13-92c5-1fba0c56e74d";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        System.out.println(response.toString());

        Gson gson = new Gson();
        ArrayList<String> opciones = gson.fromJson(response.toString(), ArrayList.class);

        for (String string: opciones) {
            listaCombo.add(string);
        }

        comboBoxRegistro.setItems(listaCombo);
    }
}
