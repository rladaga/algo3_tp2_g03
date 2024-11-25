package edu.fiuba.algo3.modelo.Carta.Palo;

public class Picas extends Palo {
    @Override
    public boolean compararCon(Palo unPalo){ return unPalo.compararConPicas(this);}

    @Override
    public boolean compararConPicas(Picas unPalo){ return true;}
}
