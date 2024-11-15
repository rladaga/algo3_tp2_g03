package edu.fiuba.algo3.modelo.ManoDePoker;
import edu.fiuba.algo3.modelo.Carta.Carta;

import java.util.ArrayList;

public class Trio extends ManoDePoker {
    @Override
    public boolean esValida(ArrayList<Carta> mano) {
        return cuentaRepeticiones(mano, 3) == 1;
    }

    @Override
    public int calcularPuntos() {
        return 30;
    }

    @Override
    public int calcularMultiplicador() {
        return 3;
    }

    @Override
    public ManoDePokerModificada aplicarMultiplicador(int multiplicador){
        ManoDePokerModificada tipoDeMano = new ManoDePokerModificada(this, multiplicador);
        return tipoDeMano;
    }
}
