package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Carta.Carta;

public class CartaModificada extends Carta {
    private int puntosExtra;

    public CartaModificada(Carta carta, int puntosExtra) {
        super(carta.getPalo(), carta.getValor());
        this.puntosExtra = puntosExtra;
    }

    @Override
    public void modificarPuntuacion(PuntuacionTirada puntuacion) {
        puntuacion.agregarPuntos(puntosExtra);
    }

    @Override
    public int puntosBase() {
        return this.puntosExtra;
    }
}
