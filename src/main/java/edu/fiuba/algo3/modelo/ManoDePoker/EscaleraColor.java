package edu.fiuba.algo3.modelo.ManoDePoker;
import edu.fiuba.algo3.modelo.Carta.Carta;

import java.util.ArrayList;

public class EscaleraColor extends ManoDePoker {
    @Override
    public boolean esValida(ArrayList<Carta> mano) {
        return new Escalera().esValida(mano) && new Color().esValida(mano);
    }

    @Override
    public int calcularPuntos() {
        return 100;
    }

    @Override
    public int calcularMultiplicador() {
        return 8;
    }

    @Override
    public ManoDePokerModificada aplicarMultiplicador(int multiplicador){
        ManoDePokerModificada tipoDeMano = new ManoDePokerModificada(this, multiplicador);
        return tipoDeMano;
    }

    @Override
    public boolean esIgual(ManoDePoker mano) {
        return mano instanceof EscaleraColor;
    }

}