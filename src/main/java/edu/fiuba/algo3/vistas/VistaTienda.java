package edu.fiuba.algo3.vistas;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class VistaTienda {

    public static void mostrar(StackPane rootPrincipal) {

        StackPane overlay = new StackPane();
        overlay.setStyle("-fx-background-color: rgba(0, 0, 0, 0.5); -fx-border-radius: 15px;");
        overlay.setPrefSize(rootPrincipal.getWidth(), rootPrincipal.getHeight());

        VBox recuadroPopup = new VBox();
        recuadroPopup.setPadding(new Insets(20));
        recuadroPopup.setSpacing(15);
        recuadroPopup.setAlignment(Pos.CENTER);
        recuadroPopup.setStyle("-fx-background-color: linear-gradient(to right, #8B0000, #000080);");
        recuadroPopup.setMaxWidth(500);
        recuadroPopup.setMaxHeight(400);

        Label tituloTienda = new Label("¡Bienvenido a la Tienda!");
        tituloTienda.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-alignment: center; -fx-text-fill: white;");

        VBox cartasBox = new VBox(10);
        cartasBox.setAlignment(Pos.CENTER_LEFT);
        cartasBox.setPadding(new Insets(10));

        Label carta1 = new Label("Joker 1: Aumenta puntos x2");
        Label carta2 = new Label("Joker 2: Activa efectos aleatorios");
        Label tarot1 = new Label("Tarot 1: Modifica la puntuación de cartas");
        Label tarot2 = new Label("Tarot 2: Cambia el multiplicador");
        Label cartaNormal = new Label("Carta normal: +3 de ataque");

        //TODO: Armar esta seccion con VistaCartas y sacar los textos.

        carta1.setStyle("-fx-font-size: 14px;");
        carta2.setStyle("-fx-font-size: 14px;");
        tarot1.setStyle("-fx-font-size: 14px;");
        tarot2.setStyle("-fx-font-size: 14px;");
        cartaNormal.setStyle("-fx-font-size: 14px;");

        cartasBox.getChildren().addAll(carta1, carta2, tarot1, tarot2, cartaNormal);

        HBox botonesBox = new HBox(20);
        botonesBox.setAlignment(Pos.CENTER);

        Button botonSeleccionar = new Button("Seleccionar");
        Button botonSalir = new Button("Salir");

        botonSeleccionar.setOnAction(event -> {
            System.out.println("Carta seleccionada: (Lógica para seleccionar carta aquí)");
            rootPrincipal.getChildren().remove(overlay);
        });

        botonSalir.setOnAction(event -> {
            System.out.println("Salir de la tienda...");
            rootPrincipal.getChildren().remove(overlay);
        });

        botonesBox.getChildren().addAll(botonSeleccionar, botonSalir);

        recuadroPopup.getChildren().addAll(tituloTienda, cartasBox, botonesBox);


        overlay.getChildren().add(recuadroPopup);
        StackPane.setAlignment(recuadroPopup, Pos.CENTER);


        rootPrincipal.getChildren().add(overlay);
    }
}

/*
VistaTienda vista = new VistaTienda();
vista.mostrar(root);
 */

