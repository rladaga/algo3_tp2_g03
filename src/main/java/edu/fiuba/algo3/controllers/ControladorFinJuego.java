package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.Balatro;
import edu.fiuba.algo3.modelo.parser.ParserBalatro;
import edu.fiuba.algo3.vistas.ReproductorMusica;
import edu.fiuba.algo3.vistas.VistaMenuInicial;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ControladorFinJuego implements EventHandler<ActionEvent> {

    private Stage stage;
    private ReproductorMusica reproductor;
    private String nombreJugador;

    public ControladorFinJuego(Stage stage, ReproductorMusica reproductorMusica, String nombreJugador) {
        this.stage = stage;
        this.reproductor = reproductorMusica;
        this.nombreJugador = nombreJugador;
    }

    @Override
    public void handle(ActionEvent actionEvent)  {
        try {
            ParserBalatro parser = new ParserBalatro();
            Balatro modelo = parser.pasearBalatro();

            VistaMenuInicial menuVisual = new VistaMenuInicial(stage, reproductor, modelo, nombreJugador);
            Scene escenaMenu = new Scene(menuVisual, 1366, 768);

            String fontFamily = "Balatro";
            String css = "-fx-font-family: '" + fontFamily + "';";
            escenaMenu.getRoot().setStyle(css);

            stage.setScene(escenaMenu);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
