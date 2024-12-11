package edu.fiuba.algo3.vistas.VistasTienda;

import edu.fiuba.algo3.controllers.ControladoresTienda.ControladorBotonUsar;
import edu.fiuba.algo3.modelo.Balatro;
import edu.fiuba.algo3.modelo.Carta.Carta;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class BoxCartaSeleccionTarot extends HBox {

        private Balatro modelo;
        private Button botonUsar;
        final int[] contadorCartas;

        public BoxCartaSeleccionTarot(Balatro modelo, ControladorBotonUsar controlador, int[] contadorCartas, Runnable actualizarBoton) {
            this.contadorCartas = contadorCartas;
            this.modelo = modelo;

            this.setSpacing(10);
            this.setPrefHeight(150);
            this.setPadding(new Insets(20, 20, 20, 20));
            this.setAlignment(Pos.CENTER);
            this.setPrefWidth(800);
            this.setMinWidth(800);

            modelo.reinicarMazo();

            modelo.repartirCartas();

            this.getChildren().clear();


            for (Carta carta : modelo.getCartasEnMano()) {
                VistaCartaSeleccionTarot vistaCarta = new VistaCartaSeleccionTarot(modelo, carta, contadorCartas, controlador, actualizarBoton);
                this.getChildren().add(vistaCarta);
            }

        }
}
