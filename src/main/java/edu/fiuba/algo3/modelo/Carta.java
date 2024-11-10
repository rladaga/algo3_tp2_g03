package edu.fiuba.algo3.modelo;

public class Carta {
    private Valor valor;
    private Palo palo;

    public Carta(Palo palo, Valor valor) {
        this.valor = valor;
        this.palo = palo;
    }

    public Carta(String palo, String valor){
        Palo paloEnum = Palo.valueOf(palo);
        Valor valorenum = Valor.valueOf(valor);

        this.palo = paloEnum;
        this.valor = valorenum;
    }

    public int obtenerPuntuacion() {
        return this.valor.getPuntoBase();
    }

    public int obtenerPalo() {
        return this.palo.ordinal();
    }

    public Palo getPalo() {
        return this.palo;
    }

    public Valor getValor() {
        return this.valor;
    }


   /* public void imprimir(){
        System.out.println(this.valor.getNumero());
        System.out.println(this.valor.getPuntoBase());
        System.out.println(this.palo);
    }*/
}
