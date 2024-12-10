package edu.fiuba.algo3.controllers.ControladoresTienda;


import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vistas.VistasTienda.VistaCartaAdquiribleTienda;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;

public class ControladorClickTiendaCarta implements EventHandler<MouseEvent> {
    private final ImageView cartaImagen;
    private final boolean[] estaSeleccionada;
    private final int[] contador;
    private final Carta carta;
    private final Balatro modelo;
    private final ControladorBotonAgregar controlador;
    private final Runnable actualizarBotones;
    private final VistaCartaAdquiribleTienda vistaCarta;
    private final AudioClip sonidoSeleccion;

    public ControladorClickTiendaCarta(ImageView cartaImagen, boolean[] estaSeleccionada, int[] contador, Carta carta, Balatro modelo, ControladorBotonAgregar controlador, Runnable actualizarBotones, VistaCartaAdquiribleTienda vistaCarta) {
        this.cartaImagen = cartaImagen;
        this.estaSeleccionada = estaSeleccionada;
        this.contador = contador;
        this.carta = carta;
        this.modelo = modelo;
        this.controlador = controlador;
        this.actualizarBotones = actualizarBotones;
        this.vistaCarta = vistaCarta;
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
            controlador.agregarCarta(carta, vistaCarta, estaSeleccionada, contador);
            controlador.agregarVista(vistaCarta);

        } else if (estaSeleccionada[0]){
            sonidoSeleccion.play();
            estaSeleccionada[0] = !estaSeleccionada[0];
            cartaImagen.setScaleX(1.0);
            cartaImagen.setScaleY(1.0);
            contador[0]--;
            controlador.removerCarta();
        }
        actualizarBotones.run();
    }
}