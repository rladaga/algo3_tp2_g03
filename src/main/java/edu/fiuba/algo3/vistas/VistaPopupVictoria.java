package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controllers.ControladorCierreJuego;
import edu.fiuba.algo3.controllers.ControladorFinJuego;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;


public class VistaPopupVictoria {

    private Stage stage;
    private ReproductorMusica reproductorMusica;
    private String nombreJugador;

    public VistaPopupVictoria(Stage stage, ReproductorMusica reproductorMusica, String nombreJugador) {
        this.stage = stage;
        this.reproductorMusica = reproductorMusica;
        this.nombreJugador = nombreJugador;
    }

    public void mostrar(StackPane rootPrincipal) {
        StackPane overlay = new StackPane();
        overlay.setStyle("-fx-background-color: rgba(0, 0, 0, 0.5); -fx-border-radius: 15px;");
        overlay.setPrefSize(rootPrincipal.getWidth(), rootPrincipal.getHeight());

        VBox recuadroPopup = new VBox();
        recuadroPopup.setPadding(new Insets(20));
        recuadroPopup.setSpacing(15);
        recuadroPopup.setAlignment(Pos.CENTER);
        recuadroPopup.setStyle("-fx-background-color: linear-gradient(to right, #8B0000, #000080);");
        recuadroPopup.setMaxWidth(500);
        recuadroPopup.setMaxHeight(300);

        Label labelMensaje = new Label("Ganaste el juego, ¡felicitaciones!");
        labelMensaje.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-alignment: center; -fx-text-fill: white;");

        String estiloBoton = "-fx-background-color: #2C3E50; " +
                "-fx-text-fill: white; " +
                "-fx-font-size: 14px; " +
                "-fx-min-width: 100px; " +
                "-fx-min-height: 20px; " +
                "-fx-padding: 10px; " +
                "-fx-border-color: white; " +
                "-fx-border-width: 2px; " +
                "-fx-border-radius: 5px; " +
                "-fx-background-radius: 5px;";

        Button botonContinuar = new CrearBoton("Volver al menu principal", estiloBoton);
        botonContinuar.setOnAction(new ControladorFinJuego(stage, reproductorMusica, nombreJugador));

        Button botonCerrar = new CrearBoton("Cerrar juego", estiloBoton);
        botonCerrar.setOnAction(new ControladorCierreJuego());

        recuadroPopup.getChildren().addAll(labelMensaje, botonContinuar, botonCerrar);

        overlay.getChildren().add(recuadroPopup);
        StackPane.setAlignment(recuadroPopup, Pos.CENTER);

        rootPrincipal.getChildren().add(overlay);
    }
}
