package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.Joker.Joker;
import edu.fiuba.algo3.modelo.PuntuacionTirada.PuntuacionTirada;

import java.util.ArrayList;

public class Ronda{
    private int numeroRonda;
    private Descarte descartes;
    private Mano manos;
    private int puntajeObjetivo;
    private Tienda tienda;
    private int puntajeActual;

    public Ronda(int numeroRonda, Descarte descartes, Mano manos, int puntajeObjetivo, Tienda tienda){
        this.numeroRonda = numeroRonda;
        this.descartes = descartes;
        this.manos = manos;
        this.puntajeObjetivo = puntajeObjetivo;
        this.tienda = tienda;
        this.puntajeActual = 0;
    }

    public void jugarRonda(ArrayList<Carta> cartasAJugar, ArrayList<Joker> jokers, EvaluadorMano evaluadorMano, Balatro balatro) {
        if (manos.permitirTirada()) {
            puntajeActual += evaluadorMano.evaluar(cartasAJugar, jokers, descartes);
        }
    }


    public Integer getPuntajeObjetivo() {
        return puntajeObjetivo;
    }
    public Integer getPuntajeActual() {
        return puntajeActual;
    }

    public int getNumeroRonda() {
        return numeroRonda;
    }

    public Descarte getDescartes() {
        return descartes;
    }

    public Mano getManos() {
        return manos;
    }

    public Tienda getTienda() {
        return this.tienda;
    }

    public boolean permitirDescarte() {
        return descartes.permitirDescarte();
    }

    public boolean permitirJugar(){
        return manos.permitirTirada();
    }
}


