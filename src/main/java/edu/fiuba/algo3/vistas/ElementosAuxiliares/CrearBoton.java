package edu.fiuba.algo3.vistas.ElementosAuxiliares;

import javafx.scene.control.Button;

public class CrearBoton extends Button {
    public CrearBoton(String texto, String estilo) {

        this.setText(texto);
        String estiloBase = "-fx-background-color: #2C3E50; " +
                "-fx-text-fill: white; " +
                "-fx-font-size: 20px; " +
                "-fx-min-width: 200px; " +
                "-fx-min-height: 50px; " +
                "-fx-padding: 10px; " +
                "-fx-border-color: white; " +
                "-fx-border-width: 2px; " +
                "-fx-border-radius: 5px; " +
                "-fx-background-radius: 5px;";


        String estiloHover = estiloBase + "-fx-background-color: #34495E;";

        String estiloInicial = (estilo == null || estilo.isEmpty()) ? estiloBase : estilo;
        this.setStyle(estiloInicial);

        String estiloHoverFinal = (estilo == null || estilo.isEmpty()) ? estiloHover : estilo + "-fx-opacity: 0.8;";
        this.setOnMouseEntered(e -> this.setStyle(estiloHoverFinal));
        this.setOnMouseExited(e -> this.setStyle(estiloInicial));

    }
}
