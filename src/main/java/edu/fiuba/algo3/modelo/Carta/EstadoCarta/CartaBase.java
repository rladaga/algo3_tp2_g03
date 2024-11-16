package edu.fiuba.algo3.modelo.Carta.EstadoCarta;

import edu.fiuba.algo3.modelo.PuntuacionTirada;

public class CartaBase implements EstadoCarta {

    @Override
    public void modificarPuntuacion (PuntuacionTirada puntuacionTirada, int puntuacionCarta){
        puntuacionTirada.agregarPuntos(puntuacionCarta);
    }

    @Override
    public int puntosBase(int puntuacionValor) {
        return puntuacionValor;
    }
}
