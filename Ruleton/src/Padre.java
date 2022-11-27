import java.io.*;

public class Padre {

    public static void main(String[] args) {
        String apuesta;

        try {

// Llamar a la clase Hijo compilada anteriormente


            Process hijo = new ProcessBuilder("java","X:\\DAM2\\AlvaroSanchez_DI\\Ruleton\\src\\Hijo.java").start();
// Buffer para datos del proceso hijo


            BufferedReader br = new BufferedReader(new InputStreamReader(hijo.getInputStream()));

// Stream salida

            PrintStream ps = new PrintStream(hijo.getOutputStream(), true);

// Buffer que lee de consola

            BufferedReader in = new BufferedReader(new InputStreamReader (System.in));

            System.out.println("PAR/IMPAR/CERO");

// Enviar mensaje al hijo

            apuesta = in.readLine();

            ps.println(apuesta);

            System.out.println(br.readLine());

        } catch (IOException e) {
            System.out.println("Error : " + e.getMessage());
        }

    }
}
