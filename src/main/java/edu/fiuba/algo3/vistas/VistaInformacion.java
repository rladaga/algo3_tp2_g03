package edu.fiuba.algo3.vistas;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class VistaInformacion extends VBox {
    public VistaInformacion() {
        this.setStyle("-fx-background-color: #2E393B");
        this.setPrefWidth(256);
        this.setMaxWidth(256);
        this.setMinWidth(256);
        this.setPrefHeight(Double.MAX_VALUE);
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(20, 20, 20, 20));
        this.setSpacing(20);
        this.setFillWidth(true);
    }
}
