package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.PuntuacionTirada.PuntuacionTirada;

import java.util.ArrayList;

public class Balatro {
    private ArrayList<Ronda> rondas;
    private Jugador jugador;
    private Descarte descarte;
    private Mano mano;

    public Balatro(ArrayList<Ronda> rondas, Jugador jugador) {
        this.rondas = rondas;
        this.jugador = jugador;
        iniciarJuego();
    }

    public void agregarRonda(Ronda ronda) {
        rondas.add(ronda);
    }

    public void iniciarJuego(){
        boolean resultado;
        for(Ronda ronda: rondas){
            resultado = ronda.resolverRonda(jugador, descarte, mano);
        }
    }


}
