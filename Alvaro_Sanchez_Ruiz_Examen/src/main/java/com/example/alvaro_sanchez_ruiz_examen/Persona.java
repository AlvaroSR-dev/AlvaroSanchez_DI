package com.example.alvaro_sanchez_ruiz_examen;

public class Persona {
    String nombre, pass, correo, rol;
    int tlf;

    public Persona() {
    }

    public Persona(String nombre, String pass, String correo, int tlf, String rol) {
        this.nombre = nombre;
        this.pass = pass;
        this.correo = correo;
        this.tlf = tlf;
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getTlf() {
        return tlf;
    }

    public void setTlf(int tlf) {
        this.tlf = tlf;
    }
}
