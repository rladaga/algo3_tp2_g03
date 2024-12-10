package edu.fiuba.algo3.controllers;


import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Tarot.Tarot;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ControladorClickTiendaCarta implements EventHandler<MouseEvent> {
    private final ImageView cartaImagen;
    private final boolean[] estaSeleccionada;
    private final int[] contador;
    private final Carta carta;
    private final Balatro modelo;
    private final ControladorAgregarTienda controlador;
    private final Runnable actualizarBotones;

    public ControladorClickTiendaCarta(ImageView cartaImagen, boolean[] estaSeleccionada, int[] contador, Carta carta, Balatro modelo, ControladorAgregarTienda controlador, Runnable actualizarBotones) {
        this.cartaImagen = cartaImagen;
        this.estaSeleccionada = estaSeleccionada;
        this.contador = contador;
        this.carta = carta;
        this.modelo = modelo;
        this.controlador = controlador;
        this.actualizarBotones = actualizarBotones;
    }

    @Override
    public void handle(MouseEvent event) {
        if (!estaSeleccionada[0] && contador[0] == 0) {
            estaSeleccionada[0] = !estaSeleccionada[0];
            cartaImagen.setScaleX(1.2);
            cartaImagen.setScaleY(1.2);
            contador[0]++;
            controlador.agregarCarta(carta);

        } else if (estaSeleccionada[0]){
            estaSeleccionada[0] = !estaSeleccionada[0];
            cartaImagen.setScaleX(1.0);
            cartaImagen.setScaleY(1.0);
            contador[0]--;
            controlador.removerCarta();
        }
        actualizarBotones.run();
    }
}