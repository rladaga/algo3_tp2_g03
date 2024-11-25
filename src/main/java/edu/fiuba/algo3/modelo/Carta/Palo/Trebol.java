package edu.fiuba.algo3.modelo.Carta.Palo;

public class Trebol extends Palo{
    @Override
    public boolean compararCon(Palo unPalo){ return unPalo.compararConTrebol(this);}

    @Override
    public boolean compararConTrebol(Trebol unPalo){ return true;}
}
