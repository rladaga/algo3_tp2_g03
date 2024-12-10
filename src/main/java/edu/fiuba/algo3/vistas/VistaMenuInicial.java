package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controllers.ControladorJugar;
import edu.fiuba.algo3.modelo.Balatro;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.util.Optional;

public class VistaMenuInicial extends BorderPane {

    private String nombreJugador;

    public VistaMenuInicial(Stage stagePrimario, ReproductorMusica reproductorMusica, Balatro modelo, String nombreJugadorExistente) {

        this.nombreJugador = nombreJugadorExistente;

        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: linear-gradient(to right, #8B0000, #000080);");

        MenuBar menuBar = new BarraDeMenu(stagePrimario, reproductorMusica);

        VBox menuInicial = new VBox(30);
        menuInicial.setAlignment(Pos.CENTER);

        ImageView logoImage = new ImageView(new Image(getClass().getResourceAsStream("/imagenes/logo_balatro.png")));
        logoImage.setFitWidth(600);
        logoImage.setPreserveRatio(true);

        VBox botonesMenu = new VBox(15);
        botonesMenu.setAlignment(Pos.CENTER);
        botonesMenu.setPadding(new Insets(20, 20, 20, 20));
        botonesMenu.setMinWidth(300);
        botonesMenu.setMinHeight(200);

        String estiloBoton = "-fx-background-color: #2C3E50; " +
                "-fx-text-fill: white; " +
                "-fx-font-size: 20px; " +
                "-fx-min-width: 200px; " +
                "-fx-padding: 10px; " +
                "-fx-border-color: white; " +
                "-fx-border-radius: 5px; " +
                "-fx-background-radius: 5px;";

        Button botonJugar = new CrearBoton("JUGAR", estiloBoton);

        botonesMenu.getChildren().add(botonJugar);
        menuInicial.getChildren().addAll(logoImage, botonesMenu);

        root.getChildren().addAll(menuInicial);

        if (nombreJugador != null && !nombreJugador.isEmpty()) {
            botonJugar.setOnAction(new ControladorJugar(stagePrimario, reproductorMusica, menuBar, nombreJugador, modelo));
            menuInicial.setVisible(true);
        } else {
            Dialog<String> dialog = new PromptNombre();
            Platform.runLater(() -> {
                Optional<String> result = dialog.showAndWait();
                result.ifPresent(nombre -> {
                    nombreJugador = nombre;
                    botonJugar.setOnAction(new ControladorJugar(stagePrimario, reproductorMusica, menuBar, nombreJugador, modelo));
                    menuInicial.setVisible(true);
                });
            });
        }

        this.setTop(menuBar);
        this.setCenter(root);
    }

}
