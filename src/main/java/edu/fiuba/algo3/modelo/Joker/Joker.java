package edu.fiuba.algo3.modelo.Joker;

import edu.fiuba.algo3.modelo.PuntuacionTirada;
import edu.fiuba.algo3.modelo.ManoDePoker.ManoDePoker;

public interface Joker {
    void modificarPuntuacion(PuntuacionTirada puntuacion, ManoDePoker tipo);
}
