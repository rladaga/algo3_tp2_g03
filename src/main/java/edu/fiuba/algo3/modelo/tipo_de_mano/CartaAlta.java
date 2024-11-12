package edu.fiuba.algo3.modelo.tipo_de_mano;
import edu.fiuba.algo3.modelo.*;

import java.util.ArrayList;

public class CartaAlta implements TipoDeMano {
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
    public TipoDeManoModificada aplicarMultiplicador(int multiplicador){
        TipoDeManoModificada tipoDeMano = new TipoDeManoModificada(this, multiplicador);
        return tipoDeMano;
    }
}