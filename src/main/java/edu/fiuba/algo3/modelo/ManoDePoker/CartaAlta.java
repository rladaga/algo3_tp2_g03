package edu.fiuba.algo3.modelo.ManoDePoker;
import edu.fiuba.algo3.modelo.Carta.Carta;

import java.util.ArrayList;

public class CartaAlta extends ManoDePoker {
    @Override
    public boolean esValida(ArrayList<Carta> mano) {
        return true;
    }

    @Override
    public int calcularPuntos() {
        return 5;
    }

    @Override
    public int calcularMultiplicador() {
        return 1;
    }

    @Override
    public ManoDePokerModificada aplicarMultiplicador(int multiplicador){
        ManoDePokerModificada tipoDeMano = new ManoDePokerModificada(this, multiplicador);
        return tipoDeMano;
    }
}