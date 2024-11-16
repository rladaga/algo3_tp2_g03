package edu.fiuba.algo3.modelo.Carta;

import edu.fiuba.algo3.modelo.Carta.Palo.*;
import edu.fiuba.algo3.modelo.Carta.Valor.*;
import edu.fiuba.algo3.modelo.Carta.EstadoCarta.*;
import edu.fiuba.algo3.modelo.PuntuacionTirada;
import edu.fiuba.algo3.modelo.Carta.ModificadorCarta.ModificadorCarta;

public class Carta {
    private final Valor valor;
    private final Palo palo;
    private EstadoCarta estadoCarta;

    public Carta(Palo palo, Valor valor) {
        this.valor = valor;
        this.palo = palo;
        this.estadoCarta = new CartaBase();

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
        estadoCarta.modificarPuntuacion(puntuacion, valor.puntosBase());
    }

    public void aplicarTarot(int puntuacionNueva, ModificadorCarta modificador) {
        this.estadoCarta = new CartaModificada(puntuacionNueva, modificador);
    }


    public int puntosBase() {
        return estadoCarta.puntosBase(valor.puntosBase());
    }

    public boolean compararValor(Carta otraCarta) {
        return this.valor.compararCon(otraCarta.getValor());
    }

    public boolean compararPalo(Carta unaCarta) {
        return this.palo.compararCon(unaCarta.getPalo());
    }

}
