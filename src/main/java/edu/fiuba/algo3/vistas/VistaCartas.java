package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Carta.Carta;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class VistaCartas extends HBox {
    public VistaCartas(ArrayList<Carta> cartas, Button botonJugarMano, Button botonDescartar) {

        this.setSpacing(10);
        this.setPrefHeight(150);
        this.setPadding(new Insets(20, 20, 20, 20));
        this.setAlignment(Pos.CENTER);
        this.setPrefWidth(800);
        this.setMinWidth(800);

        final int[] contadorCartas = {0};

        for (Carta carta : cartas) {
            ImageView cartaImagen = new ImageView(new Image(getClass().getResourceAsStream("/imagenes/cartas/" + carta.getImagen())));
            cartaImagen.setFitHeight(120);
            cartaImagen.setFitWidth(90);
            cartaImagen.setPreserveRatio(true);

            final boolean[] estaSeleccionada = {false};


            cartaImagen.setOnMouseClicked(event -> {
                estaSeleccionada[0] = !estaSeleccionada[0];
                if (estaSeleccionada[0]) {
                    cartaImagen.setScaleX(1.2);
                    cartaImagen.setScaleY(1.2);
                    contadorCartas[0]++;
                } else {
                    cartaImagen.setScaleX(1.0);
                    cartaImagen.setScaleY(1.0);
                    contadorCartas[0]--;
                }

                botonJugarMano.setDisable(contadorCartas[0] != 5);
                botonDescartar.setDisable(contadorCartas[0] < 1 || contadorCartas[0] > 5);
            });


            cartaImagen.setOnMouseEntered(event -> {
                if (!estaSeleccionada[0]) {
                    cartaImagen.setScaleX(1.2);
                    cartaImagen.setScaleY(1.2);
                }
            });
            cartaImagen.setOnMouseExited(event -> {
                if (!estaSeleccionada[0]) {
                    cartaImagen.setScaleX(1.0);
                    cartaImagen.setScaleY(1.0);
                }
            });

            this.getChildren().add(cartaImagen);
        }

    }
}
