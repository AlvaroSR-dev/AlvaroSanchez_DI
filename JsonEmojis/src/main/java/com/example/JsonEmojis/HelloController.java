package com.example.JsonEmojis;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import org.json.*;


public class HelloController implements Initializable {

    @FXML
    private Button buttonJSON, buttonAleatorio;

    @FXML
    private ComboBox comboBoxCategorias, comboBoxEmoji;

    @FXML
    private TableView tablaEmojis;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        acciones();
        rellenarCombo();
    }

    private void rellenarCombo() {
        String urlQuery = "https://emoji-api.com/categories?access_key=5d0bc3e4a0fa08cf9d12548e5a765033f40f0734";
        try {
            URL url = new URL(urlQuery);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            InputStream strm = connection.getInputStream();
            byte[] arrStream=strm.readAllBytes();
            String cntJson = "";
            for(byte tmp: arrStream){
                cntJson+=(char)tmp;
            }
            JSONArray json = new JSONArray(cntJson);
            for(Object obj: json){
                comboBoxCategorias.getItems().add(((JSONObject)obj).get("slug"));
                System.out.println(((JSONObject)obj).get("slug"));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private void rellenarComboEmojis() {
        try {
            comboBoxEmoji.getItems().clear();
            String urlQuery = "https://emoji-api.com/categories/" + comboBoxCategorias.getValue().toString() + "?access_key=5d0bc3e4a0fa08cf9d12548e5a765033f40f0734";
            URL url = new URL(urlQuery);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            InputStream strm = connection.getInputStream();
            byte[] arrStream=strm.readAllBytes();
            String cntJson = "";
            for(byte tmp: arrStream){
                cntJson+=(char)tmp;
            }
            JSONArray json = new JSONArray(cntJson);
            for(Object obj: json){
                comboBoxEmoji.getItems().add(((JSONObject)obj).get("slug"));
                System.out.println(((JSONObject)obj).get("slug"));
            }
            json.clear();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void acciones() {
        buttonAleatorio.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String urlQuery = "https://emoji-api.com/emojis?access_key=5d0bc3e4a0fa08cf9d12548e5a765033f40f0734";
                try {
                    URL url = new URL(urlQuery);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    InputStream strm = connection.getInputStream();
                    byte[] arrStream=strm.readAllBytes();
                    String cntJson = "";
                    for(byte tmp: arrStream){
                        cntJson+=(char)tmp;
                    }
                    JSONArray json = new JSONArray(cntJson);
                    int aleatorio = (int) (Math.random() * (json.length() + 1));
                    Object obj = json.get(aleatorio);
                    System.out.println(((JSONObject)obj).get("slug"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        comboBoxCategorias.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (comboBoxCategorias != null && comboBoxCategorias.getValue() != null){
                    rellenarComboEmojis();
                }else {
                    System.out.println("Es nulo");
                }
            }
        });

        buttonJSON.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String urlQuery = "https://emoji-api.com/emojis/" + comboBoxCategorias.getValue().toString() + "?access_key=5d0bc3e4a0fa08cf9d12548e5a765033f40f0734";
                try {
                    URL url = new URL(urlQuery);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    InputStream strm = connection.getInputStream();
                    byte[] arrStream=strm.readAllBytes();
                    String cntJson = "";
                    for(byte tmp: arrStream){
                        cntJson+=(char)tmp;
                    }
                    JSONArray json = new JSONArray(cntJson);
                    for(Object obj: json){
                        String nombre = (String) ((JSONObject)obj).get("slug");
                        String categoria = (String) ((JSONObject)obj).get("group");
                        String emoji = (String) ((JSONObject)obj).get("character");
                        /*tablaEmojis.getItems().add(0, "nombre");
                        tablaEmojis.getItems().add(1, "Hola");
                        tablaEmojis.getItems().add(2, "Hola");*/
                        System.out.println(nombre + " " + categoria + " " + emoji);
                    }
                    json.clear();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}