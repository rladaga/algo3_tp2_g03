package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Balatro;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.*;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class VistaPartida extends BorderPane {

    private CajaPuntajeActual cajaPuntajeActual;
    private CajaInfoInterna cajaManos;
    private CajaInfoInterna cajaDescartes;
    private VistaPrincipalMesa vistaPrincipalMesa;

    public VistaPartida(Stage stagePrimario, MediaPlayer mediaPlayer, MenuBar menuBar, String nombreJugador, Balatro modelo) {

        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: #356C54");

        VBox cajaGris = new VistaInformacion(nombreJugador);

        VBox cajaInterna2 = new CajaInterna("#9D6400", "PUNTAJE \nNECESARIO", 147, 120);
        VBox cajaInterna3 = new CajaInterna("#242B2C", "PUNTOS DE\nLA RONDA", 150, 120);
        VBox cajaInterna4 = new CajaInterna("#242B2C", "PUNTUACION TIRADA", 136, 120);
        VBox cajaInterna5 = new CajaInterna("#242B2C", "", 124, 120);

        HBox fichaPuntajeCaja = new CajaPuntaje(modelo, "#dc3545");
        cajaInterna2.getChildren().add(fichaPuntajeCaja);
        VBox.setMargin(fichaPuntajeCaja, new Insets(20, 0, 0, 0));

        CajaPuntajeActual fichaPuntajeCaja2 = new CajaPuntajeActual(modelo, "white");
        cajaInterna3.getChildren().add(fichaPuntajeCaja2);
        VBox.setMargin(fichaPuntajeCaja2, new Insets(20, 0, 0, 0));
        this.cajaPuntajeActual = fichaPuntajeCaja2;

        HBox puntuacionTiradaCaja = new CajaGenerica(10, Pos.BOTTOM_CENTER);
        HBox cajaPuntos = new CajaPuntuacionManoInterna(Pos.BOTTOM_RIGHT, "#007bff", 100, 50, "0", new Insets(0, 5, 0, 0));
        Label xLabel = new Label("X");
        xLabel.setStyle("-fx-font-size: 24px; -fx-text-fill: #dc3545; -fx-font-weight: bold;");
        HBox cajaMultiplicador = new CajaPuntuacionManoInterna(Pos.BOTTOM_LEFT, "#dc3545", 100, 50, "0", new Insets(0, 0, 0, 5));

        puntuacionTiradaCaja.getChildren().addAll(cajaPuntos, xLabel, cajaMultiplicador);
        VBox.setMargin(puntuacionTiradaCaja, new Insets(45, 0, 0, 0));
        cajaInterna4.getChildren().add(puntuacionTiradaCaja);

        HBox cajaGeneralInfo = new CajaGenerica(10, Pos.BOTTOM_CENTER);

        CajaInfoInterna manoCaja = new CajaInfoInterna("MANO", modelo.getRonda().getManos().getManosRestantes(), "#007bff");
        VBox rondaCaja = new CajaInfoInterna("RONDA", modelo.getRonda().getNumeroRonda(), "#FBA000");
        CajaInfoInterna descartesCaja = new CajaInfoInterna("DESCARTES", modelo.getRonda().getDescartes().getDescartesRestantes(), "#dc3545");
        this.cajaDescartes = descartesCaja;
        this.cajaManos = manoCaja;

        cajaGeneralInfo.getChildren().addAll((VBox)manoCaja, rondaCaja, (VBox)descartesCaja);
        cajaInterna5.getChildren().add(cajaGeneralInfo);

        cajaGris.getChildren().addAll(cajaInterna2, cajaInterna3, cajaInterna4, cajaInterna5);

        VistaPrincipalMesa anchor = new VistaPrincipalMesa(modelo, this);

        StackPane.setMargin(cajaGris, new Insets(0, 0, 0, 20));
        StackPane.setAlignment(cajaGris, Pos.CENTER_LEFT);

        root.getChildren().addAll(cajaGris, anchor);
        this.vistaPrincipalMesa = anchor;

        this.setTop(menuBar);
        this.setCenter(root);

        String fontFamily = "Balatro";
        String css = "-fx-font-family: '" + fontFamily + "';";

        this.setStyle(css);
    }

    public void actualizarPuntajeActual() {
        this.cajaPuntajeActual.actualizar();
    }

    public void actualizarCajaDescartes(int valor) {this.cajaDescartes.actualizar(valor);}

    public void actualizarCajaManos(int valor) {this.cajaManos.actualizar(valor);}

    public void actualizarCartasEnMano(){
        vistaPrincipalMesa.actualizarMano();
    }

}
