package edu.fiuba.algo3.modelo.EstrategiaModificacion;

import edu.fiuba.algo3.modelo.Modificador.*;
import edu.fiuba.algo3.modelo.PuntuacionTirada.PuntuacionTirada;

public interface EstrategiaModificacion {
    void modificar(PuntuacionTirada puntuacion, Modificador modificador);

    void sumarValorCarta(PuntuacionTirada puntuacion, int valorCarta);

    int puntosCarta(int valorCarta, Modificador modificador);
} 