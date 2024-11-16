package edu.fiuba.algo3.modelo.Joker;

import edu.fiuba.algo3.modelo.GeneradorRandom.GeneradorRandom;
import edu.fiuba.algo3.modelo.ManoDePoker.ManoDePoker;

public class Aleatorio implements CondicionActivacion {
    private GeneradorRandom generador;

    public Aleatorio(GeneradorRandom generador) {
        this.generador = generador;
    }

    @Override
    public boolean realizarValidacion(ManoDePoker manoDePoker, int cantidadDescartes) {
        return generador.validar();
    }
}
