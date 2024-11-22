package edu.fiuba.algo3.modelo.ManoDePoker;
import edu.fiuba.algo3.modelo.Carta.Carta;

import java.util.ArrayList;

public class DoblePar extends ManoDePoker {
    public DoblePar() {
        this.mejoraMano = new MejoraMano();
    }

    @Override
    public boolean esValida(ArrayList<Carta> mano) {
        return cuentaRepeticiones(mano, 2) == 2;
    }

    @Override
    public int calcularPuntos() {
        return mejoraMano.agregarPuntuacionBase(20);
    }

    @Override
    public int calcularMultiplicador() {
        return mejoraMano.agregarPuntuacionBase(2);
    }

    @Override
    public boolean esIgual(ManoDePoker mano) {
        return mano.esIgualADoblePar(this);
    }

    @Override
    public boolean esIgualADoblePar(DoblePar mano){
        return true;
    }
}
