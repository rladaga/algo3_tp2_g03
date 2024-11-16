package edu.fiuba.algo3.modelo.ManoDePoker;
import edu.fiuba.algo3.modelo.Carta.Carta;

import java.util.ArrayList;

public class Poker extends ManoDePoker {
    public Poker() {
        this.mejoraMano = new MejoraMano();
    }

    @Override
    public boolean esValida(ArrayList<Carta> mano) {
        return cuentaRepeticiones(mano, 4) == 1;
    }

    @Override
    public int calcularPuntos() {
        return mejoraMano.agregarPuntuacionBase(60);
    }

    @Override
    public int calcularMultiplicador() {
        return mejoraMano.agregarMultiplicadorBase(7);
    }

    @Override
    public boolean esIgual(ManoDePoker mano) {
        return mano instanceof Poker;
    }
}
