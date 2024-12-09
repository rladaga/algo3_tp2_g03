package edu.fiuba.algo3.vistas;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaPopupDerrota {

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
        recuadroPopup.setMaxHeight(300);

        Label labelMensaje = new Label("Fin del juego, no has alcanzado el puntaje necesario");
        labelMensaje.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-alignment: center; -fx-text-fill: white;");

        Button botonContinuar = new Button("Reiniciar juego"); //TODO: Utilizar CrearBoton;
        Button botonCerrar = new Button("Cerrar juego"); //TODO: Utilizar CrearBoton;

        botonContinuar.setOnAction(event -> {
            System.out.println("Continuar...");
            rootPrincipal.getChildren().remove(overlay);
        }); //TODO: Controlador para estas acciones

        botonCerrar.setOnAction(event -> {
            System.out.println("Cerrar el juego...");
            System.exit(0);
        }); //TODO: Controlador para estas acciones, reutilizar el de Victoria

        recuadroPopup.getChildren().addAll(labelMensaje, botonContinuar, botonCerrar);

        overlay.getChildren().add(recuadroPopup);
        StackPane.setAlignment(recuadroPopup, Pos.CENTER);

        rootPrincipal.getChildren().add(overlay);
    }
}

//Hacer algo asi para invocarla en VistaPartida:
/*
VistaPopupDerrota popupDerrota = new VistaPopupDerrota();
        popupDerrota.mostrar(root);
*/
