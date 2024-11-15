package edu.fiuba.algo3.modelo.ManoDePoker;

import edu.fiuba.algo3.modelo.Carta.Carta;

import java.util.ArrayList;

public class FullHouse extends ManoDePoker {
    @Override
    public boolean esValida(ArrayList<Carta> mano) {
        return cuentaRepeticiones(mano, 3) == 1 && cuentaRepeticiones(mano, 2) == 1;
    }

    @Override
    public int calcularPuntos() {
        return 40;
    }

    @Override
    public int calcularMultiplicador() {
        return 4;
    }

    @Override
    public ManoDePokerModificada aplicarMultiplicador(int multiplicador){
        ManoDePokerModificada tipoDeMano = new ManoDePokerModificada(this, multiplicador);
        return tipoDeMano;
    }
}