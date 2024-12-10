package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.Balatro;
import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.Joker.Joker;
import edu.fiuba.algo3.vistas.VistaPartida;
import edu.fiuba.algo3.vistas.VistaTienda;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorAgregarTienda implements EventHandler<ActionEvent> {
    private Carta carta;
    private Joker joker;
    private VistaPartida vistaPartida;
    private Balatro modelo;

    public ControladorAgregarTienda(Balatro modelo, VistaPartida vistaPartida){
        this.modelo = modelo;
        this.carta = null;
        this.joker = null;
        this.vistaPartida = vistaPartida;
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

    @Override
    public void handle(ActionEvent actionEvent) {
        if (carta != null) {
            modelo.agregarCarta(carta);
        } else if (joker != null) {
            modelo.agregarJoker(joker);
        }
    }
}
