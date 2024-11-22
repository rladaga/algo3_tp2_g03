package edu.fiuba.algo3.modelo.Joker.GeneradorRandom;

import java.util.Random;

public class NumeroAleatorio implements GeneradorRandom {
    private int probabilidad;
    private Random rand;

    public NumeroAleatorio(int probabilidad) {
        this.probabilidad = probabilidad;
        this.rand = new Random();
    }

    @Override
    public boolean validar(){
      return rand.nextInt(probabilidad) + 1 == 1;
    }
}
