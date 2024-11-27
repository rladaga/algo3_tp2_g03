package edu.fiuba.algo3.modelo.Joker;

import edu.fiuba.algo3.modelo.EstrategiaModificacion.ModificarPuntos;
import edu.fiuba.algo3.modelo.ManoDePoker.ManoDePoker;
import edu.fiuba.algo3.modelo.Modificador.Sumar;
import edu.fiuba.algo3.modelo.PuntuacionTirada.PuntuacionTirada;
import edu.fiuba.algo3.modelo.Descarte;

public class JokerCombinado extends Joker {

    public JokerCombinado(String nombre, String descripcion, Joker joker1, Joker joker2) {
        super(nombre, descripcion, new ModificarPuntos(), new Sumar(0));
        this.otroJoker = joker1;
        joker1.agregarJoker(joker2);
    }

    @Override
    public void modificarPuntuacion(PuntuacionTirada puntuacion, ManoDePoker manoJugada, Descarte descarte) {
        this.otroJoker.modificarPuntuacion(puntuacion, manoJugada, descarte);
    }
}
