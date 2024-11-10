package edu.fiuba.algo3.modelo.tipo_de_mano;

import edu.fiuba.algo3.modelo.*;
import java.util.ArrayList;


public class Color implements TipoDeMano {
    @Override
    public boolean esValida(ArrayList<Carta> mano) {
        Palo paloInicial = mano.get(0).getPalo();
        for (Carta carta : mano) {
            if (!carta.getPalo().equals(paloInicial)) {
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
}