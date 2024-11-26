package edu.fiuba.algo3.modelo.Carta;

import edu.fiuba.algo3.modelo.Carta.Palo.Palo;
import edu.fiuba.algo3.modelo.Carta.Valor.Valor;

public class FabricaDeCartas {
    public static Carta crearCarta(Palo palo, Valor valor){
        return new Carta(palo, valor);
    }
}
