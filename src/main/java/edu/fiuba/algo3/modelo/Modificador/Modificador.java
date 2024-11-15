package edu.fiuba.algo3.modelo.Modificador;

import edu.fiuba.algo3.modelo.PuntuacionTirada;

public interface Modificador {
    void modificar(PuntuacionTirada puntuacion, int valorCarta, int modificador);
} 