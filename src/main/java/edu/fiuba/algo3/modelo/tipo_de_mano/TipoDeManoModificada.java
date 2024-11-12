package edu.fiuba.algo3.modelo.tipo_de_mano;

import java.util.ArrayList;
import edu.fiuba.algo3.modelo.Carta;

public class TipoDeManoModificada implements TipoDeMano{

    private TipoDeMano tipoDeMano;
    private int multiplicadorNuevo;

    public TipoDeManoModificada(TipoDeMano tipoDeMano, int multiplicadorNuevo) {
        this.tipoDeMano = tipoDeMano;
        this.multiplicadorNuevo = multiplicadorNuevo;
    }

    @Override
    public boolean esValida(ArrayList<Carta> mano){
        return tipoDeMano.esValida(mano);
    }

    @Override
    public int calcularPuntos(){
        return tipoDeMano.calcularPuntos();
    }

    @Override
    public int calcularMultiplicador(){
        return multiplicadorNuevo;
    }

    @Override
    public TipoDeMano aplicarMultiplicador(int multiplicador){
        return this;
    }


}
