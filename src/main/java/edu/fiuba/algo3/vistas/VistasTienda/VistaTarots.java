package edu.fiuba.algo3.vistas.VistasTienda;

import edu.fiuba.algo3.controllers.ControladoresTienda.ControladorBotonUsar;
import edu.fiuba.algo3.modelo.Balatro;
import edu.fiuba.algo3.modelo.Tarot.Tarot;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class VistaTarots extends HBox {
    private Balatro modelo;
    private ArrayList<Tarot> tarots;
    public VistaTarots(Balatro modelo, ArrayList<Tarot> tarots, int[] contador, VistaTienda vistaTienda, ControladorBotonUsar controladorBotonUsar, Runnable actualizarBotonUsar, BoxCartaSeleccionTarot vistaCartas) {
        this.modelo = modelo;
        this.tarots = tarots;

        this.setStyle("-fx-background-color: rgba(111,115,107,0.6); -fx-background-radius: 15px");
        this.setPrefHeight(150);
        this.setPadding(new Insets(20, 20, 20, 20));
        this.setAlignment(Pos.CENTER);
        this.setPrefWidth(550);
        this.setMinWidth(550);
        this.setSpacing(100);

        for (Tarot tarot : tarots) {
            VistaTarot vistaTarot = new VistaTarot(modelo, tarot, contador, vistaTienda, controladorBotonUsar, actualizarBotonUsar, vistaCartas);
            this.getChildren().add(vistaTarot);
        }
    }
}
