package edu.fiuba.algo3.modelo.Modificador;

import edu.fiuba.algo3.modelo.PuntuacionTirada;

public class ModificadorPuntos implements Modificador {

    @Override
    public void modificar(PuntuacionTirada puntuacion, int valorCarta, int modificador) {
        puntuacion.agregarPuntos(modificador);
    }

}
