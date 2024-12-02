package edu.fiuba.algo3.vistas;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class VistaTarots extends HBox {
    public VistaTarots() {

        this.setStyle("-fx-background-color: rgba(111,115,107,0.6); -fx-background-radius: 15px");
        this.setPrefHeight(150);
        this.setPadding(new Insets(20, 20, 20, 20));
        this.setAlignment(Pos.CENTER);
        this.setPrefWidth(230);
        this.setMinWidth(230);
        this.setSpacing(10);

        String[] imagenesTarot = {
                "tarot_mago.png",
                "tarot_emperador.png",
        };

        for (String imagePath : imagenesTarot) {
            ImageView tarot = new ImageView(new Image(getClass().getResourceAsStream("/imagenes/" + imagePath)));
            tarot.setFitHeight(120);
            tarot.setFitWidth(90);
            tarot.setPreserveRatio(true);
            this.getChildren().add(tarot);
        }
    }
}
