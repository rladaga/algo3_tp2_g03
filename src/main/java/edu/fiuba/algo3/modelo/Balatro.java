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
    private ArrayList<Tarot> tarots;
    private ArrayList<Carta> cartasEnMano;
    private ArrayList<Carta> cartasAJugar;
    private EvaluadorMano evaluadorMano;

    public Balatro(ArrayList<Ronda> rondas, Mazo mazo) {
        this.rondas = rondas;
        this.mazo = mazo;
        this.tarots = new ArrayList<>();
        this.jokers = new ArrayList<>();
        this.cartasEnMano = new ArrayList<>();
        this.cartasAJugar = new ArrayList<>();
        this.evaluadorMano = new EvaluadorMano();
    }

    public int cartasEnMazo(){
        return mazo.cantidadCartas();
    }

    public void iniciarTurno(){
        cartasEnMano = mazo.repartir(8);
    }

    public void repartirCartas(){
        cartasEnMano.addAll(mazo.repartir(8 - cartasEnMano.size()));
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

    public void descartar() {
        if (rondas.get(0).permitirDescarte()) {
            cartasEnMano.removeAll(cartasAJugar);
        }
        cartasAJugar.clear();
    }

    public void seleccionarCarta(Carta carta) {
        cartasAJugar.add(carta);
    }

    public void deseleccionarCarta(Carta carta) {
        cartasAJugar.remove(carta);
    }

    public void jugarMano(){
        Ronda rondaActual = rondas.get(0);
        if(rondaActual.permitirJugar()) {
            rondaActual.jugarRonda(cartasAJugar, jokers, evaluadorMano);
            cartasEnMano.removeAll(cartasAJugar);
        }
        cartasAJugar.clear();
    }

    public ArrayList<Carta> getCartasEnMano() {
        return cartasEnMano;
    }

    public Ronda getRonda() {
        return rondas.get(0);
    }

    public void agregarCarta(Carta carta) {
        mazo.agregarCartaAlMazo(carta);
    }

    public void agregarJoker(Joker joker) {
        jokers.add(joker);
    }

    public void agregarTarot(Tarot tarot) {
        tarots.add(tarot);
    }

    /*public void iniciarJuego(){
        boolean resultado;
        for(Ronda ronda: rondas){
            resultado = ronda.resolverRonda(jugador);
        }
    }
*/


}
