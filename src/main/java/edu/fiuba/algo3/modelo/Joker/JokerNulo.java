package edu.fiuba.algo3.modelo.Joker;

import edu.fiuba.algo3.modelo.EstrategiaModificacion.ModificarPuntos;
import edu.fiuba.algo3.modelo.ManoDePoker.ManoDePoker;
import edu.fiuba.algo3.modelo.Modificador.Sumar;
import edu.fiuba.algo3.modelo.PuntuacionTirada.PuntuacionTirada;

public class JokerNulo extends Joker {

    public JokerNulo() {
        super("Nulo", "No hace nada", new ModificarPuntos(), new Sumar(0));
        this.otroJoker = null;
    }

    @Override
    public void modificarPuntuacion(PuntuacionTirada puntuacion, ManoDePoker manoJugada){};
}
