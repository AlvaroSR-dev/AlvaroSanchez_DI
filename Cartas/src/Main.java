public class Main {
    public static void main(String[] args) {
        Baraja baraja = new Baraja();
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        baraja.crear();
        baraja.mostrarBaraja();

        System.out.println("-----------------");

        baraja.repartir(jugador1);
        jugador1.verCartas();
        System.out.println("-----------------");
        baraja.repartir(jugador2);
        jugador2.verCartas();
    }
}
