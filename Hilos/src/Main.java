import java.util.Scanner;

class Main {
    public static void main( String args[] ) {
        Scanner in = new Scanner(System.in);
        Ruleta t1;
        Jugador jugador = new Jugador();
        Comprobador c1;
        String apuesta = "";

        System.out.println("Introduce tu nombre:");
        jugador.setNombre(in.nextLine());
        System.out.println("Introduce tu saldo:");
        jugador.setSaldo(in.nextInt());

        System.out.println("Usuario: " + jugador.getNombre() + "\n Saldo: " + jugador.getSaldo() + "€");

        System.out.println("Introduce apuesta: (Par, Impar, Cero)");
        apuesta = in.next();

        t1 = new Ruleta( "Número:",(int)(Math.random()*37));
        c1 = new Comprobador(jugador.getSaldo(), apuesta, t1.getRetardo());
        t1.start();
        c1.start();
    }
}