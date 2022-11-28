package com.example.JsonEmojis;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleButton;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class Detalles implements Initializable {
    Emoji emoji = new Emoji();
    @FXML
    private ListView listViewDetalles;

    @FXML
    private ToggleButton buttonMostrarDetalles;

    @FXML
    private Text textEmoji;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        acciones();
    }

    public void setearAlumno(Emoji e){
        emoji = e;
        listViewDetalles.getItems().add(e.nombre);
        listViewDetalles.getItems().add(e.categoria);
        listViewDetalles.getItems().add(e.unicode);
    }

    public void acciones(){
        buttonMostrarDetalles.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (buttonMostrarDetalles.isSelected()){
                    textEmoji.setText(emoji.getUnicode());
                    System.out.println("Pulsado");
                }else {
                    textEmoji.setText("");
                }
            }
        });
    }
}
