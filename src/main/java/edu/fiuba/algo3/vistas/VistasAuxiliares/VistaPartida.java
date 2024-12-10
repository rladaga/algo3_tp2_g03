package edu.fiuba.algo3.vistas.VistasAuxiliares;

import edu.fiuba.algo3.modelo.Balatro;
import edu.fiuba.algo3.vistas.AvisosYAlertas.AvisoRondaSuperada;
import edu.fiuba.algo3.vistas.Cajas.*;
import edu.fiuba.algo3.vistas.ElementosAuxiliares.ReproductorMusica;
import edu.fiuba.algo3.vistas.VistaMesaJuego.VistaPrincipalMesa;
import edu.fiuba.algo3.vistas.VistasTienda.VistaTienda;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class VistaPartida extends BorderPane {

    private CajaPuntajeActual cajaPuntajeActual;
    private CajaPuntaje cajaPuntaje;
    private CajaInfoInterna cajaManos;
    private CajaInfoInterna cajaDescartes;
    private CajaInfoInterna cajaRonda;
    private StackPane root;
    private VBox cajaGris;
    private VistaPrincipalMesa vistaPrincipalMesa;
    private VistaTienda vistaTienda;
    private Balatro modelo;

    public VistaPartida(Stage stagePrimario, ReproductorMusica reproductorMusica, MenuBar menuBar, String nombreJugador, Balatro modelo) {

        this.root = new StackPane();
        this.vistaTienda = new VistaTienda(modelo, this);
        this.modelo = modelo;

        root.setStyle("-fx-background-color: #356C54");

        VBox cajaVistaInfo = new VistaInformacion(nombreJugador);
        this.cajaGris = cajaVistaInfo;

        VBox cajaInterna2 = new CajaInterna("#9D6400", "PUNTAJE \nNECESARIO", 147, 120);
        VBox cajaInterna3 = new CajaInterna("#242B2C", "PUNTOS DE\nLA RONDA", 150, 120);
        VBox cajaInterna4 = new CajaInterna("#242B2C", "PUNTUACION TIRADA", 136, 120);
        VBox cajaInterna5 = new CajaInterna("#242B2C", "", 124, 120);

        CajaPuntaje fichaPuntajeCaja = new CajaPuntaje(modelo, "#dc3545");
        cajaInterna2.getChildren().add(fichaPuntajeCaja);
        VBox.setMargin(fichaPuntajeCaja, new Insets(20, 0, 0, 0));
        this.cajaPuntaje = fichaPuntajeCaja;

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
        CajaInfoInterna rondaCaja = new CajaInfoInterna("RONDA", modelo.getRonda().getNumeroRonda(), "#FBA000");
        CajaInfoInterna descartesCaja = new CajaInfoInterna("DESCARTES", modelo.getRonda().getDescartes().getDescartesRestantes(), "#dc3545");
        this.cajaDescartes = descartesCaja;
        this.cajaRonda = rondaCaja;
        this.cajaManos = manoCaja;

        cajaGeneralInfo.getChildren().addAll(manoCaja, rondaCaja, descartesCaja);
        cajaInterna5.getChildren().add(cajaGeneralInfo);

        cajaGris.getChildren().addAll(cajaInterna2, cajaInterna3, cajaInterna5);

        this.vistaPrincipalMesa = new VistaPrincipalMesa(modelo, this, root, stagePrimario, reproductorMusica, nombreJugador);

        StackPane.setMargin(cajaGris, new Insets(0, 0, 0, 20));
        StackPane.setAlignment(cajaGris, Pos.CENTER_LEFT);

        root.getChildren().addAll(cajaGris, vistaPrincipalMesa);

        this.setTop(menuBar);
        this.setCenter(root);

        String fontFamily = "Balatro";
        String css = "-fx-font-family: '" + fontFamily + "';";

        this.setStyle(css);
    }

    public void actualizarPuntajeActual() {
        this.cajaPuntajeActual.actualizar();
    }

    public void mostrarTienda() {
        new AvisoRondaSuperada();
        root.getChildren().remove(vistaPrincipalMesa);
        this.vistaTienda = new VistaTienda(modelo, this);
        root.getChildren().add(vistaTienda);
    }

    public void mostrarMesa() {
        root.getChildren().remove(vistaTienda);
        actualizar();
        vistaPrincipalMesa.actualizarMano();
        vistaPrincipalMesa.actualizarJokers();
        root.getChildren().add(vistaPrincipalMesa);
    }

    public void actualizar() {
        this.cajaPuntaje.actualizar();
        actualizarPuntajeActual();
        actualizarCajaManos(modelo.getRonda().getManos().getManosRestantes());
        actualizarCajaDescartes(modelo.getRonda().getDescartes().getDescartesRestantes());
        actualizarCajaRonda(modelo.getRonda().getNumeroRonda());
    }

    public void actualizarCajaDescartes(int valor) {this.cajaDescartes.actualizar(valor);}
    public void actualizarCajaRonda(int valor) {this.cajaRonda.actualizar(valor);}

    public void actualizarCajaManos(int valor) {this.cajaManos.actualizar(valor);}

    public void actualizarCartasEnMano(){
        vistaPrincipalMesa.actualizarMano();
    }

}
