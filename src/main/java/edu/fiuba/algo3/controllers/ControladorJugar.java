package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.Mazo;
import edu.fiuba.algo3.modelo.Mezclador.IMezclador;
import edu.fiuba.algo3.modelo.Mezclador.MezcladorMazo;
import edu.fiuba.algo3.vistas.VistaPartida;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ControladorJugar implements EventHandler<ActionEvent> {

    Stage stage;
    MediaPlayer mediaPlayer;

    public ControladorJugar(Stage stagePrimario, MediaPlayer mediaPlayer) {
        this.stage = stagePrimario;
        this.mediaPlayer = mediaPlayer;

    }

    @Override
    public void handle(ActionEvent actionEvent) {

        IMezclador mezclador = new MezcladorMazo();
        Mazo mazo = new Mazo(mezclador);
        ArrayList<Carta> cartas = mazo.repartir();

        VistaPartida vistaMesa = new VistaPartida(stage, cartas, mediaPlayer);
        Scene escenaMesa = new Scene(vistaMesa, 1366, 768);

        String fontFamily = "Balatro";
        String css = "-fx-font-family: '" + fontFamily + "';";

        escenaMesa.getRoot().setStyle(css);

        stage.setScene(escenaMesa);
    }
}
