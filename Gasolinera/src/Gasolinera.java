/*
    Un atributo de tipo string (nombre) --
    Un atributo de tipo ArrayLista donde se guardarán los surtidores (lista) --
    Un atributo de tipo int (ganancias) --
    Un constructor que pida por parámetros un nombre y lo inicialice. El resto de atributos los inicializará por defecto. --
    Un método que sea agregarSurtidor que admita por parámetros un surtidor y lo agrege a la lista de surtidores de la gasolinera
    Un método que sea obtenerGanancias que no reciba nada y que devuelva un int. El método retornará la variable ganancias
    Los getter y setter
 */

import java.util.ArrayList;

public class Gasolinera {
    String nombre;
    int ganancias;
    ArrayList surtidores;

    public Gasolinera(String nombre) {
        this.nombre = nombre;
        this.ganancias = 0;
        this.surtidores = new ArrayList<Surtidor>();
    }

    public void agregarSurtidor(Surtidor surtidor){
        surtidores.add(surtidor);
    }

    public void obtenerGanancias(){
        System.out.println("Ganancias: " + ganancias);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getGanancias() {
        return ganancias;
    }

    public void setGanancias(int ganancias) {
        this.ganancias = ganancias;
    }

    public ArrayList getSurtidores() {
        return surtidores;
    }

    public void setSurtidores(ArrayList surtidores) {
        this.surtidores = surtidores;
    }
}
