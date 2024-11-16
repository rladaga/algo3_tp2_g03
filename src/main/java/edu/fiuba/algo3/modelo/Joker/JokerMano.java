package edu.fiuba.algo3.modelo.Joker;

import edu.fiuba.algo3.modelo.PuntuacionTirada.EstrategiaModificacion.EstrategiaModificacion;
import edu.fiuba.algo3.modelo.PuntuacionTirada.PuntuacionTirada;
import edu.fiuba.algo3.modelo.ManoDePoker.ManoDePoker;

public class JokerMano extends Joker{

    private ManoDePoker manoObjetivo;

    public JokerMano(EstrategiaModificacion modificador, int modificacion, ManoDePoker manoObjetivo) {
        super(modificador, modificacion);
        this.manoObjetivo = manoObjetivo;
    }
    @Override
    public void modificarPuntuacion(PuntuacionTirada puntuacion, ManoDePoker manoDePoker) {
        if(realizarValidacion(manoDePoker)){
            modificador.modificar(puntuacion, modificacion);
        }
    }

    private boolean realizarValidacion(ManoDePoker manoDePoker){
        return manoObjetivo.esIgual(manoDePoker);
    }
}