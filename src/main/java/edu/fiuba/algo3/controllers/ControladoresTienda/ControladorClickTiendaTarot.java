package edu.fiuba.algo3.controllers.ControladoresTienda;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Tarot.Tarot;
import edu.fiuba.algo3.modelo.Tarot.TarotCarta;
import edu.fiuba.algo3.vistas.VistasTienda.VistaTarot;
import edu.fiuba.algo3.vistas.VistasTienda.VistaTienda;
import edu.fiuba.algo3.vistas.VistasTienda.BoxCartaSeleccionTarot;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;

public class ControladorClickTiendaTarot implements EventHandler<MouseEvent> {
        private final ImageView cartaImagen;
        private final boolean[] estaSeleccionada;
        private final int[] contador;
        private final Tarot tarot;
        private final Balatro modelo;
        private final VistaTienda vistaTienda;
        private final BoxCartaSeleccionTarot vistaCartas;
        private final VistaTarot vistaTarot;
        private final ControladorBotonUsar controlador;
        private final Runnable actualizarBotonUsar;
        private final AudioClip sonidoSeleccion;

        public ControladorClickTiendaTarot(ImageView cartaImagen, boolean[] estaSeleccionada, int[] contador, Tarot tarot, Balatro modelo, VistaTienda vistaTienda, ControladorBotonUsar controladorBotonUsar, Runnable actualizarBotonUsar, BoxCartaSeleccionTarot vistaCartas, VistaTarot vistaTarot) {
            this.cartaImagen = cartaImagen;
            this.estaSeleccionada = estaSeleccionada;
            this.contador = contador;
            this.tarot = tarot;
            this.modelo = modelo;
            this.controlador = controladorBotonUsar;
            this.vistaTienda = vistaTienda;
            this.vistaCartas = vistaCartas;
            this.vistaTarot = vistaTarot;
            this.actualizarBotonUsar = actualizarBotonUsar;
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
                controlador.agregarTarot(tarot, vistaTarot, estaSeleccionada, contador);
                if(tarot.getClass().equals(TarotCarta.class)) {
                    vistaTienda.getChildren().addAll(vistaCartas);
                }

            } else if (estaSeleccionada[0]){
                sonidoSeleccion.play();
                estaSeleccionada[0] = !estaSeleccionada[0];
                cartaImagen.setScaleX(1.0);
                cartaImagen.setScaleY(1.0);
                contador[0]--;
                controlador.removerTarot();
                if(tarot.getClass().equals(TarotCarta.class)) {
                    vistaTienda.getChildren().removeAll(vistaCartas);
                }
            }
            actualizarBotonUsar.run();

        }
    }

