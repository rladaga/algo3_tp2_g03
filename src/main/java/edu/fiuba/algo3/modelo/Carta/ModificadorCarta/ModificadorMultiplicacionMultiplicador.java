package edu.fiuba.algo3.modelo.Carta.ModificadorCarta;

import edu.fiuba.algo3.modelo.PuntuacionTirada;

public class  ModificadorMultiplicacionMultiplicador implements ModificadorCarta {

    @Override
    public void modificar(PuntuacionTirada puntuacion, int valorCarta, int modificador) {
        puntuacion.agregarPuntos(valorCarta);
        puntuacion.multiplicarMultiplicador(modificador);
    }

} 