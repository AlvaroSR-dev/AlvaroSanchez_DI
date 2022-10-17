/*
    Crear tres surtidores. Dos con capacidad total y tipo de gasolina y uno con tipo de gasolina
    Crear una gasolinera.
    Agregar los tres surtidores a la gasolinera
    Crear un coche con tipo de gasolina
    Ejecutar el método ponerGasolina del coche (respotando una cantidad concreta).
    Prueba todas las combinación para comprobar los posibles fallos del método.
 */

public class Entrada {
    public static void main(String[] args) {
        Surtidor surtidor1 = new Surtidor(100, "Diesel");
        Surtidor surtidor2 = new Surtidor(120, "Gasolina");
        Surtidor surtidor3 = new Surtidor("Gasolina");

        Gasolinera gasolinera = new Gasolinera("BP");
        Coche coche = new Coche("Gasolina");

        coche.ponerGasolina(surtidor2, 30);
    }
}
