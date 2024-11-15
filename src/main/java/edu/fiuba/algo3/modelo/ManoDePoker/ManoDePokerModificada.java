package edu.fiuba.algo3.modelo.ManoDePoker;

import java.util.ArrayList;
import edu.fiuba.algo3.modelo.Carta.Carta;

public class ManoDePokerModificada extends ManoDePoker {

    private ManoDePoker manoDePoker;
    private int multiplicadorNuevo;

    public ManoDePokerModificada(ManoDePoker manoDePoker, int multiplicadorNuevo) {
        this.manoDePoker = manoDePoker;
        this.multiplicadorNuevo = multiplicadorNuevo;
    }

    @Override
    public boolean esValida(ArrayList<Carta> mano){
        return manoDePoker.esValida(mano);
    }

    @Override
    public int calcularPuntos(){
        return manoDePoker.calcularPuntos();
    }

    @Override
    public int calcularMultiplicador(){
        return multiplicadorNuevo;
    }

    @Override
    public ManoDePoker aplicarMultiplicador(int multiplicador){
        return this;
    }


}
