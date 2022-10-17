public class Carta {
    int numero;
    String palo;

    public Carta() {
    }

    public Carta(int numero, String palo) {
        this.numero = numero;
        this.palo = palo;
    }

    public void mostrarDatos(){
        if(palo == "Oros"){
            System.out.println(ConsoleColors.YELLOW + numero + " " + palo);
        }else if (palo == "Bastos"){
            System.out.println(ConsoleColors.GREEN + numero + " " + palo);
        }else if (palo == "Espadas"){
            System.out.println(ConsoleColors.BLUE + numero + " " + palo);
        }else{
            System.out.println(ConsoleColors.RED + numero + " " + palo);
        }
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPalo() {
        return palo;
    }

    public void setPalo(String palo) {
        this.palo = palo;
    }
}
