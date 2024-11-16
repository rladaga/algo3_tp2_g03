package edu.fiuba.algo3.modelo.Carta.EstadoCarta;

import edu.fiuba.algo3.modelo.PuntuacionTirada;

public interface EstadoCarta {

    void modificarPuntuacion(PuntuacionTirada puntuacionTirada, int puntuacionCarta);

    int puntosBase(int puntuacionValor);
}
