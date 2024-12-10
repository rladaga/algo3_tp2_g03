package edu.fiuba.algo3.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorCierreJuego implements EventHandler<ActionEvent> {

    public ControladorCierreJuego() {}

    @Override
    public void handle(ActionEvent actionEvent) {
        System.exit(0);
    }
}
