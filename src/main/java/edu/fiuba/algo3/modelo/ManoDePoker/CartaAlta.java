package edu.fiuba.algo3.modelo.ManoDePoker;
import edu.fiuba.algo3.modelo.Carta.Carta;

import java.util.ArrayList;

public class CartaAlta extends ManoDePoker {
    public CartaAlta() {
        this.mejoraMano = new MejoraMano();
    }

    @Override
    public boolean esValida(ArrayList<Carta> mano) {
        return true;
    }

    @Override
    public int calcularPuntos() {
        return mejoraMano.agregarPuntuacionBase(5);
    }

    @Override
    public int calcularMultiplicador() {
        return mejoraMano.agregarMultiplicadorBase(1);
    }


    @Override
    public boolean esIgual(ManoDePoker mano) {
        return mano.esIgualACartaAlta(this);
    }

    @Override
    public boolean esIgualACartaAlta(CartaAlta mano){
        return true;
    }
}
