package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controllers.ControladorJugar;
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

    public VistaMenuInicial(Stage stagePrimario, MediaPlayer mediaPlayer) {

        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: linear-gradient(to right, #8B0000, #000080);");

        MenuBar menuBar = new BarraDeMenu(stagePrimario, mediaPlayer);

        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Bienvenido a Balatro");
        dialog.setHeaderText("Por favor, ingresa tu nombre:");


        ButtonType loginButtonType = new ButtonType("Guardar", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);


        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField username = new TextField();
        username.setPromptText("Nombre");
        grid.add(new Label("Nombre:"), 0, 0);
        grid.add(username, 1, 0);

        dialog.getDialogPane().setContent(grid);


        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == loginButtonType) {
                return username.getText();
            }
            return null;
        });

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
        botonJugar.setOnAction(new ControladorJugar(stagePrimario, mediaPlayer));

        botonesMenu.getChildren().add(botonJugar);
        menuInicial.getChildren().addAll(logoImage, botonesMenu);

        root.getChildren().addAll(menuInicial);


        this.setTop(menuBar);
        this.setCenter(root);


        Platform.runLater(() -> {
            Optional<String> result = dialog.showAndWait();
            result.ifPresent(nombre -> {

                System.out.println("Nombre del jugador: " + nombre);
                menuInicial.setVisible(true);
            });
        });
    }

}
