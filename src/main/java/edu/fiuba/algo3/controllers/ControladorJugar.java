package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.Balatro;
import edu.fiuba.algo3.vistas.ElementosAuxiliares.ReproductorMusica;
import edu.fiuba.algo3.vistas.VistasAuxiliares.VistaPartida;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;

public class ControladorJugar implements EventHandler<ActionEvent> {

    Stage stage;
    ReproductorMusica reproductor;
    MenuBar menuBar;
    String nombreJugador;
    Balatro modelo;

    public ControladorJugar(Stage stagePrimario, ReproductorMusica reproductor, MenuBar menuBar, String nombreJugador, Balatro modelo) {
        this.stage = stagePrimario;
        this.reproductor = reproductor;
        this.menuBar = menuBar;
        this.nombreJugador = nombreJugador;
        this.modelo = modelo;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        boolean estabaEnPantallaCompleta = stage.isFullScreen();

        VistaPartida vistaMesa = new VistaPartida(stage, reproductor, menuBar, nombreJugador, modelo);

        Platform.runLater(() -> {
            stage.getScene().setRoot(vistaMesa);

            if (estabaEnPantallaCompleta) {
                stage.setFullScreen(true);
            }
        });
    }
}
