package edu.fiuba.algo3.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ControladorPantallaCompleta implements EventHandler<ActionEvent> {
    private Stage stage;
    private boolean isFullScreen;

    public ControladorPantallaCompleta(Stage stage) {
        this.stage = stage;
        this.isFullScreen = stage.isFullScreen();
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        isFullScreen = !isFullScreen;
        stage.setFullScreen(isFullScreen);
    }
}
