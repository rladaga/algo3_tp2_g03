package edu.fiuba.algo3.modelo.EstrategiaModificacion;

import edu.fiuba.algo3.modelo.Modificador.*;
import edu.fiuba.algo3.modelo.PuntuacionTirada.PuntuacionTirada;

public class ModificarPuntos implements EstrategiaModificacion {

    @Override
    public void modificar(PuntuacionTirada puntuacion, Modificador modificador) {
        puntuacion.modificarPuntos(modificador);
    }

    @Override
    public void sumarValorCarta(PuntuacionTirada puntuacion, int valorCarta) {}

    @Override
    public int puntosCarta(int puntosCarta, Modificador modificador){
        return modificador.modificar(0);
    }
}