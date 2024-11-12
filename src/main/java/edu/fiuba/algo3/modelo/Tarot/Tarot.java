package edu.fiuba.algo3.modelo.Tarot;

import edu.fiuba.algo3.modelo.Carta;
import edu.fiuba.algo3.modelo.tipo_de_mano.TipoDeMano;


public abstract class Tarot {
    public Carta aplicarEfecto(Carta carta){
        return carta;
    };
    public TipoDeMano aplicarEfecto(TipoDeMano tipoDeMano){
        return tipoDeMano;
    };
}
