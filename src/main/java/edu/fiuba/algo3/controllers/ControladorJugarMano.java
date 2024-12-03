package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.Balatro;
import edu.fiuba.algo3.vistas.VistaPartida;
import edu.fiuba.algo3.vistas.VistaPrincipalMesa;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorJugarMano implements EventHandler<ActionEvent> {

    Balatro modelo;
    VistaPartida vistaPartida;

    public ControladorJugarMano(Balatro modelo, VistaPartida vistaPartida) {
        this.modelo = modelo;
        this.vistaPartida = vistaPartida;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        modelo.jugarMano();
        vistaPartida.actualizarPuntajeActual();
        modelo.repartirCartas();
        vistaPartida.actualizarCartasEnMano();
    }
}
