package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Carta.Carta;

import java.util.ArrayList;

public class Jugador {
    private Mazo mazo;
    private ArrayList<Carta> cartasEnMano;
    private ArrayList<Carta> cartasAJugar;
    private Descartes descartes;

    public Jugador(Mazo mazo, Descartes descartes){
        this.mazo = mazo;
        this.cartasAJugar = new ArrayList<>();
        this.cartasEnMano = new ArrayList<>();
        this.descartes = descartes;

    }

    public int cartasEnMazo(){
        return mazo.cantidadCartas();
    }

    public void iniciarTurno(){
        cartasEnMano = mazo.repartir();
    }

    public int cantidadCartasEnMano(){
        return cartasEnMano.size();
    }

    public void seleccionarCartaEnPosicion(int posicion){
        Carta carta = cartasEnMano.get(posicion);
        cartasAJugar.add(carta);
    }

    public void descartar(ArrayList<Carta> cartasADescartar){
        if(descartes.permitirDescarte()) {
            cartasEnMano.removeAll(cartasADescartar);
            cartasEnMano.addAll(mazo.repartir(cartasADescartar.size()));
        };

    }

    public ArrayList<Carta> jugarMano(){
        return cartasAJugar;
    }
}
