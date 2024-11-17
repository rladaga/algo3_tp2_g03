package edu.fiuba.algo3.modelo.Joker;

import edu.fiuba.algo3.modelo.PuntuacionTirada.EstrategiaModificacion.EstrategiaModificacion;
import edu.fiuba.algo3.modelo.PuntuacionTirada.PuntuacionTirada;
import edu.fiuba.algo3.modelo.ManoDePoker.ManoDePoker;

public class JokerMano extends Joker{

    private ManoDePoker manoObjetivo;

    public JokerMano(String nombre, String descripcion, EstrategiaModificacion modificador, int modificacion, ManoDePoker manoObjetivo) {
        super(nombre, descripcion, modificador, modificacion);
        this.manoObjetivo = manoObjetivo;
    }

    @Override
    public void modificarPuntuacion(PuntuacionTirada puntuacionTirada, ManoDePoker manoDePoker) {
        if (manoObjetivo.esIgual(manoDePoker)) {
            modificador.modificar(puntuacionTirada, modificacion);
        }
    }
}