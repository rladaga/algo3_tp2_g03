package edu.fiuba.algo3.modelo.ManoDePoker;
import edu.fiuba.algo3.modelo.Carta.Carta;

import java.util.ArrayList;

public class DoblePar extends ManoDePoker {
    @Override
    public boolean esValida(ArrayList<Carta> mano) {
        return cuentaRepeticiones(mano, 2) == 2;
    }

    @Override
    public int calcularPuntos() {
        return 20;
    }

    @Override
    public int calcularMultiplicador() {
        return 2;
    }

    @Override
    public ManoDePokerModificada aplicarMultiplicador(int multiplicador){
        ManoDePokerModificada tipoDeMano = new ManoDePokerModificada(this, multiplicador);
        return tipoDeMano;
    }

    @Override
    public boolean esIgual(ManoDePoker mano) {
        return mano instanceof DoblePar;
    }
}
