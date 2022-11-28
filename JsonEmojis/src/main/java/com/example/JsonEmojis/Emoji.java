package com.example.JsonEmojis;

public class Emoji {
    String nombre, categoria, unicode;

    public Emoji() {
    }

    public Emoji(String nombre, String categoria, String unicode) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.unicode = unicode;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getUnicode() {
        return unicode;
    }

    public void setUnicode(String unicode) {
        this.unicode = unicode;
    }
}
