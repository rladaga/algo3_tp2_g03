package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Carta.Carta;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.util.ArrayList;

public class VistaPartida extends BorderPane {

    public VistaPartida(Stage stagePrimario, ArrayList<Carta> cartas, MediaPlayer mediaPlayer) {

        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: #356C54");

        MenuBar menuBar = new BarraDeMenu(stagePrimario, mediaPlayer);

        VBox cajaGris = new VistaInformacion();

        VBox cajaInterna2 = new CajaInterna("#9D6400", "PUNTAJE \nNECESARIO", 147, 120);
        VBox cajaInterna3 = new CajaInterna("#242B2C", "PUNTOS DE\nLA RONDA", 150, 120);
        VBox cajaInterna4 = new CajaInterna("#242B2C", "PUNTUACION TIRADA", 136, 120);
        VBox cajaInterna5 = new CajaInterna("#242B2C", "", 124, 120);

        HBox fichaPuntajeCaja = new CajaPuntaje("10750", "#dc3545");
        cajaInterna2.getChildren().add(fichaPuntajeCaja);
        VBox.setMargin(fichaPuntajeCaja, new Insets(20, 0, 0, 0));

        HBox fichaPuntajeCaja2 = new CajaPuntaje("0", "white");
        cajaInterna3.getChildren().add(fichaPuntajeCaja2);
        VBox.setMargin(fichaPuntajeCaja2, new Insets(20, 0, 0, 0));

        HBox puntuacionTiradaCaja = new CajaGenerica(10, Pos.BOTTOM_CENTER);
        HBox cajaPuntos = new CajaPuntuacionManoInterna(Pos.BOTTOM_RIGHT, "#007bff", 100, 50, "0", new Insets(0, 5, 0, 0));
        Label xLabel = new Label("X");
        xLabel.setStyle("-fx-font-size: 24px; -fx-text-fill: #dc3545; -fx-font-weight: bold;");
        HBox cajaMultiplicador = new CajaPuntuacionManoInterna(Pos.BOTTOM_LEFT, "#dc3545", 100, 50, "0", new Insets(0, 0, 0, 5));

        puntuacionTiradaCaja.getChildren().addAll(cajaPuntos, xLabel, cajaMultiplicador);
        VBox.setMargin(puntuacionTiradaCaja, new Insets(45, 0, 0, 0));
        cajaInterna4.getChildren().add(puntuacionTiradaCaja);

        HBox cajaGeneralInfo = new CajaGenerica(10, Pos.BOTTOM_CENTER);

        VBox manoCaja = new CajaInfoInterna("MANO", 3, "#007bff");
        VBox rondaCaja = new CajaInfoInterna("RONDA", 1, "#FBA000");
        VBox descartesCaja = new CajaInfoInterna("DESCARTES", 4, "#dc3545");

        cajaGeneralInfo.getChildren().addAll(manoCaja, rondaCaja, descartesCaja);
        cajaInterna5.getChildren().add(cajaGeneralInfo);

        cajaGris.getChildren().addAll(cajaInterna2, cajaInterna3, cajaInterna4, cajaInterna5);

        AnchorPane anchor = new VistaPrincipalMesa(cartas);

        StackPane.setMargin(cajaGris, new Insets(0, 0, 0, 20));
        StackPane.setAlignment(cajaGris, Pos.CENTER_LEFT);

        root.getChildren().addAll(cajaGris, anchor);

        this.setTop(menuBar);
        this.setCenter(root);
    }

}
