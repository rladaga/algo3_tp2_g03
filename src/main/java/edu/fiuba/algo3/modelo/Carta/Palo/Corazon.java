package edu.fiuba.algo3.modelo.Carta.Palo;

public class Corazon extends Palo{
    @Override
    public boolean compararCon(Palo unPalo){ return unPalo.compararConCorazon(this);}

    @Override
    public boolean compararConCorazon(Corazon unPalo){ return true;}
}
