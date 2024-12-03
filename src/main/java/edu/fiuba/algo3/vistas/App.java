package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Balatro;
import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.Mazo;
import edu.fiuba.algo3.modelo.Mezclador.IMezclador;
import edu.fiuba.algo3.modelo.Mezclador.MezcladorMazo;
import edu.fiuba.algo3.modelo.parser.ParserBalatro;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

/**
 * JavaFX App
 */
public class App extends Application {

    private Stage stage;
    private MediaPlayer mediaPlayer;
    private Font customFont;

    @Override
    public void start(Stage stagePrimario) throws FileNotFoundException {
        stage = stagePrimario;
        stagePrimario.setTitle("Balatro");
        stagePrimario.getIcons().add(new Image(getClass().getResourceAsStream("/imagenes/logo_balatro.png")));
        ParserBalatro parser = new ParserBalatro();
        Balatro modelo = parser.pasearBalatro();

        String mediaPath = getClass().getResource("/audio/wii.mp3").toExternalForm();
        Media media = new Media(mediaPath);
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);

        customFont = Font.loadFont(
                getClass().getResourceAsStream("/tipografia/balatro.ttf"),
                20
        );

        VistaMenuInicial menuVisual = new VistaMenuInicial(stagePrimario, mediaPlayer, modelo);
        Scene escenaMenu = new Scene(menuVisual, 1366, 768);

        String fontFamily = "Balatro";
        String css = "-fx-font-family: '" + fontFamily + "';";

        escenaMenu.getRoot().setStyle(css);

        stagePrimario.setScene(escenaMenu);
        stagePrimario.setResizable(false);
        stagePrimario.show();
    }

    public static void main(String[] args) {
        launch();
    }

}