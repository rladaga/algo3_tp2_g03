package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.Balatro;
import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.Joker.Joker;

public class ControladorAgregarTienda {
    private Carta carta;
    private Joker joker;

    private Balatro modelo;

    public ControladorAgregarTienda(Balatro modelo){
        this.modelo = modelo;
        this.carta = null;
        this.joker = null;
    }

    public void agregarCarta(Carta carta){
        this.carta = carta;
    }

    public void removerCarta(){
        this.carta = null;
    }

    public void agregarJoker(Joker joker){
        this.joker = joker;
    }

    public void removerJoker(){
        this.joker = null;
    }

    public boolean haySeleccion(){
        if(carta != null || joker != null){
            return true;
        }
        return false;
    }
}
