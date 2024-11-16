package edu.fiuba.algo3.modelo.Joker;

import edu.fiuba.algo3.modelo.ManoDePoker.ManoDePoker;

public class Descarte implements CondicionActivacion{

    @Override
    public boolean realizarValidacion(ManoDePoker manoDePoker, int cantidadDescartes){
        return cantidadDescartes > 0;
    }

}
