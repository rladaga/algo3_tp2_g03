package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.vistas.ElementosAuxiliares.ReproductorMusica;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

public class ControladorEncenderMusica implements EventHandler<ActionEvent> {
    private final ReproductorMusica reproductorMusica;
    private final Menu menuMusica;

    public ControladorEncenderMusica(ReproductorMusica reproductorMusica, Menu menuMusica) {
        this.reproductorMusica = reproductorMusica;
        this.menuMusica = menuMusica;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        reproductorMusica.play();
        menuMusica.getItems().clear();
        MenuItem itemApagar = new MenuItem("OFF");
        MenuItem itemSiguiente = new MenuItem("Siguiente");
        MenuItem itemAnterior = new MenuItem("Anterior");

        itemApagar.setOnAction(new ControladorApagarMusica(reproductorMusica, menuMusica));
        itemSiguiente.setOnAction(e -> reproductorMusica.siguienteCancion());
        itemAnterior.setOnAction(e -> reproductorMusica.anteriorCancion());

        menuMusica.getItems().addAll(itemApagar, itemAnterior, itemSiguiente);
    }
}
