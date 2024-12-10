package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Joker.Joker;
import edu.fiuba.algo3.modelo.Tarot.Tarot;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ControladorClickTiendaJoker implements EventHandler<MouseEvent> {
    private final ImageView cartaImagen;
    private final boolean[] estaSeleccionada;
    private final int[] contador;
    private final Joker joker;
    private final Balatro modelo;
    private final ControladorAgregarTienda controlador;

    public ControladorClickTiendaJoker(ImageView cartaImagen, boolean[] estaSeleccionada, int[] contador, Joker joker, Balatro modelo, ControladorAgregarTienda controlador) {
        this.cartaImagen = cartaImagen;
        this.estaSeleccionada = estaSeleccionada;
        this.contador = contador;
        this.joker = joker;
        this.modelo = modelo;
        this.controlador = controlador;
    }

    @Override
    public void handle(MouseEvent event) {
        if (!estaSeleccionada[0] && contador[0] == 0) {
            estaSeleccionada[0] = !estaSeleccionada[0];
            cartaImagen.setScaleX(1.2);
            cartaImagen.setScaleY(1.2);
            contador[0]++;
            controlador.agregarJoker(joker);
        } else if (estaSeleccionada[0]){
            estaSeleccionada[0] = !estaSeleccionada[0];
            cartaImagen.setScaleX(1.0);
            cartaImagen.setScaleY(1.0);
            contador[0]--;
            controlador.removerJoker();
        }
    }
}