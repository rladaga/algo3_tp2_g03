package edu.fiuba.algo3.modelo.Tarot;

import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.ManoDePoker.ManoDePoker;


public abstract class Tarot {
    public Carta aplicarEfecto(Carta carta){
        return carta;
    };
    public ManoDePoker aplicarEfecto(ManoDePoker manoDePoker){
        return manoDePoker;
    };
}
