package edu.fiuba.algo3.controllers.ControladoresTienda;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Joker.Joker;
import edu.fiuba.algo3.vistas.VistasTienda.VistaComodinTienda;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;

public class ControladorClickTiendaJoker implements EventHandler<MouseEvent> {
    private final ImageView cartaImagen;
    private final boolean[] estaSeleccionada;
    private final int[] contador;
    private final Joker joker;
    private final Balatro modelo;
    private final ControladorBotonAgregar controlador;
    private final Runnable actualizarBotones;
    private final VistaComodinTienda vistaComodin;
    private final AudioClip sonidoSeleccion;

    public ControladorClickTiendaJoker(ImageView cartaImagen, boolean[] estaSeleccionada, int[] contador, Joker joker, Balatro modelo, ControladorBotonAgregar controlador, Runnable actualizarBotones, VistaComodinTienda vistaComodin) {
        this.cartaImagen = cartaImagen;
        this.estaSeleccionada = estaSeleccionada;
        this.contador = contador;
        this.joker = joker;
        this.modelo = modelo;
        this.controlador = controlador;
        this.actualizarBotones = actualizarBotones;
        this.vistaComodin = vistaComodin;
        this.sonidoSeleccion = new AudioClip(getClass().getResource("/audio/click_carta.mp3").toExternalForm());
    }

    @Override
    public void handle(MouseEvent event) {
        if (!estaSeleccionada[0] && contador[0] == 0) {
            sonidoSeleccion.play();
            estaSeleccionada[0] = !estaSeleccionada[0];
            cartaImagen.setScaleX(1.2);
            cartaImagen.setScaleY(1.2);
            contador[0]++;
            controlador.agregarJoker(joker, vistaComodin, estaSeleccionada, contador);
            controlador.agregarVista(vistaComodin);

        } else if (estaSeleccionada[0]){
            sonidoSeleccion.play();
            estaSeleccionada[0] = !estaSeleccionada[0];
            cartaImagen.setScaleX(1.0);
            cartaImagen.setScaleY(1.0);
            contador[0]--;
            controlador.removerJoker();
        }
        actualizarBotones.run();
    }
}