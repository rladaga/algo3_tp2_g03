package edu.fiuba.algo3.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControladorInformacionJuego implements EventHandler<ActionEvent> {

    private Stage stagePrincipal;

    public ControladorInformacionJuego(Stage stagePrincipal) {
        this.stagePrincipal = stagePrincipal;
    }

    @Override
    public void handle(ActionEvent event) {
        Stage ventanaAyuda = new Stage();
        ventanaAyuda.getIcons().add(new Image(getClass().getResourceAsStream("/imagenes/logo_balatro.png")));
        ventanaAyuda.initModality(Modality.APPLICATION_MODAL);
        ventanaAyuda.initOwner(stagePrincipal);
        ventanaAyuda.setOnShowing(e -> stagePrincipal.setFullScreen(true));
        ventanaAyuda.setTitle("Información del Juego");
        ventanaAyuda.setResizable(false);

        Text texto = new Text(
                "¿CÓMO JUGAR?\n\n" +

                        "1. DESARROLLO DEL JUEGO\n" +
                        "   Cada ronda consta de dos etapas:\n\n" +
                        "   A. Fase de Preparación:\n" +
                        "   - Visita la tienda donde podrás elegir entre 4 cartas aleatorias\n" +
                        "   - Estas cartas pueden ser especiales (comodines o tarots) que te ayudarán durante la ronda\n\n" +
                        "   B. Fase de Juego:\n" +
                        "   - Se te asignará un objetivo de puntos a alcanzar\n" +
                        "   - Dispones de 5 turnos para lograrlo\n" +
                        "   - En cada turno:\n" +
                        "      • Recibirás 8 cartas aleatorias\n" +
                        "      • Puedes realizar las siguientes acciones:\n" +
                        "         - Formar una mano de poker\n" +
                        "         - Usar cartas de tarot para modificar valores\n" +
                        "         - Descartar cartas (hasta 3 veces por turno)\n" +
                        "      • Al jugar tu mano:\n" +
                        "         - Se aplican los efectos de los comodines en orden\n" +
                        "         - Se calcula el puntaje final\n" +
                        "         - Avanzas al siguiente turno\n\n" +
                        "2. FIN DEL JUEGO\n" +
                        "   La partida puede terminar de dos formas:\n" +
                        "   - ¡Victoria! Completas exitosamente las 8 rondas\n" +
                        "   - Derrota: No alcanzas los puntos necesarios en alguna ronda\n\n"
        );

        texto.setTextAlignment(TextAlignment.LEFT);
        texto.setFill(Color.WHITE);
        texto.setLineSpacing(2.5);

        StackPane stackPane = new StackPane();
        VBox contenedor = new VBox(20);
        contenedor.setAlignment(Pos.CENTER);
        contenedor.setStyle("-fx-background-color: #434242");
        contenedor.getChildren().add(texto);

        stackPane.getChildren().add(contenedor);
        stackPane.setAlignment(Pos.CENTER);

        String fontFamily = "Balatro";
        String css = "-fx-font-family: '" + fontFamily + "';";

        Scene scene = new Scene(stackPane, 600, 500);

        scene.getRoot().setStyle(css);

        ventanaAyuda.setScene(scene);
        ventanaAyuda.showAndWait();
    }
}