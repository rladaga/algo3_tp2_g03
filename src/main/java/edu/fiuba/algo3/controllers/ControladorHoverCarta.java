package edu.fiuba.algo3.controllers;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ControladorHoverCarta implements EventHandler<MouseEvent> {
    private final ImageView cartaImagen;
    private final boolean[] estaSeleccionada;
    private final boolean esEntrada; // true para onMouseEntered, false para onMouseExited

    public ControladorHoverCarta(ImageView cartaImagen, boolean[] estaSeleccionada, boolean esEntrada) {
        this.cartaImagen = cartaImagen;
        this.estaSeleccionada = estaSeleccionada;
        this.esEntrada = esEntrada;
    }

    @Override
    public void handle(MouseEvent event) {
        if (!estaSeleccionada[0]) {
            double escala = esEntrada ? 1.2 : 1.0;
            cartaImagen.setScaleX(escala);
            cartaImagen.setScaleY(escala);
        }
    }
}
