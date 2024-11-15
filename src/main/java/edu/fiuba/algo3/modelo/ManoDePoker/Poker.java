package edu.fiuba.algo3.modelo.ManoDePoker;
import edu.fiuba.algo3.modelo.Carta.Carta;

import java.util.ArrayList;

public class Poker extends ManoDePoker {
    @Override
    public boolean esValida(ArrayList<Carta> mano) {
        return cuentaRepeticiones(mano, 4) == 1;
    }

    @Override
    public int calcularPuntos() {
        return 60;
    }

    @Override
    public int calcularMultiplicador() {
        return 7;
    }

    @Override
    public ManoDePokerModificada aplicarMultiplicador(int multiplicador){
        ManoDePokerModificada tipoDeMano = new ManoDePokerModificada(this, multiplicador);
        return tipoDeMano;
    }
}
