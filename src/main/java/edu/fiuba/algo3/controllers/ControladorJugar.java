package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.Balatro;
import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.Mazo;
import edu.fiuba.algo3.modelo.Mezclador.IMezclador;
import edu.fiuba.algo3.modelo.Mezclador.MezcladorMazo;
import edu.fiuba.algo3.vistas.VistaPartida;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;


import java.util.ArrayList;

public class ControladorJugar implements EventHandler<ActionEvent> {

    Stage stage;
    MediaPlayer mediaPlayer;
    MenuBar menuBar;
    String nombreJugador;
    Balatro modelo;

    public ControladorJugar(Stage stagePrimario, MediaPlayer mediaPlayer, MenuBar menuBar, String nombreJugador, Balatro modelo) {
        this.stage = stagePrimario;
        this.mediaPlayer = mediaPlayer;
        this.menuBar = menuBar;
        this.nombreJugador = nombreJugador;
        this.modelo = modelo;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        boolean estabaEnPantallaCompleta = stage.isFullScreen();

        VistaPartida vistaMesa = new VistaPartida(stage, mediaPlayer, menuBar, nombreJugador, modelo);

        Platform.runLater(() -> {
            stage.getScene().setRoot(vistaMesa);

            if (estabaEnPantallaCompleta) {
                stage.setFullScreen(true);
            }
        });
    }
}
