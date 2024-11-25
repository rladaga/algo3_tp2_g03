package edu.fiuba.algo3.modelo.EstrategiaModificacion;

import edu.fiuba.algo3.modelo.Modificador.*;
import edu.fiuba.algo3.modelo.PuntuacionTirada.PuntuacionTirada;

public class ModificarMultiplicador implements EstrategiaModificacion {

    @Override
    public void modificar(PuntuacionTirada puntuacion, Modificador modificador) {
        puntuacion.modificarMultiplicador(modificador);
    }

    @Override
    public void sumarValorCarta(PuntuacionTirada puntuacion, int valorCarta) {
        puntuacion.modificarPuntos(new Sumar(valorCarta));
    }

    @Override
    public int puntosCarta(int valorCarta, Modificador modificador) {
        return valorCarta;
    }
}