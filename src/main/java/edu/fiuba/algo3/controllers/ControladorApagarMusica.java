package edu.fiuba.algo3.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.media.MediaPlayer;

public class ControladorApagarMusica implements EventHandler<ActionEvent> {

    private final MediaPlayer mediaPlayer;
    private final Menu menuMusica;

    public ControladorApagarMusica(MediaPlayer mediaPlayer, Menu menuMusica) {
        this.mediaPlayer = mediaPlayer;
        this.menuMusica = menuMusica;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        mediaPlayer.pause();
        menuMusica.getItems().clear();
        MenuItem itemEncender = new MenuItem("ON");
        itemEncender.setOnAction(new ControladorEncenderMusica(mediaPlayer, menuMusica));
        menuMusica.getItems().add(itemEncender);
    }
}

