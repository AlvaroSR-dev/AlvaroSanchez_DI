import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Ruleta extends Thread{

    private String nombre;
    private int retardo;
    static String ruletonLinea;

    public static void main(String[] args) {
        Process hijo;

        {
            try {
                hijo = new ProcessBuilder("java","Comprobador").start();
                BufferedReader br = new BufferedReader(new InputStreamReader(hijo.getInputStream()));
                PrintStream ps = new PrintStream(hijo.getOutputStream(), true);

// Buffer que lee de consola

                BufferedReader in = new BufferedReader(new InputStreamReader (System. in));

                System.out.println("Enviar un mensaje al proceso hijo:");

                for (int i = 0; i < 36; i++) {
                    ruletonLinea = ruletonLinea +  "," + i;
                }

// Enviar mensaje al hijo

                ruletonLinea = in.readLine();

                ps.println(ruletonLinea);

// Recibir información del padre

                ruletonLinea = br.readLine();

                System.out.println(ruletonLinea) ;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Ruleta(String s, int d) {
        nombre = s;
        retardo = d;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRetardo() {
        return retardo;
    }

    public void setRetardo(int retardo) {
        this.retardo = retardo;
    }
}
