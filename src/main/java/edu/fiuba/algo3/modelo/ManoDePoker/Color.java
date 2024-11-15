package edu.fiuba.algo3.modelo.ManoDePoker;

import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.Carta.Palo.Palo;

import java.util.ArrayList;


public class Color extends ManoDePoker {
    @Override
    public boolean esValida(ArrayList<Carta> mano) {
        Palo paloInicial = mano.get(0).getPalo();
        for (Carta carta : mano) {
            if (!carta.compararPalo(paloInicial)) {
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
}