package edu.fiuba.algo3.vistas;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class VistaComodines extends HBox {
    public VistaComodines() {

        this.setStyle("-fx-background-color: rgba(111,115,107,0.6); -fx-background-radius: 15px");
        this.setPrefHeight(150);
        this.setPadding(new Insets(20, 20, 20, 20));
        this.setAlignment(Pos.CENTER);
        this.setPrefWidth(550);
        this.setMinWidth(550);
        this.setSpacing(10);

        String[] jokerImagenes = {
                "joker_rojo.png",
                "joker_azul.png",
                "joker_verde.png",
                "joker_morado.png",
                "joker_gris.png"
        };

        for (String imagePath : jokerImagenes) {
            ImageView joker = new ImageView(new Image(getClass().getResourceAsStream("/imagenes/" + imagePath)));
            joker.setFitHeight(120);
            joker.setFitWidth(90);
            joker.setPreserveRatio(true);
            this.getChildren().add(joker);
        }
    }
}
