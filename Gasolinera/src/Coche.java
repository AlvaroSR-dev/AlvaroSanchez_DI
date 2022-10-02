/*
    Un atributo de tipo string (tipo de gasolina) --
    Un atributo de tipo int (litrosDeposito) --
    Un constructor que admita un argumento de tipo string y lo inicialice. Los litrosDeposito los iniciará a 0 --
    Un método que sea ponerGasolina que no devuelva nada y que admita por parámetros un objeto de tipo surtidor y
    un int con la cantidad de litros a repostar. La funcionalidad será la siguiente:
    El coche ejecutará el método quitarGasolina del surtidor
    Si el surtidor está vacío o intentas poner más gasolina de la que tiene el surtidor saltará un aviso
    Si el surtidor está averiado saltará un aviso
    Si el tipo de gasolina del coche es diferente al tipo de gasolina del surtidor saltará un aviso
    Si no se sumará a litrosDeposito lo que se ha reportado, y al surtidor se le restarán los litros
 */

public class Coche {
    String tipo;
    int deposito;

    public Coche(String tipo) {
        this.tipo = tipo;
        this.deposito = 0;
    }

    public void ponerGasolina(Surtidor surtidor, int cantidad){
        if (cantidad > surtidor.getCapacidadActual()){
            System.out.println("No hay sufiente gasolina");
        }else if (surtidor.funcionando == false){
            System.out.println("El surtidor no está funcionando");
        }else if(surtidor.getTipo() != this.tipo){
            System.out.println("Cuidado! El surtidor no es del tipo de tu combustible");
        }else{
            deposito+= cantidad;
            surtidor.quitarGasolina(cantidad);
        }
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getDeposito() {
        return deposito;
    }

    public void setDeposito(int deposito) {
        this.deposito = deposito;
    }
}
