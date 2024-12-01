package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.Joker.Joker;
import edu.fiuba.algo3.modelo.PuntuacionTirada.PuntuacionTirada;
import edu.fiuba.algo3.modelo.Tarot.Tarot;

import java.util.ArrayList;

public class Balatro {
    private ArrayList<Ronda> rondas;
    private Mazo mazo;
    private ArrayList<Joker> jokers;
    private ArrayList<Carta> cartasEnMano;
    private ArrayList<Carta> cartasAJugar;

    public Balatro(ArrayList<Ronda> rondas, Mazo mazo) {
        this.rondas = rondas;
        this.mazo = mazo;
        this.jokers = new ArrayList<>();
        cartasAJugar = new ArrayList<>();
    }

    public int cartasEnMazo(){
        return mazo.cantidadCartas();
    }

    public void iniciarTurno(){
        cartasEnMano = mazo.repartir();
    }

    public void repartirCartas(){
        cartasEnMano = mazo.repartir(8 - cartasEnMano.size());
    }

    public int cantidadCartasEnMano(){
        return cartasEnMano.size();
    }

    public void seleccionarCartaEnPosicion(int posicion){
        if(cartasAJugar.size()<5) {
            Carta carta = cartasEnMano.get(posicion);
            cartasAJugar.add(carta);
        }// else throw excepcion
    }

    public void descartar(ArrayList<Carta> cartasADescartar, Descarte descartes) {
        if (descartes.permitirDescarte()) {
            cartasEnMano.removeAll(cartasADescartar);
            cartasEnMano.addAll(mazo.repartir(cartasADescartar.size()));
        }
        ;
    }

    public ArrayList<Carta> jugarMano(){
        return cartasAJugar;
    }

    /*public void iniciarJuego(){
        boolean resultado;
        for(Ronda ronda: rondas){
            resultado = ronda.resolverRonda(jugador);
        }
    }
*/


}
