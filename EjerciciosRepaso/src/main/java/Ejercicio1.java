import java.util.Calendar;
import java.util.Scanner;

public class Ejercicio1 {
    String nombre;

    Calendar fecha = Calendar.getInstance();
    Scanner in = new Scanner(System.in);

    public Ejercicio1() {
    }

    public Ejercicio1(String nombre) {
        this.nombre = nombre;
    }

    public void saludar(){
        System.out.println("Introduce tu nombre:");
        nombre = in.nextLine();
        System.out.println("Buenos días " + nombre + ", son las " + fecha.getTime());
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }
}
