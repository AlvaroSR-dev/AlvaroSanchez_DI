/*
    Atributo int (capacidadTotal) que represente los litros máximos de gasolina que admite --
    Atributo int (capacidadActual) que represente los litros que tiene de gasolina cargados --
    Atributo string que represente el tipo de gasolina que tiene --
    Atributo boleado que represente si está o no funcionando el surtidor --
    Constructor que pida por parámetros la capacidadTotal y el tipo de gasolina e inicialice los atributos. --
        El atributo funcionamiento se iniciará funcionando a true y el atributo capacidadActual será igual que la capacidadTotal. --
    Constructor que pida por parámetros el tipo de gasolina (y lo inicialice) y el resto de elementos los inicie por defeco. --
    Un método arreglar que no pida parámetros, no retorne nada y modifique el valor de atributo funcionamiento a true --
    Un método que rellenar que no devuelva nada y que admita por parámetros un int. El método agregará a la capacidadActual lo pasado por parámetros --
    Un método quitarGasolina que reciba por parámetros un int. El método quitará del atributo capacidadTotal lo pasado por parámetros --
    Los getter y setter correpondientes
 */
public class Surtidor {
    int capacidadTotal, capacidadActual;
    String tipo;
    Boolean funcionando;

    public Surtidor(int capacidadTotal, String tipo) {
        this.capacidadTotal = capacidadTotal;
        this.tipo = tipo;
        this.funcionando = true;
        this.capacidadActual = capacidadTotal;
    }

    public Surtidor(String tipo) {
        this.tipo = tipo;
        this.capacidadTotal = 0;
        this.capacidadActual = 0;
        this.funcionando = false;
    }

    public void arreglar(){
        funcionando = true;
        System.out.println("Se ha arreglado el surtidor");
    }

    public void rellenar(int cantidad){
        capacidadActual+=cantidad;
        System.out.println("Se han agregado " + cantidad + " litros.");
        System.out.println("Total disponible: " + capacidadActual);
    }

    public void quitarGasolina(int cantidad){
        capacidadTotal-=cantidad;
        System.out.println("Se han quitado " + cantidad + " litros.");
        System.out.println("Total capacidad: " + capacidadTotal);
    }

    public int getCapacidadTotal() {
        return capacidadTotal;
    }

    public void setCapacidadTotal(int capacidadTotal) {
        this.capacidadTotal = capacidadTotal;
    }

    public int getCapacidadActual() {
        return capacidadActual;
    }

    public void setCapacidadActual(int capacidadActual) {
        this.capacidadActual = capacidadActual;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Boolean getFuncionando() {
        return funcionando;
    }

    public void setFuncionando(Boolean funcionando) {
        this.funcionando = funcionando;
    }
}
