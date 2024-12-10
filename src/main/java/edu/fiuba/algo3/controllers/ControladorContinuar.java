package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.Balatro;
import edu.fiuba.algo3.vistas.VistaPartida;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorContinuar implements EventHandler<ActionEvent> {

    Balatro modelo;
    VistaPartida vistaPartida;

    public ControladorContinuar(Balatro modelo, VistaPartida vistaPartida) {
        this.modelo = modelo;
        this.vistaPartida = vistaPartida;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        modelo.siguienteRonda();
        vistaPartida.mostrarMesa();
    }
}