package com.example.pizzeria;

import java.util.ArrayList;

public class Pizza {
    String nombre, sizePizza;
    int precio;
    ArrayList<Ingrediente> ingredientes;

    public Pizza() {
    }

    public Pizza(String nombre, String sizePizza) {
        this.nombre = nombre;
        this.sizePizza = sizePizza;
        this.precio = precio;
        this.ingredientes = new ArrayList<Ingrediente>();
    }

    public void crearPizza(){
        switch (nombre){
            case "Barbacoa":
                ingredientes.add(new Ingrediente("Bacon"));
                ingredientes.add(new Ingrediente("Salsa barbacoa"));
                ingredientes.add(new Ingrediente("Maíz"));
                ingredientes.add(new Ingrediente("Cebolla"));
                ingredientes.add(new Ingrediente("Carne"));

                if (sizePizza == "Pequeña"){
                    precio = 7;
                }else if (sizePizza == "Mediana"){
                    precio = 12;
                }else if (sizePizza == "Familiar"){
                    precio = 15;
                }

                break;
            case "Hawaiana":
                ingredientes.add(new Ingrediente("Piña"));
                ingredientes.add(new Ingrediente("Jamón"));
                ingredientes.add(new Ingrediente("Salsa"));

                if (sizePizza == "Pequeña"){
                    precio = 5;
                }else if (sizePizza == "Mediana"){
                    precio = 10;
                }else if (sizePizza == "Familiar"){
                    precio = 13;
                }

                break;
            case "Jamón y queso":
                ingredientes.add(new Ingrediente("Jamón"));
                ingredientes.add(new Ingrediente("Queso"));

                if (sizePizza == "Pequeña"){
                    precio = 4;
                }else if (sizePizza == "Mediana"){
                    precio = 8;
                }else if (sizePizza == "Familiar"){
                    precio = 10;
                }

                break;
            case "Cuatro quesos":
                ingredientes.add(new Ingrediente("Queso gorgonzola"));
                ingredientes.add(new Ingrediente("Queso parmesano"));
                ingredientes.add(new Ingrediente("Queso roquefort"));
                ingredientes.add(new Ingrediente("Queso gouda"));

                if (sizePizza == "Pequeña"){
                    precio = 8;
                }else if (sizePizza == "Mediana"){
                    precio = 13;
                }else if (sizePizza == "Familiar"){
                    precio = 17;
                }

                break;
        }
    }

    public void mostrarDatos(){
        System.out.println("Pizza: " + nombre);
        System.out.println("Tamaño: " + sizePizza);
        System.out.println("Precio: " + precio);
        System.out.println("Ingredientes: ");
        for (Ingrediente ingrediente:ingredientes) {
            System.out.println(" - " + ingrediente.getNombre());
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSize() {
        return sizePizza;
    }

    public void setSize(String size) {
        this.sizePizza = size;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public ArrayList getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList ingredientes) {
        this.ingredientes = ingredientes;
    }
}
