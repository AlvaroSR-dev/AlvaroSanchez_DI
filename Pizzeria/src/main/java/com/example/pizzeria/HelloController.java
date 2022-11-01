package com.example.pizzeria;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    String sizeSeleccion = "null";
    ArrayList<Pedido> listaPedidos = new ArrayList<Pedido>();

    @FXML
    private Button buttonRealizar;

    @FXML
    private TextField nombreCliente, tlfCliente;

    @FXML
    private MenuButton seleccionarPizza;

    @FXML
    private MenuItem seleccionarBarbacoa, seleccionarHawaiana, seleccionarJamon, seleccionarCuatro;

    @FXML
    private RadioButton sizePeque, sizeMediana, sizeFamiliar;

    @FXML
    private TextArea textAreaPedidos;

    @FXML
    private HBox sizeGrupo;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (MenuItem menuItem : seleccionarPizza.getItems()) {
            menuItem.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    seleccionarPizza.setText(menuItem.getText());
                }
            });
        }

        buttonRealizar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // Crear pizza
                Pizza pizza = new Pizza(seleccionarPizza.getText(), sizeSeleccion);
                pizza.crearPizza();
                pizza.mostrarDatos();
                // Crear pedido
                Pedido pedido = new Pedido((listaPedidos.size() + 1), Integer.parseInt(tlfCliente.getText()), nombreCliente.getText(), pizza);
                listaPedidos.add(pedido);
                pedido.mostrarDatos();
                // Limpiar campos
                nombreCliente.setText("");
                tlfCliente.setText("");
                seleccionarPizza.setText("Seleccionar");
                sizePeque.setSelected(false);
                sizeMediana.setSelected(false);
                sizeFamiliar.setSelected(false);
                // Mostrar pedido en Text Area
                textAreaPedidos.setText(textAreaPedidos.getText() + pedido.datos());
            }
        });
    }
}