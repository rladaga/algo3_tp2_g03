package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Balatro;
import edu.fiuba.algo3.modelo.Carta.Carta;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class VistaCartas extends HBox {

    private Balatro modelo;
    private Button botonJugarMano;
    private Button botonDescartar;
    public VistaCartas(Balatro modelo, Button botonJugarMano, Button botonDescartar) {

        this.modelo = modelo;
        this.botonJugarMano = botonJugarMano;
        this.botonDescartar = botonDescartar;

        this.setSpacing(10);
        this.setPrefHeight(150);
        this.setPadding(new Insets(20, 20, 20, 20));
        this.setAlignment(Pos.CENTER);
        this.setPrefWidth(800);
        this.setMinWidth(800);

        repartir();
    }

    public void repartir() {
        modelo.repartirCartas(); // Actualiza el modelo para repartir nuevas cartas

        this.getChildren().clear(); // Elimina todas las cartas actuales del HBox

        final int[] contadorCartas = {0};

        // Crear un Runnable para actualizar los botones
        Runnable actualizarBotones = () -> {
            botonJugarMano.setDisable(contadorCartas[0] != 5);
            botonDescartar.setDisable(contadorCartas[0] < 1 || contadorCartas[0] > 5);
        };

        // Añade las nuevas cartas a la vista
        for (Carta carta : modelo.getCartasEnMano()) {
            VistaCarta vistaCarta = new VistaCarta(modelo, carta, contadorCartas, actualizarBotones);
            this.getChildren().add(vistaCarta);
        }
    }
}
