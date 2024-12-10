package edu.fiuba.algo3.modelo.Joker;

import edu.fiuba.algo3.modelo.Descarte;
import edu.fiuba.algo3.modelo.EstrategiaModificacion.EstrategiaModificacion;
import edu.fiuba.algo3.modelo.Modificador.*;
import edu.fiuba.algo3.modelo.PuntuacionTirada.PuntuacionTirada;
import edu.fiuba.algo3.modelo.ManoDePoker.ManoDePoker;

public class JokerMano extends Joker {

    private ManoDePoker manoObjetivo;

    public JokerMano(String nombre, String descripcion, EstrategiaModificacion estrategiaModificacion, Modificador modificador, ManoDePoker manoObjetivo) {
        super(nombre, descripcion, estrategiaModificacion, modificador);
        this.manoObjetivo = manoObjetivo;
        this.otroJoker = new JokerNulo();
    }

    @Override
    public void modificarPuntuacion(PuntuacionTirada puntuacionTirada, ManoDePoker manoDePoker, Descarte descarte) {
        if (manoObjetivo.esIgual(manoDePoker)) {
            estrategiaModificacion.modificar(puntuacionTirada, modificador);
        }

        this.otroJoker.modificarPuntuacion(puntuacionTirada, manoDePoker, descarte);
    }

    @Override
    public String getTipo(){
        return "Mano";
    }
}