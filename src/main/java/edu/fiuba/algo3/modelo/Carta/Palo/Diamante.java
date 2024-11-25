package edu.fiuba.algo3.modelo.Carta.Palo;

public class Diamante extends Palo{
    @Override
    public boolean compararCon(Palo unPalo){ return unPalo.compararConDiamante(this);}

    @Override
    public boolean compararConDiamante(Diamante unPalo){ return true;}
}
