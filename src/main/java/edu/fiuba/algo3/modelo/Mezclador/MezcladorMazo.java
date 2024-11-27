package edu.fiuba.algo3.modelo.Mezclador;

import java.util.Collections;
import edu.fiuba.algo3.modelo.Carta.Carta;

import java.util.ArrayList;

public class MezcladorMazo implements IMezclador {

    @Override
    public void mezclar(ArrayList<Carta> cartas) {
        Collections.shuffle(cartas);
    }   
}
