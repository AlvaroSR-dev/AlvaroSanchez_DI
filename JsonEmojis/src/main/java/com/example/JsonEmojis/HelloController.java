package com.example.JsonEmojis;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.json.*;


public class HelloController implements Initializable {

    @FXML
    private Button buttonJSON, buttonAleatorio, buttonDetalles;

    @FXML
    private ComboBox comboBoxCategorias, comboBoxEmoji;

    @FXML
    private TableView<Emoji> tablaEmojis;

    @FXML
    private TableColumn columnaNombre, columnaCategoria, columnaEmoji;

    @FXML
    private MenuItem menuCerrar, menuApi, menuGithub;

    ObservableList<Emoji> observableListEmojis;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        acciones();
        rellenarCombo();
        tablaEmojis.setEditable(true);
        observableListEmojis = FXCollections.observableArrayList();
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
                if (((JSONObject) obj).get("slug").equals("component") == false){
                    comboBoxCategorias.getItems().add(((JSONObject)obj).get("slug"));
                    System.out.println(((JSONObject)obj).get("slug"));
                }
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
                String nombre = "";
                String categoria = "";
                String codigo = "";
                Emoji emoji = new Emoji();
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

                    nombre = (String) ((JSONObject)obj).get("slug");
                    categoria = (String) ((JSONObject)obj).get("group");
                    codigo = (String) ((JSONObject)obj).get("character");
                    emoji = new Emoji(nombre, categoria, codigo);
                    observableListEmojis.add(emoji);

                    tablaEmojis.setItems(observableListEmojis);
                    columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
                    columnaCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
                    columnaEmoji.setCellValueFactory(new PropertyValueFactory<>("unicode"));


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
                String nombre = "";
                String categoria = "";
                String codigo = "";
                Emoji emoji = new Emoji();
                String urlQuery = "https://emoji-api.com/emojis/" + comboBoxEmoji.getValue().toString() + "?access_key=5d0bc3e4a0fa08cf9d12548e5a765033f40f0734";
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
                        if (((JSONObject)obj).get("slug").equals(comboBoxEmoji.getValue().toString())){
                            nombre = (String) ((JSONObject)obj).get("slug");
                            categoria = (String) ((JSONObject)obj).get("group");
                            codigo = (String) ((JSONObject)obj).get("character");
                            emoji = new Emoji(nombre, categoria, codigo);
                            observableListEmojis.add(emoji);

                            tablaEmojis.setItems(observableListEmojis);
                            columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
                            columnaCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
                            columnaEmoji.setCellValueFactory(new PropertyValueFactory<>("unicode"));
                        }
                    }
                    System.out.println(nombre + " " + categoria + " " + codigo);
                    json.clear();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        buttonDetalles.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (tablaEmojis.getSelectionModel().getSelectedIndex()>-1){
                    Stage ventanaDetalle = new Stage();
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("detalles.fxml"));

                    Scene scene = null;
                    try {
                        Parent parent = fxmlLoader.load();
                        scene = new Scene(parent,400,400);
                        Detalles detailController = fxmlLoader.getController();
                        detailController.setearAlumno(tablaEmojis.getSelectionModel().getSelectedItem());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    ventanaDetalle.setScene(scene);
                    ventanaDetalle.show();
                }else {
                    System.out.println("No hay nada seleccionado");
                }
            }
        });

        menuApi.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    Runtime.getRuntime().exec(new String[]{"cmd", "/c","start chrome https://emoji-api.com/"});
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        menuGithub.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    Runtime.getRuntime().exec(new String[]{"cmd", "/c","start chrome https://github.com/AlvaroSR-dev/AlvaroSanchez_DI/tree/master/JsonEmojis"});
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        menuCerrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
    }
}