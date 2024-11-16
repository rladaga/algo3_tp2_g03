package edu.fiuba.algo3.modelo.Carta.ModificadorCarta;

import edu.fiuba.algo3.modelo.PuntuacionTirada;

public interface ModificadorCarta {
    void modificar(PuntuacionTirada puntuacion, int valorCarta, int modificador);
} 