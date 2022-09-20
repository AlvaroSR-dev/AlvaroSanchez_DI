/*
(Para entregar) Realiza un programa que simule el funcionamiento de un juego de cartas. Para ello la lógica será la siguiente:

Cada jugador se le repartes 10 cartas al azar la baraja española (10 objetos de la clase Carta donde cada uno tiene valor y palo que previamente tienen que estar barajadas).

Una vez los jugadores tienen todas las cartas se dan dos turnos de juego y cada jugador puede

Descartase de entre 1 y 3 cartas: selecciona el número de cartas (y cuales) y se le reparten cartas aleatorias
Robar al rival entre 1 y tres cartas
Pasar
Cuando se pasan los turnos se decidirá cual es el ganador:

Ganará aquel jugador que tenga más cartas del mismo palo ordenadas
Para el ejercicio tendrás que:

Crear un arraylist y rellenarlo automáticamente

Montar un menú para que pueda is dandose la mecánica del juego

Ves mostrando las cartas de cada jugador, reparticiones, etc ... en todo momento
 */

import java.util.ArrayList;

public class Baraja {
    ArrayList<String> baraja = new ArrayList<>();

    public void llenarBaraja(){
        for (int j = 1; j < 4; j++) {
            for (int i = 1; i < 13; i++) {
                switch (j){
                    case 1:
                        baraja.add(i+" O");
                        break;
                    case 2:
                        baraja.add(i+" B");
                        break;
                    case 3:
                        baraja.add(i+" E");
                        break;
                    default:
                        baraja.add(i+" C");
                        break;
                }
            }
        }
    }

    public void mostrarBaraja(){
        for (String item : baraja) {
            System.out.println(item);
        }
    }

}
