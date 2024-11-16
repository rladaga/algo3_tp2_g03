package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Carta.Carta;

import java.util.ArrayList;

public class Jugador {
    private Mazo mazo;
    private ArrayList<Carta> cartasEnMano;
    private ArrayList<Carta> cartasAJugar;
    private int cantidadDescartes;

    public Jugador(Mazo mazo){
        this.mazo = mazo;
        this.cartasAJugar = new ArrayList<>();
        this.cantidadDescartes = 0;
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
        if(cantidadDescartes<3) {
            cartasEnMano.removeAll(cartasADescartar);
            cartasEnMano.addAll(mazo.repartir(cartasADescartar.size()));
            cantidadDescartes++;
        };

    }

    public ArrayList<Carta> jugarMano(){
        return cartasAJugar;
    }
}
