package edu.fiuba.algo3.modelo.PuntuacionTirada.EstrategiaModificacion;

import edu.fiuba.algo3.modelo.PuntuacionTirada.PuntuacionTirada;

public interface EstrategiaModificacion {
    void modificar(PuntuacionTirada puntuacion, int modificador);

    void sumarValorCarta(PuntuacionTirada puntuacion, int valorCarta);
} 