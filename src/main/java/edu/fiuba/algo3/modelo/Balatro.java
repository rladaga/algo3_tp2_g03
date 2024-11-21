package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Balatro {
    private ArrayList<Ronda> rondas;

    public Balatro() {}

    public Balatro(ArrayList<Ronda> rondas) {
        this.rondas = rondas;
    }

    public void agregarRonda(Ronda ronda) {
        rondas.add(ronda);
    }




}
