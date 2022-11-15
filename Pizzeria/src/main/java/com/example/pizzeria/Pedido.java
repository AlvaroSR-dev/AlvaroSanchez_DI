package com.example.pizzeria;

public class Pedido {
    int id, tlf;
    String nombre;
    Pizza pizza;

    public Pedido() {
    }

    public Pedido(int id, int tlf, String nombre, Pizza pizza) {
        this.id = id;
        this.tlf = tlf;
        this.nombre = nombre;
        this.pizza = pizza;
    }

    public void mostrarDatos(){
        System.out.println("ID: " + id);
        System.out.println("Teléfono: " + tlf);
        System.out.println("Nombre: " + nombre);
        System.out.println("Pizza: " + pizza.getNombre());
        System.out.println("Precio: " + pizza.getPrecio());
    }

    public String datos(){
        return "---------------" +
            "\n ID: " + id +
            "\n Teléfono: " + tlf +
            "\n Nombre: " + nombre +
            "\n Pizza: " + pizza.getNombre() +
            "\n Precio: " + pizza.getPrecio() + "\n";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTlf() {
        return tlf;
    }

    public void setTlf(int tlf) {
        this.tlf = tlf;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
