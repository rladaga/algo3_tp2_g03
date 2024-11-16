package edu.fiuba.algo3.modelo.PuntuacionTirada.EstrategiaModificacion;

import edu.fiuba.algo3.modelo.PuntuacionTirada.PuntuacionTirada;

public class MultiplicarMultiplicador implements EstrategiaModificacion {

    @Override
    public void modificar(PuntuacionTirada puntuacion, int modificador) {
        puntuacion.multiplicarMultiplicador(modificador);
    }

    @Override
    public void sumarValorCarta(PuntuacionTirada puntuacion, int valorCarta) {
        puntuacion.sumarPuntos(valorCarta);
    }
}