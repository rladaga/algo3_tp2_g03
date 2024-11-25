package edu.fiuba.algo3.modelo.ManoDePoker;

import edu.fiuba.algo3.modelo.Carta.Carta;

import java.util.ArrayList;


public class Color extends ManoDePoker {
    public Color() {
        this.mejoraMano = new MejoraMano();
    }

    @Override
    public boolean esValida(ArrayList<Carta> mano) {
        Carta cartaInicial = mano.get(0);

        for (Carta carta : mano) {
            if (!carta.compararPalo(cartaInicial)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int calcularPuntos() {
        return mejoraMano.agregarPuntuacionBase(35);
    }

    @Override
    public int calcularMultiplicador() {
        return mejoraMano.agregarMultiplicadorBase(4);
    }


    @Override
    public boolean esIgual(ManoDePoker mano) {
        return mano.esIgualAColor(this);
    }

    @Override
    public boolean esIgualAColor(Color mano){
        return true;
    }
}
