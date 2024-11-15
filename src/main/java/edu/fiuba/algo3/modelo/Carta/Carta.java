package edu.fiuba.algo3.modelo.Carta;

import edu.fiuba.algo3.modelo.Carta.Palo.*;
import edu.fiuba.algo3.modelo.Carta.Valor.*;
import edu.fiuba.algo3.modelo.Carta.Estado.*;
import edu.fiuba.algo3.modelo.PuntuacionTirada;

public class Carta {
    private final Valor valor;
    private final Palo palo;
    private Estado estado;

    public Carta(Palo palo, Valor valor) {
        this.valor = valor;
        this.palo = palo;
        this.estado = new Base();

    }

    public int obtenerIndice() {
        return this.valor.numeracion();
    }

    public Palo getPalo() {
        return this.palo;
    }

    public Valor getValor() {
        return this.valor;
    }

    public void modificarPuntuacion(PuntuacionTirada puntuacion) {
        estado.modificarPuntuacion(puntuacion, valor.puntosBase());
    }

    public void aplicarTarot(int puntuacionNueva) {
        this.estado = new Modificado(puntuacionNueva);
    }


    public int puntosBase() {
        return estado.puntosBase(valor.puntosBase());
    }

    public boolean compararValor(Carta otraCarta) {
        return this.valor.compararCon(otraCarta.getValor());
    }

    public boolean compararPalo(Palo unPalo) {
        return this.palo.compararCon(unPalo);
    }



   /* public void imprimir(){
        System.out.println(this.valor.getNumero());
        System.out.println(this.valor.getPuntoBase());
        System.out.println(this.palo);
    }*/
}
