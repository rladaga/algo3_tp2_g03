package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.Excepcion.EspacioJokersLlenoExcepction;
import edu.fiuba.algo3.modelo.Joker.Joker;
import edu.fiuba.algo3.modelo.Tarot.Tarot;
import edu.fiuba.algo3.modelo.Tarot.TarotManoPoker;

import java.util.ArrayList;
import java.util.Collections;

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
        Collections.sort(cartasEnMano, new OrdenarCarta());
    }

    public int cantidadCartasEnMano(){
        return cartasEnMano.size();
    }

    public void seleccionarCartaEnPosicion(int posicion){
        if(cartasAJugar.size()<5) {
            Carta carta = cartasEnMano.get(posicion);
            cartasAJugar.add(carta);
        }
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
        rondas.get(0).jugarRonda(cartasAJugar, jokers, evaluadorMano, this);
        cartasEnMano.removeAll(cartasAJugar);
        cartasAJugar.clear();
    }

    public void siguienteRonda() {
        mazo.restaurarMazo();
        rondas.remove(0);
        cartasEnMano.clear();
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
        if(jokers.size() == 5) {
            throw new EspacioJokersLlenoExcepction(" ");
        }
        else{
            jokers.add(joker);
        }

    }

    public void agregarTarot(Tarot tarot) {
        tarots.add(tarot);
    }

    public ArrayList<Joker> getJokers() {
        return jokers;
    }

    public void reinicarMazo() {
        mazo.restaurarMazo();
    }

    public void aplicarMejoraManoDePoker(TarotManoPoker tarotManoPoker) {
        evaluadorMano.aplicarMejoraManoDePoker(tarotManoPoker);
    }

    public boolean ultimaRonda() {
        return rondas.size() == 1;
    }

}
