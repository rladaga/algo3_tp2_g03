package edu.fiuba.algo3.modelo.Carta.Estado;

import edu.fiuba.algo3.modelo.PuntuacionTirada;

public class Base implements Estado {

    @Override
    public void modificarPuntuacion (PuntuacionTirada puntuacionTirada, int puntuacionCarta){
        puntuacionTirada.agregarPuntos(puntuacionCarta);
    }

    @Override
    public int puntosBase(int puntuacionValor) {
        return puntuacionValor;
    }
}
