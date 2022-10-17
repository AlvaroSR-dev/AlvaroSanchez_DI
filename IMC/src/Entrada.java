import java.util.Scanner;

public class Entrada {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Introduce tu nombre:");
        String nombre = in.nextLine();
        System.out.println("Introduce tu edad:");
        int edad = in.nextInt();
        System.out.println("Introduce tu peso:");
        double peso = in.nextDouble();
        System.out.println("Introduce tu altura:");
        double altura = in.nextDouble();
        System.out.println("Introduce tu sexo:");
        String sexo = in.nextLine();
        System.out.println("Introduce tu dni:");
        String dni = in.nextLine();


        Persona persona1 = new Persona(nombre, edad, sexo, peso, altura, dni);
        Persona persona2 = new Persona(nombre, edad, sexo);
        Persona persona3 = new Persona();

        persona3.setNombre("Álvaro");
        persona3.setAltura(172);
        persona3.setDni("111A");
        persona3.setPeso(64);
        persona3.setEdad(19);
        persona3.setSexo("H");

        persona1.calcularIMC(peso, altura);
        persona2.calcularIMC(peso, altura);
        persona3.calcularIMC(peso, altura);

        persona1.mostrarDatos();
    }
}
