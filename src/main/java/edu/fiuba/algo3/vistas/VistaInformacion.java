package edu.fiuba.algo3.vistas;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class VistaInformacion extends VBox {

    public VistaInformacion(String nombre) {
        this.setStyle("-fx-background-color: #2E393B");
        this.setPrefWidth(256);
        this.setMaxWidth(256);
        this.setMinWidth(256);
        this.setPrefHeight(Double.MAX_VALUE);
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(20, 20, 20, 20));
        this.setSpacing(20);
        this.setFillWidth(true);
        Label nombreJugador = new Label("Jugador: " + nombre);
        nombreJugador.setStyle("-fx-font-weight: bold; -fx-text-fill: white; -fx-font-size: 12px");
        this.getChildren().add(nombreJugador);
    }

}
