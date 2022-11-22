import java.io.BufferedReader;
import java.io. IOException;
import java.io.InputStreamReader;

public class Comprobador extends Thread{
    String ruletonLinea = "0";
    String[] numerosRuleta = new String[37];

    public Comprobador(String apuesta) {
    }

    public static void main(String[] args){
        String apuesta1;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            apuesta1 = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void run(String apuesta){
        int numAleatorio;

        for (int i = 1; i < 37; i++) {
            ruletonLinea = ruletonLinea +  "," + i;
        }

        numerosRuleta = ruletonLinea.split(",");

        for (int i = 0; i < numerosRuleta.length; i++) {
            if (Integer.parseInt(numerosRuleta[i]) % 2 == 0 && Integer.parseInt(numerosRuleta[i]) > 0){
                System.out.print(" " + ConsoleColors.BLACK_BACKGROUND + numerosRuleta[i] + " ");
            } else if (Integer.parseInt(numerosRuleta[i]) % 2 != 0) {
                System.out.print(" " + ConsoleColors.RED_BACKGROUND + numerosRuleta[i] + " ");
            }else if (numerosRuleta[i].equals("0")){
                System.out.print(" " + ConsoleColors.GREEN_BACKGROUND + numerosRuleta[i] + " ");
            }
        }
        System.out.print(ConsoleColors.RED+"");

        numAleatorio = (int) (Math.random() * 37);
        System.out.println("\n"+ ConsoleColors.BLUE +numerosRuleta[numAleatorio]);

        if (numAleatorio % 2 == 0 && apuesta.equalsIgnoreCase("par")){
            System.out.println("Has ganado");
        } else if  (numAleatorio % 2 != 0 && apuesta.equalsIgnoreCase("impar")){
            System.out.println("Has ganado");
        } else if (numAleatorio == 0 && apuesta.equalsIgnoreCase("cero")) {
            System.out.println("Has ganado");
        }else {
            System.out.println("Has perdido");
        }
    }
}