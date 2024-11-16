package edu.fiuba.algo3.modelo.ManoDePoker;
import edu.fiuba.algo3.modelo.Carta.Carta;

import java.util.ArrayList;

public class EscaleraColor extends ManoDePoker {
    public EscaleraColor() {
        this.mejoraMano = new MejoraMano();
    }

    @Override
    public boolean esValida(ArrayList<Carta> mano) {
        return new Escalera().esValida(mano) && new Color().esValida(mano);
    }

    @Override
    public int calcularPuntos() {
        return mejoraMano.agregarPuntuacionBase(100);
    }

    @Override
    public int calcularMultiplicador() {
        return mejoraMano.agregarMultiplicadorBase(8);
    }

    @Override
    public boolean esIgual(ManoDePoker mano) {
        return mano instanceof EscaleraColor;
    }

}