import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Baraja {
    Scanner in = new Scanner(System.in);
    ArrayList baraja = new ArrayList<Carta>();

    public void crear(){
        for (int i = 1; i < 13; i++) {
            Carta carta = new Carta(i, "Oros");
            baraja.add(carta);
        }
        for (int i = 1; i < 13; i++) {
            Carta carta = new Carta(i, "Bastos");
            baraja.add(carta);
        }
        for (int i = 1; i < 13; i++) {
            Carta carta = new Carta(i, "Espadas");
            baraja.add(carta);
        }
        for (int i = 1; i < 13; i++) {
            Carta carta = new Carta(i, "Copas");
            baraja.add(carta);
        }
    }

    public void repartir(Jugador jugador){
        for (int i = 0; i < 10; i++) {
            int aleatorio = (int) (Math.random() * baraja.size());
            Carta carta = (Carta) baraja.get(aleatorio);
            jugador.agregarCarta(carta);
            baraja.remove(carta);
        }
    }

    public void descartar(Jugador jugador){

        System.out.println("Cuántas cartas quieres descartar(1,2 o 3):");
        int opcion = in.nextInt();

        switch (opcion){
            case 1:
                System.out.println("Selecciona una carta:");
                jugador.verCartas();

                int descarte = in.nextInt();
                //Carta carta = jugador.getCarta(descarte);
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                break;
        }
    }

    public void robar(Jugador jugador){

    }

    public void mostrarBaraja(){
        for (int i = 0; i < baraja.size(); i++) {
            Carta carta = (Carta) baraja.get(i);
            carta.mostrarDatos();
        }
    }

    public ArrayList getBaraja() {
        return baraja;
    }

    public void setBaraja(ArrayList baraja) {
        this.baraja = baraja;
    }
}
