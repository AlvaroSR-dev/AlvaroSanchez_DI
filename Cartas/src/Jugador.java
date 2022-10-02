import java.util.ArrayList;

public class Jugador {
    ArrayList cartasJugador = new ArrayList<Carta>();

    public Jugador() {
    }

    public Jugador(ArrayList cartasJugador) {
        this.cartasJugador = cartasJugador;
    }

    public void agregarCarta(Carta carta){
        cartasJugador.add(carta);
    }

    public void eliminarCarta(Carta carta){
        cartasJugador.remove(carta);
    }

    public void verCartas(){
        for (int i = 0; i < cartasJugador.size(); i++) {
            Carta carta = (Carta) cartasJugador.get(i);
            carta.mostrarDatos();
        }
    }

    public void getCarta(int posicion){
        cartasJugador.get(posicion);
    }

    public ArrayList getCartasJugador() {
        return cartasJugador;
    }

    public void setCartasJugador(ArrayList cartasJugador) {
        this.cartasJugador = cartasJugador;
    }
}
