package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.Balatro;
import edu.fiuba.algo3.vistas.VistasAuxiliares.VistaPartida;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorDescartar implements EventHandler<ActionEvent> {

    Balatro modelo;
    VistaPartida vistaPartida;

    public ControladorDescartar(Balatro modelo, VistaPartida vistaPartida) {
        this.modelo = modelo;
        this.vistaPartida = vistaPartida;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        modelo.descartar();
        vistaPartida.actualizarCajaDescartes(modelo.getRonda().getDescartes().getDescartesRestantes());
        vistaPartida.actualizarCartasEnMano();
    }
}
