package edu.fiuba.algo3.vistas;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class CajaPuntuacionManoInterna extends HBox {
    public CajaPuntuacionManoInterna(Pos posicion, String bgColor, double ancho, double alto, String label, Insets insets) {
        this.setAlignment(posicion);
        this.setStyle("-fx-background-color:" + bgColor + "; -fx-background-radius: 5px;");
        this.setPrefSize(ancho,alto);
        Label puntosLabel = new Label(label);
        puntosLabel.setStyle("-fx-text-fill: white; -fx-font-size: 24px");
        puntosLabel.setPadding(insets);

        this.getChildren().add(puntosLabel);
    }
}
