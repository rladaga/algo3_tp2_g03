package edu.fiuba.algo3.modelo.tipo_de_mano;

import edu.fiuba.algo3.modelo.*;
import java.util.ArrayList;

public class FullHouse implements TipoDeMano {
    @Override
    public boolean esValida(ArrayList<Carta> mano) {
        return cuentaRepeticiones(mano, 3) == 1 && cuentaRepeticiones(mano, 2) == 1;
    }

    @Override
    public int calcularPuntos() {
        return 40;
    }

    @Override
    public int calcularMultiplicador() {
        return 4;
    }
}