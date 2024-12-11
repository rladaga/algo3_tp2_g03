package edu.fiuba.algo3.modelo.Fabricas;

import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.Carta.Palo.Palo;
import edu.fiuba.algo3.modelo.Carta.Valor.Valor;

public class FabricaDeCarta {
    public static Carta crearCarta(Palo palo, Valor valor){
        return new Carta(palo, valor);
    }
}
