package edu.fiuba.algo3.vistas.ElementosAuxiliares;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.util.ArrayList;

public class ReproductorMusica {
    private ArrayList<String> canciones;
    private int cancionActual;
    private MediaPlayer mediaPlayer;

    public ReproductorMusica() {
        canciones = new ArrayList<>();
        canciones.add("/audio/wii.mp3");
        canciones.add("/audio/rickroll.mp3");
        canciones.add("/audio/balatro.mp3");
        canciones.add("/audio/mario.mp3");

        cancionActual = 0;
        inicializarMediaPlayer();
    }

    private void inicializarMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.dispose();
        }
        String mediaPath = getClass().getResource(canciones.get(cancionActual)).toExternalForm();
        Media media = new Media(mediaPath);
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
    }

    public void siguienteCancion() {
        cancionActual = (cancionActual + 1) % canciones.size();
        inicializarMediaPlayer();
        mediaPlayer.play();
    }

    public void anteriorCancion() {
        cancionActual = (cancionActual - 1 + canciones.size()) % canciones.size();
        inicializarMediaPlayer();
        mediaPlayer.play();
    }

    public void play() {
        mediaPlayer.play();
    }

    public void pause() {
        mediaPlayer.pause();
    }

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }
}