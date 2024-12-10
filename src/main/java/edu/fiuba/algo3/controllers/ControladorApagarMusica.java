package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.vistas.ReproductorMusica;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.media.MediaPlayer;

public class ControladorApagarMusica implements EventHandler<ActionEvent> {
    private final ReproductorMusica reproductorMusica;
    private final Menu menuMusica;

    public ControladorApagarMusica(ReproductorMusica reproductorMusica, Menu menuMusica) {
        this.reproductorMusica = reproductorMusica;
        this.menuMusica = menuMusica;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        reproductorMusica.pause();
        menuMusica.getItems().clear();
        MenuItem itemEncender = new MenuItem("ON");
        itemEncender.setOnAction(new ControladorEncenderMusica(reproductorMusica, menuMusica));
        menuMusica.getItems().add(itemEncender);
    }
}

