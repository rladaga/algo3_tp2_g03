package edu.fiuba.algo3.modelo.Carta;

import edu.fiuba.algo3.modelo.Carta.Palo.*;
import edu.fiuba.algo3.modelo.Carta.Valor.*;
import edu.fiuba.algo3.modelo.CartaModificada;
import edu.fiuba.algo3.modelo.PuntuacionTirada;

public class Carta {
    private Valor valor;
    private Palo palo;

    public Carta(Palo palo, Valor valor) {
        this.valor = valor;
        this.palo = palo;
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
        puntuacion.agregarPuntos(this.puntosBase());
    }

    public CartaModificada aplicarPuntos(int puntos) {
        CartaModificada carta = new CartaModificada(this, puntos);
        return carta;
    }

    public boolean compararPalo(Palo unPalo) {
        return this.palo.compararCon(unPalo);
    }

    public int puntosBase() {
        return valor.puntosBase();
    }

    public boolean compararValor(Carta otraCarta) {
        return this.valor.compararCon(otraCarta.getValor());
    }



   /* public void imprimir(){
        System.out.println(this.valor.getNumero());
        System.out.println(this.valor.getPuntoBase());
        System.out.println(this.palo);
    }*/
}
