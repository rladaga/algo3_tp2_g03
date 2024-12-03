package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.*;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ControladorClickCarta implements EventHandler<MouseEvent> {
    private final ImageView cartaImagen;
    private final boolean[] estaSeleccionada;
    private final int[] contadorCartas;
    private final Carta carta;
    private final Balatro modelo;
    private final Runnable actualizarBotones;

    public ControladorClickCarta(ImageView cartaImagen, boolean[] estaSeleccionada, int[] contadorCartas, Carta carta, Balatro modelo, Runnable actualizarBotones) {
        this.cartaImagen = cartaImagen;
        this.estaSeleccionada = estaSeleccionada;
        this.contadorCartas = contadorCartas;
        this.carta = carta;
        this.modelo = modelo;
        this.actualizarBotones = actualizarBotones;
    }

    @Override
    public void handle(MouseEvent event) {
        estaSeleccionada[0] = !estaSeleccionada[0];
        if (estaSeleccionada[0]) {
            cartaImagen.setScaleX(1.2);
            cartaImagen.setScaleY(1.2);
            contadorCartas[0]++;
            modelo.seleccionarCarta(carta);
        } else {
            cartaImagen.setScaleX(1.0);
            cartaImagen.setScaleY(1.0);
            contadorCartas[0]--;
            modelo.deseleccionarCarta(carta);
        }
        actualizarBotones.run();
    }
}

