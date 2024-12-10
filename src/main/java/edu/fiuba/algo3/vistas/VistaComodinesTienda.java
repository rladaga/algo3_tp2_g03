package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controllers.ControladoresTienda.ControladorBotonAgregar;
import edu.fiuba.algo3.modelo.Balatro;
import edu.fiuba.algo3.modelo.Joker.Joker;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class VistaComodinesTienda extends HBox {
    private Balatro modelo;
    private ArrayList<Joker> jokers;
    public VistaComodinesTienda(Balatro modelo, ArrayList<Joker> jokers, int[] contador, ControladorBotonAgregar controladorAgregarTienda, Runnable actualizarBotones) {
        this.modelo = modelo;
        this.jokers = jokers;

        this.setStyle("-fx-background-color: rgba(111,115,107,0.6); -fx-background-radius: 15px");
        this.setPrefHeight(150);
        this.setPadding(new Insets(20, 20, 20, 20));
        this.setAlignment(Pos.CENTER);
        this.setPrefWidth(550);
        this.setMinWidth(550);
        this.setSpacing(100);

        for (Joker joker : jokers) {
            VistaComodinTienda vistaJoker = new VistaComodinTienda(modelo, joker, contador, controladorAgregarTienda, actualizarBotones);
            this.getChildren().add(vistaJoker);
        }
    }
}