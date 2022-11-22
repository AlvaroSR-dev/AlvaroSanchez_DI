import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class Ruleta {

    public static void main(String args[]) throws IOException {
        String apuesta;
        Scanner in = new Scanner(System.in);

        Process Comprobador = new ProcessBuilder("java", "Comprobador").start();
        BufferedReader br = new BufferedReader(new InputStreamReader(Comprobador.getInputStream()));
        PrintStream ps = new PrintStream(Comprobador.getOutputStream(), true);

        System.out.println("par/impar/cero");
        System.out.println(br);
        apuesta = in.nextLine();
        ps.println(apuesta);

        Comprobador comprobador = new Comprobador(apuesta);
        comprobador.start();
    }
}