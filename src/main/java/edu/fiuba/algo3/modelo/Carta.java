package edu.fiuba.algo3.modelo;

enum Palo {
    PICA,DIAMANTE,CORAZON,TREBOL;

}

enum Valor {
    AS("A", 11),
    DOS("2", 2),
    TRES("3", 3),
    CUATRO("4", 4),
    CINCO("5", 5),
    SEIS("6", 6),
    SIETE("7", 7),
    OCHO("8", 8),
    NUEVE("9", 9),
    DIEZ("10", 10),
    JOTA("J", 10),
    REINA("Q", 10),
    REY("K", 10);

    private final String numero;
    private final int puntoBase;

    Valor(String numero, int puntoBase) {
        this.numero = numero;
        this.puntoBase = puntoBase;
    }

    public String getNumero() {
        return numero;
    }

    public int getPuntoBase() {
        return puntoBase;
    }
}


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


   /* public void imprimir(){
        System.out.println(this.valor.getNumero());
        System.out.println(this.valor.getPuntoBase());
        System.out.println(this.palo);
    }*/
}
