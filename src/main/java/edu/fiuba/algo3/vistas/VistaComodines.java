package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Balatro;
import edu.fiuba.algo3.modelo.Joker.Joker;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class VistaComodines extends HBox {
    private Balatro modelo;
    private ArrayList<Joker> jokers;
    private ArrayList<VistaComodinMesa> vistaComodinMesas;
    public VistaComodines(Balatro modelo) {
        this.modelo = modelo;
        this.jokers = modelo.getJokers();
        this.vistaComodinMesas = new ArrayList<>();

        this.setStyle("-fx-background-color: rgba(111,115,107,0.6); -fx-background-radius: 15px");
        this.setPrefHeight(150);
        this.setPadding(new Insets(20, 20, 20, 20));
        this.setAlignment(Pos.CENTER);
        this.setPrefWidth(550);
        this.setMinWidth(550);
        this.setSpacing(10);

        for (Joker joker : jokers) {
            VistaComodinMesa vistaJoker = new VistaComodinMesa(modelo, joker);
            this.vistaComodinMesas.add(vistaJoker);
        }
        this.getChildren().addAll(vistaComodinMesas);
    }

    public void actualizar() {
        this.getChildren().clear();
        this.jokers = modelo.getJokers();
        for (Joker joker : jokers) {
            VistaComodinMesa vistaJoker = new VistaComodinMesa(modelo, joker);
            this.getChildren().add(vistaJoker);
        }
    }
}
