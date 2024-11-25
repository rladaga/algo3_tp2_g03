package edu.fiuba.algo3.modelo.ManoDePoker;
import edu.fiuba.algo3.modelo.Carta.Carta;

import java.util.ArrayList;

public class Trio extends ManoDePoker {
    public Trio() {
        this.mejoraMano = new MejoraMano();
    }


    @Override
    public boolean esValida(ArrayList<Carta> mano) {
        return cuentaRepeticiones(mano, 3) == 1;
    }

    @Override
    public int calcularPuntos() {
        return mejoraMano.agregarPuntuacionBase(30);
    }

    @Override
    public int calcularMultiplicador() {
        return mejoraMano.agregarMultiplicadorBase(3);
    }

    @Override
    public boolean esIgual(ManoDePoker mano) {
        return mano.esIgualATrio(this);
    }

    @Override
    public boolean esIgualATrio(Trio mano){
        return true;
    }
}
