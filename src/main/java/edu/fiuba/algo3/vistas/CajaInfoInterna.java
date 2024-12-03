package edu.fiuba.algo3.vistas;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class CajaInfoInterna extends VBox {
    private Label valorLabel;
    public CajaInfoInterna(String label, int valor, String textColor) {
        this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-background-color: #404749; -fx-background-radius: 5px;");
        this.setPrefSize(80,120);
        this.setSpacing(10);
        Label cajaLabel = new Label(label);
        cajaLabel.setStyle("-fx-font-size: 10px; -fx-spacing: 10px; -fx-text-fill: white");
        this.getChildren().add(cajaLabel);
        Label valorLabel = new Label(String.valueOf(valor));
        this.valorLabel = valorLabel;
        valorLabel.setStyle("-fx-font-size: 30px; -fx-text-fill:" + textColor + ";");
        VBox valorBox = new VBox(valorLabel);
        valorBox.setAlignment(Pos.CENTER);
        this.getChildren().add(valorBox);
    }

    public void actualizar(int valor){
        valorLabel.setText(String.valueOf(valor));
    }
}
