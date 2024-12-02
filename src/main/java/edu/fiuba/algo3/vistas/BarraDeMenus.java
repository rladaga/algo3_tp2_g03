package edu.fiuba.algo3.vistas;

import javafx.scene.Scene;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;



public class BarraDeMenus extends MenuBar {


    private Stage stage;
    private MediaPlayer mediaPlayer;
    private boolean isMusicPlaying = false;
    private Font customFont;

    public BarraDeMenus(Stage stage, MediaPlayer mediaPlayer) {
        this.stage = stage;
        this.mediaPlayer = mediaPlayer;

        inicializarMenu();

    }

    private void inicializarMenu() {
        Menu menuOpciones = new Menu("Opciones");

        MenuItem pantallaCompleta = new MenuItem("Pantalla completa");
        pantallaCompleta.setOnAction(event -> {
            boolean isFullScreen = stage.isFullScreen();
            stage.setFullScreen(!isFullScreen);
        });

        MenuItem toggleMusic = new MenuItem("Música: OFF");
        toggleMusic.setOnAction(event -> {
            if (isMusicPlaying) {
                mediaPlayer.pause();
                toggleMusic.setText("Música: OFF");
            } else {
                mediaPlayer.play();
                toggleMusic.setText("Música: ON");
            }
            isMusicPlaying = !isMusicPlaying;
        });

        menuOpciones.getItems().addAll(pantallaCompleta);

        javafx.scene.control.Menu menuMusica = new Menu("Musica");
        menuMusica.getItems().addAll(toggleMusic);

        this.getMenus().addAll(menuOpciones, menuMusica);

    }
}
