package edu.fiuba.algo3.modelo.Carta.Palo;

public abstract class Palo {

    public abstract boolean compararCon(Palo unPalo);

    public boolean compararConDiamante(Diamante unPalo) {return false;}
    public boolean compararConCorazon(Corazon unPalo){return false;}
    public boolean compararConPicas(Picas unPalo){return false;}
    public boolean compararConTrebol(Trebol unPalo){return false;}


}
