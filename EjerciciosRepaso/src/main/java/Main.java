public class Main {

    /*

    Mostrar por consola la fecha y hora, personalizando el saludo dependiendo de la hora del día. El mensaje se repetirá hasta que se indique
    que no se quiere volver a consultar la hora. Para ello se deberá pedir el nombre al usuario nada más arrancar el programa y una vez pulsado Enter
    se mostrará el mensaje:
"Por favor introduce tu nombre: "

"Buenos días (tardes o noches) Luis, Son las 10:30 del 12 de Setiembre de 2019"

"¿Quieres volver a comprobar la hora?:" S

"Buenos días (tardes o noches) Luis, Son las 10:32 del 12 de Setiembre de 2019"

"¿Quieres volver a comprobar la hora?:" S

"Buenos días (tardes o noches) Luis, Son las 10:34 del 12 de Setiembre de 2019"

"¿Quieres volver a comprobar la hora?:" N

"Que tengas buen día"

     */
    public static void main(String[] args) {
        Ejercicio1 ejercicio1 = new Ejercicio1();

        ejercicio1.saludar();
    }
}
