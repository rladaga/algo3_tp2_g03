package edu.fiuba.algo3.modelo.Joker;

import edu.fiuba.algo3.modelo.EstrategiaModificacion.ModificarPuntos;
import edu.fiuba.algo3.modelo.ManoDePoker.ManoDePoker;
import edu.fiuba.algo3.modelo.Modificador.Sumar;
import edu.fiuba.algo3.modelo.PuntuacionTirada.PuntuacionTirada;

public class JokerCombinado extends Joker{
    private Joker joker1;
    private Joker joker2;

    public JokerCombinado(String nombre, String descripcion, Joker joker1, Joker joker2) {
        super(nombre, descripcion, new ModificarPuntos(), new Sumar(0));
        this.joker1 = joker1;
        this.joker2 = joker2;
    }

    @Override
    public void modificarPuntuacion(PuntuacionTirada puntuacion, ManoDePoker manoJugada) {
        joker1.modificarPuntuacion(puntuacion, manoJugada);
        joker2.modificarPuntuacion(puntuacion, manoJugada);
    }
}
