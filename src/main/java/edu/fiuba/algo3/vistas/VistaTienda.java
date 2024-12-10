package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controllers.*;
import edu.fiuba.algo3.modelo.Balatro;
import edu.fiuba.algo3.modelo.Tienda;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class VistaTienda extends AnchorPane {
    private Balatro modelo;
    private Tienda tienda;

    public VistaPartida vistaPartida;

    public VistaTienda(Balatro modelo, VistaPartida vistaPartida) {

        this.modelo = modelo;
        this.tienda = modelo.getRonda().getTienda();
        this.vistaPartida = vistaPartida;
        final int[] contador = {0};

        String estiloBotonJugar = "-fx-background-color: #007bff; " +
                "-fx-text-fill: white; " +
                "-fx-font-size: 20px; " +
                "-fx-min-width: 200px; " +
                "-fx-min-height: 50px; " +
                "-fx-padding: 10px; " +
                "-fx-background-radius: 5px; " +
                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.4), 5, 0, 3, 3);";

        ControladorAgregarTienda controladorAgregarTienda = new ControladorAgregarTienda(modelo ,vistaPartida);
        Button botonJugarMano = new CrearBoton("AGREGAR", estiloBotonJugar);
        botonJugarMano.setDisable(true);
        botonJugarMano.setOnAction(controladorAgregarTienda);

        Runnable actualizarBotones = () -> {
            botonJugarMano.setDisable(!controladorAgregarTienda.haySeleccion());
        };

        HBox areaComodines = new VistaComodinesTienda(modelo, tienda.getJokers(), contador, controladorAgregarTienda, actualizarBotones);
        AnchorPane.setTopAnchor(areaComodines, 200.0);
        AnchorPane.setLeftAnchor(areaComodines, 350.0);

        HBox areaTarots = new VistaTarots(modelo, tienda.getTarots(), contador);
        AnchorPane.setTopAnchor(areaTarots, 20.0);
        AnchorPane.setLeftAnchor(areaTarots, 350.0);

        HBox areaCartaTienda = new VistaCartasTienda(modelo, tienda.getCarta(), contador, controladorAgregarTienda, actualizarBotones);
        AnchorPane.setTopAnchor(areaCartaTienda, 20.0);
        AnchorPane.setLeftAnchor(areaCartaTienda, 950.0);

        HBox contenedorBotones = new CajaGenerica(20, Pos.CENTER);

        String estiloBotonDescartar = "-fx-background-color: #dc3545; " +
                "-fx-text-fill: white; " +
                "-fx-font-size: 20px; " +
                "-fx-min-width: 200px; " +
                "-fx-min-height: 50px; " +
                "-fx-padding: 10px; " +
                "-fx-background-radius: 5px; " +
                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.4), 5, 0, 3, 3);";


        Button botonContinuar = new CrearBoton("CONTINUAR", estiloBotonDescartar);
        botonContinuar.setOnAction(new ControladorContinuar(modelo, vistaPartida));

        contenedorBotones.getChildren().addAll(botonJugarMano, botonContinuar);
        AnchorPane.setBottomAnchor(contenedorBotones,  100.0);
        AnchorPane.setLeftAnchor(contenedorBotones, 520.0);

        botonJugarMano.setDisable(true);

        Image image = new Image(getClass().getResourceAsStream("/imagenes/image_4.png"));
        ImageView imageView = new ImageView(image);

        imageView.setFitHeight(165);
        imageView.setFitWidth(123.56);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);

        AnchorPane.setBottomAnchor(imageView, 100.0);
        AnchorPane.setRightAnchor(imageView, 40.0);

        this.getChildren().addAll(imageView, areaComodines, areaTarots, areaCartaTienda, contenedorBotones);
    }

    public void actualizar() {

    }
}
