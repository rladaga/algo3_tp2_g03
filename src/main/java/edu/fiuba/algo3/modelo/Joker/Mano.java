package edu.fiuba.algo3.modelo.Joker;

import edu.fiuba.algo3.modelo.PuntuacionTirada.EstrategiaModificacion.EstrategiaModificacion;
import edu.fiuba.algo3.modelo.PuntuacionTirada.PuntuacionTirada;
import edu.fiuba.algo3.modelo.ManoDePoker.ManoDePoker;

public class Mano implements CondicionActivacion{

    private ManoDePoker manoObjetivo;

    public Mano(ManoDePoker manoObjetivo) {
        this.manoObjetivo = manoObjetivo;
    }

    @Override
    public boolean realizarValidacion(ManoDePoker manoDePoker, int cantidadDescartes){
        return manoObjetivo.esIgual(manoDePoker);
    }

}