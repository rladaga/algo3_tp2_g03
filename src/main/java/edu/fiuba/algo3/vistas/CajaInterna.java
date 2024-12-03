package edu.fiuba.algo3.vistas;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class CajaInterna extends VBox {
    public CajaInterna(String color, String label, double height, double width) {

        this.setStyle("-fx-background-color: " + color + "; -fx-background-radius: 5;");

        Label label1 = new Label(label);
        label1.setStyle("-fx-text-fill: white; -fx-font-size: 15px; -fx-text-alignment: center;");
        label1.setAlignment(Pos.TOP_CENTER);

        this.getChildren().add(label1);

        this.setPrefWidth(width);
        this.setPrefHeight(height);
        this.setMinHeight(height);
        this.setMaxHeight(height);

        this.setAlignment(Pos.TOP_CENTER);

        this.setPadding(new Insets(10));
    }
}
