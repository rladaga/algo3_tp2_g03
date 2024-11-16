package edu.fiuba.algo3.modelo.Carta.EstadoCarta;

import edu.fiuba.algo3.modelo.PuntuacionTirada.PuntuacionTirada;

public class Base implements Estado {

    @Override
    public void modificarPuntuacion (PuntuacionTirada puntuacionTirada, int puntuacionCarta){
        puntuacionTirada.sumarPuntos(puntuacionCarta);
    }

    @Override
    public int puntosBase(int puntuacionValor) {
        return puntuacionValor;
    }
}
