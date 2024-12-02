package edu.fiuba.algo3.controllers;

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

    public ControladorJugar(Stage stagePrimario, MediaPlayer mediaPlayer, MenuBar menuBar, String nombreJugador) {
        this.stage = stagePrimario;
        this.mediaPlayer = mediaPlayer;
        this.menuBar = menuBar;
        this.nombreJugador = nombreJugador;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        boolean estabaEnPantallaCompleta = stage.isFullScreen();

        IMezclador mezclador = new MezcladorMazo();
        Mazo mazo = new Mazo(mezclador);
        ArrayList<Carta> cartas = mazo.repartir();

        VistaPartida vistaMesa = new VistaPartida(stage, cartas, mediaPlayer, menuBar, nombreJugador);

        Platform.runLater(() -> {
            stage.getScene().setRoot(vistaMesa);
            System.out.println("Nombre del jugador: " + nombreJugador);
            if (estabaEnPantallaCompleta) {
                stage.setFullScreen(true);
            }
        });
    }
}
