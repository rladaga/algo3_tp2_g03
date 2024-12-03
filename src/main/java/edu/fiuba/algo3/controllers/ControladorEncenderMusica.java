package edu.fiuba.algo3.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.media.MediaPlayer;

public class ControladorEncenderMusica implements EventHandler<ActionEvent> {

    private final MediaPlayer mediaPlayer;
    private final Menu menuMusica;

    public ControladorEncenderMusica(MediaPlayer mediaPlayer, Menu menuMusica) {
        this.mediaPlayer = mediaPlayer;
        this.menuMusica = menuMusica;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        mediaPlayer.play();
        menuMusica.getItems().clear();
        MenuItem itemApagar = new MenuItem("OFF");
        itemApagar.setOnAction(new ControladorApagarMusica(mediaPlayer, menuMusica));
        menuMusica.getItems().add(itemApagar);
    }
}
