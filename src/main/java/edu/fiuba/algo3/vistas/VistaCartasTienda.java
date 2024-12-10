package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controllers.ControladorAgregarTienda;
import edu.fiuba.algo3.modelo.Balatro;
import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.Tarot.Tarot;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class VistaCartasTienda extends HBox {
    private Balatro modelo;
    private Carta carta;
    public VistaCartasTienda(Balatro modelo, Carta carta, int[] contador, ControladorAgregarTienda controladorAgregarTienda, Runnable actualizarBotones) {
        this.modelo = modelo;
        this.carta = carta;

        this.setStyle("-fx-background-color: rgba(111,115,107,0.6); -fx-background-radius: 15px");
        this.setPrefHeight(330);
        this.setPadding(new Insets(20, 20, 20, 20));
        this.setAlignment(Pos.CENTER);
        this.setPrefWidth(150);
        this.setMinWidth(150);
        this.setSpacing(100);

        VistaCartaTienda vistaCarta = new VistaCartaTienda(modelo, carta, contador, controladorAgregarTienda, actualizarBotones);
        this.getChildren().add(vistaCarta);
    }
}
