package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Carta.Carta;

import java.util.Comparator;

class OrdenarCarta implements Comparator<Carta>
{


    public int compare(Carta a, Carta b)
    {
        return b.obtenerIndice() - a.obtenerIndice();
    }
}
