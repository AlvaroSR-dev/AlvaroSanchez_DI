import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;

public class Comprobador extends Thread{
    static String linea;
    static String[] arrayRuleta = new String[37];

    private int saldo, nRuleta;
    private String apuesta;

    public Comprobador(int saldo, String apuesta, int nRuleta) {
        this.saldo = saldo;
        this.apuesta = apuesta;
        this.nRuleta = nRuleta;
    }

    public Comprobador() {

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        linea = bufferedReader.readLine();

        arrayRuleta = linea.split(",");
        for (int i = 0; i < arrayRuleta.length; i++) {
            System.out.println(arrayRuleta[i]);
        }
        Comprobador comprobador = new Comprobador();
        comprobador.start();
    }

    public void run() {
        for (int i = 0; i < arrayRuleta.length; i++) {
            System.out.println(arrayRuleta[i]);
        }
        int resultado = Integer.parseInt(arrayRuleta[nRuleta]);

        try {
            sleep( saldo );
        } catch( InterruptedException e ) {
            e.printStackTrace();
        }
        if (saldo == 0){
            System.out.println(ConsoleColors.RED + "No tienes saldo");
        }else if (resultado % 2 == 0 && apuesta.equalsIgnoreCase("par")){
            System.out.println("PAR: " + saldo*2 + "€");
        }else if (resultado % 2 != 0 && apuesta.equalsIgnoreCase("impar")){
            System.out.println("IMPAR: " + saldo*2 + "€");
        }else if (resultado == 0 && apuesta.equalsIgnoreCase("cero")){
            System.out.println("CERO: " + saldo*14 + "€");
        }else {
            System.out.println("HAS PERDIDO");
        }
    }

}