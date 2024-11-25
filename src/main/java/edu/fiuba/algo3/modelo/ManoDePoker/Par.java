package edu.fiuba.algo3.modelo.ManoDePoker;
import edu.fiuba.algo3.modelo.Carta.Carta;

import java.util.ArrayList;

public class Par extends ManoDePoker {
    public Par() {
        this.mejoraMano = new MejoraMano();
    }

    @Override
    public boolean esValida(ArrayList<Carta> mano) {
        return cuentaRepeticiones(mano, 2) == 1;
    }

    @Override
    public int calcularPuntos() {
        return mejoraMano.agregarPuntuacionBase(10);
    }

    @Override
    public int calcularMultiplicador() {
        return mejoraMano.agregarMultiplicadorBase(2);
    }

    @Override
    public boolean esIgual(ManoDePoker mano) {
        return mano.esIgualAPar(this);
    }
    @Override
    public boolean esIgualAPar(Par mano){
        return true;
    }

}
