package edu.fiuba.algo3.modelo.Tarot;

import edu.fiuba.algo3.modelo.ManoDePoker.ManoDePoker;

public class TarotManoPoker {
    private ManoDePoker mano;
    private int puntuacion;
    private int multiplicador;

    public TarotManoPoker(ManoDePoker manoAModificar, int unaPuntuacion, int unMultiplicador) {
        this.puntuacion = unaPuntuacion;
        this.multiplicador = unMultiplicador;
        this.mano = manoAModificar;
    }


    public void aplicarEfecto(ManoDePoker manoDePoker){
        if(mano.esIgual(manoDePoker)){
            manoDePoker.agregarMejora(puntuacion,multiplicador);
        }
    }
}
