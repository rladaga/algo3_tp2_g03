package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collections;

public class Mazo {
    private ArrayList<Carta> cartas;

    public Mazo(){
        inicializarMazo();
    }

    public int cantidadCartas() {
        return cartas.size();
    }

    private void inicializarMazo(){
        cartas = new ArrayList<>();
        for(Palo palo : Palo.values()){
            for(Valor valor : Valor.values()){
                cartas.add(new Carta(palo, valor));
            }
        }

        mezclarCartas();
    }

    public ArrayList<Carta> repartir(){
        ArrayList<Carta> cartasARepartir = new ArrayList<Carta>();
        for (int i = 1; i < 9; i++) {
            cartasARepartir.add(cartas.get(i - 1));
        }

        return cartasARepartir;
    }

    public void mezclarCartas(){
        Collections.shuffle(cartas);
    }
}
