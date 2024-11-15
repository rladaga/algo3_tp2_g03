package edu.fiuba.algo3.modelo.Carta.Estado;

import edu.fiuba.algo3.modelo.PuntuacionTirada;

public interface Estado {

    void modificarPuntuacion(PuntuacionTirada puntuacionTirada, int puntuacionCarta);

    int puntosBase(int puntuacionValor);
}
