package edu.fiuba.algo3.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControladorNombreJugador implements EventHandler<ActionEvent> {

    private final TextField nombreJugador;
    private final Dialog<String> dialog;

    public ControladorNombreJugador(TextField nombreJugador, Dialog<String> dialog) {
        this.nombreJugador = nombreJugador;
        this.dialog = dialog;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String nombre = nombreJugador.getText();
        dialog.setResult(nombre);

        dialog.close();
    }
}
