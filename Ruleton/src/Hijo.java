import java.io.*;

public class Hijo {
    public static void main(String[] args) {
        String leer;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            leer = br.readLine();

            HiloProceso hilo1 = new HiloProceso(leer);
            HiloRuleta hiloRuleta = new HiloRuleta();

            hilo1.start();
            hiloRuleta.start();

            try {
                hilo1.jugar();
                hilo1.join();
                hiloRuleta.join();
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

class HiloProceso extends Thread {
    int numAleatorio;
    String opcion;
    int[] numerosRuleta = new int[37];

    public HiloProceso(String opcion) {
        this.opcion = opcion;
    }

    @Override
    public void run() {

        if (opcion.equalsIgnoreCase("par")){
            System.out.println(opcion.toUpperCase() + "Apuesta válida");
        }else if (opcion.equalsIgnoreCase("impar")){
            System.out.println(opcion.toUpperCase() + "Apuesta válida");
        }else if (opcion.equalsIgnoreCase("cero")){
            System.out.println(opcion.toUpperCase() + "Apuesta válida");
        }else {
            System.out.println("Apuesta no válida");
        }

    }

    public void jugar(){
        numAleatorio = (int) (Math.random() * 37);
        System.out.println("\n"+ ConsoleColors.BLUE +numAleatorio);

        if (numAleatorio % 2 == 0 && opcion.equalsIgnoreCase("par")){
            System.out.println("Has ganado");
        } else if  (numAleatorio % 2 != 0 && opcion.equalsIgnoreCase("impar")){
            System.out.println("Has ganado");
        } else if (numAleatorio == 0 && opcion.equalsIgnoreCase("cero")) {
            System.out.println("Has ganado");
        }else {
            System.out.println("Has perdido");
        }
    }

    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }
}

class HiloRuleta extends Thread {
    int[] numerosRuleta = new int[37];

    public HiloRuleta(){}

    @Override
    public void run() {
        for (int i = 0; i < numerosRuleta.length; i++) {
            numerosRuleta[i] = i;
            if (numerosRuleta[i] % 2 == 0 && numerosRuleta[i] > 0){
                System.out.print(" " + ConsoleColors.BLACK_BACKGROUND + numerosRuleta[i] + " ");
            } else if (numerosRuleta[i] % 2 != 0) {
                System.out.print(" " + ConsoleColors.RED_BACKGROUND + numerosRuleta[i] + " ");
            }else if (numerosRuleta[i] == 0){
                System.out.print(" " + ConsoleColors.GREEN_BACKGROUND + numerosRuleta[i] + " ");
            }
        }
    }
}