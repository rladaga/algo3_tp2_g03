package edu.fiuba.algo3.modelo.ManoDePoker;

import edu.fiuba.algo3.modelo.Carta.Carta;

import java.util.ArrayList;

public class FullHouse extends ManoDePoker {
    public FullHouse() {
        this.mejoraMano = new MejoraMano();
    }

    @Override
    public boolean esValida(ArrayList<Carta> mano) {
        return cuentaRepeticiones(mano, 3) == 1 && cuentaRepeticiones(mano, 2) == 1;
    }

    @Override
    public int calcularPuntos() {
        return mejoraMano.agregarPuntuacionBase(40);
    }

    @Override
    public int calcularMultiplicador() {
        return mejoraMano.agregarMultiplicadorBase(4);
    }

    @Override
    public boolean esIgual(ManoDePoker mano) {
        return mano.esIgualAFullHouse(this);
    }

    @Override
    public boolean esIgualAFullHouse(FullHouse mano){
        return true;
    }
}
