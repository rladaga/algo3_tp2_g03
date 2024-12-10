package edu.fiuba.algo3.controllers.ControladoresTienda;

import edu.fiuba.algo3.modelo.Balatro;
import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.vistas.VistasTienda.VistaCartaAdquiribleTienda;
import edu.fiuba.algo3.vistas.VistasTienda.VistaCartaSeleccionTarot;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;

public class ControladorClickCartaTarot implements EventHandler<MouseEvent> {
        private final ImageView cartaImagen;
        private final boolean[] estaSeleccionada;
        private final int[] contador;
        private final Carta carta;
        private final Balatro modelo;
        private final ControladorBotonUsar controlador;
        private final Runnable actualizarBotones;
        private final VistaCartaSeleccionTarot vistaCarta;
        private final AudioClip sonidoSeleccion;

        public ControladorClickCartaTarot(ImageView cartaImagen, boolean[] estaSeleccionada, int[] contador, Carta carta, Balatro modelo, ControladorBotonUsar controlador, Runnable actualizarBotones, VistaCartaSeleccionTarot vistaCarta) {
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
                controlador.agregarCarta(carta);
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


