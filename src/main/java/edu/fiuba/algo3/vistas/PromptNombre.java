package edu.fiuba.algo3.vistas;


import edu.fiuba.algo3.controllers.ControladorNombreJugador;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class PromptNombre extends Dialog<String> {

    public PromptNombre() {

        this.setTitle("Bienvenido a Balatro");
        this.setHeaderText("Por favor, ingresa tu nombre");
        this.setResizable(false);

        Button botonGuardar = new Button("Guardar");
        botonGuardar.setDisable(true);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField nombre_jugador = new TextField();
        nombre_jugador.setPromptText("Nombre");
        nombre_jugador.textProperty().addListener((observable, oldValue, newValue) -> {
            boolean esValido = newValue.length() >= 3 && newValue.length() <= 15;
            botonGuardar.setDisable(!esValido);
        });

        grid.add(new Label("Nombre:"), 0, 0);
        grid.add(nombre_jugador, 1, 0);
        grid.add(botonGuardar, 1, 1);

        this.getDialogPane().setContent(grid);

        botonGuardar.setOnAction(new ControladorNombreJugador(nombre_jugador, this));
    }
}
