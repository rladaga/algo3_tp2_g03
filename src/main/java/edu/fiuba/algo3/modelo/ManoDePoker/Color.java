package edu.fiuba.algo3.modelo.ManoDePoker;

import edu.fiuba.algo3.modelo.Carta.Carta;

import java.util.ArrayList;


public class Color extends ManoDePoker {
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
        return 35;
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

    @Override
    public boolean esIgual(ManoDePoker mano) {
        return mano instanceof Color;
    }
}
