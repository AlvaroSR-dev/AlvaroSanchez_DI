
import java.util.Arrays;
import java.util.Scanner;

public class EjercicioArray {

    /*
     * Agregar al menú las siguientes opciones:
     * - Buscar un elemento: pedir al usuairo un elemento a buscar
     *  y mostrar la posición en la que se enciuentra (el primero que se encuentre)
     * - Sustituir elemento: pedira el elemento que quieres sustituir y por el numero que
     *   quieres sustituir (todos)
     * - Calcular max y min
     * - Quitar errores de array no relleno
     * */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = null; // 0
        int opcion = 0;
        int buscar = 0;

        do {
            System.out.println("---------------------");
            System.out.println("1. Rellenar array");
            System.out.println("2. Listar array");
            System.out.println("3. Ordenar array");
            System.out.println("4. Vaciar array");
            System.out.println("5. Buscar");
            System.out.println("6. Sustituir números");
            System.out.println("7. Max y min");
            System.out.println("8. Finalizar");
            System.out.println("Que opción quieres hacer");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    if (numeros != null) {
                        System.out.println("El array ya está relleno, ¿queres rellenarlo otra vez?");
                        String constestacion = scanner.next();
                        if (constestacion.equalsIgnoreCase("s")) {

                            // un array con 50 posiciones rellenas
                            numeros = new EjercicioArray().rellenarArray();
                        }
                    } else {
                        // un array con 50 posiciones rellenas
                        numeros = new EjercicioArray().rellenarArray();
                    }
                    break;
                case 2:
                    for (int i = 0; i < numeros.length; i++) {
                        System.out.printf("Elemento %d: %d%n",i+1,numeros[i]);
                    }
                    System.out.println("Listado finalizado");
                    break;
                case 3:
                    Arrays.sort(numeros);
                    System.out.println("Ordenación completa");
                    break;
                case 4:
                    numeros = null;
                    System.out.println("Vaciado completo");
                    break;
                case 5:
                    System.out.println("¿Qué número quieres buscar?");
                    buscar = scanner.nextInt();
                    System.out.println(numeros[buscar]);
                    break;
                case 6:
                    System.out.println("¿Qué número quieres sustituir?");
                    int nsustituir = scanner.nextInt();
                    System.out.println("¿Por qué número?");
                    int nsustituido = scanner.nextInt();
                    for (int i = 0; i < numeros.length; i++) {
                        if (numeros[i] == nsustituir){
                            numeros[i] = nsustituido;
                        }
                    }
                    break;
                case 7:
                    int max = 0;
                    int min = 999;
                    for (int i = 0; i < numeros.length; i++) {
                        if (numeros[i] > max){
                            max = numeros[i];
                        } else if (numeros[i] < min){
                            min = numeros[i];
                        }
                    }
                    System.out.println("El número máximo es: " + max);
                    System.out.println("El número mínimo es: " + min);
                    break;
                case 8:
                    System.out.println("Finalizando ejercicio");
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }
        } while (opcion != 5);
    }

    public int[] rellenarArray() {
        int[] numerosAux = new int[50];
        for (int i = 0; i < 50; i++) {
            numerosAux[i] = (int) (Math.random() * 201);
        }
        return numerosAux;
    }
}