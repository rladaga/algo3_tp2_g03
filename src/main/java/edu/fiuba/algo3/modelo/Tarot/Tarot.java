package edu.fiuba.algo3.modelo.Tarot;

import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.ManoDePoker.ManoDePoker;


public abstract class Tarot {
    
    public void aplicarEfecto(Carta carta){}

    public ManoDePoker aplicarEfecto(ManoDePoker manoDePoker){
        return manoDePoker;
    };
}
