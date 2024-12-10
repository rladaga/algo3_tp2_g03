package edu.fiuba.algo3.vistas.VistasTienda;

import edu.fiuba.algo3.controllers.ControladoresTienda.ControladorBotonAgregar;
import edu.fiuba.algo3.controllers.ControladoresTienda.ControladorBotonUsar;
import edu.fiuba.algo3.controllers.ControladoresTienda.ControladorContinuar;
import edu.fiuba.algo3.modelo.Balatro;
import edu.fiuba.algo3.modelo.Tienda;
import edu.fiuba.algo3.vistas.Cajas.CajaGenerica;
import edu.fiuba.algo3.vistas.ElementosAuxiliares.CrearBoton;
import edu.fiuba.algo3.vistas.VistasAuxiliares.VistaPartida;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class VistaTienda extends AnchorPane {
    private Balatro modelo;
    private Tienda tienda;

    public VistaPartida vistaPartida;

    public VistaTienda(Balatro modelo, VistaPartida vistaPartida) {

        this.modelo = modelo;
        this.tienda = modelo.getRonda().getTienda();
        this.vistaPartida = vistaPartida;
        final int[] contador = {0};

        String estiloBotonAgregar = "-fx-background-color: #007bff; " +
                "-fx-text-fill: white; " +
                "-fx-font-size: 20px; " +
                "-fx-min-width: 200px; " +
                "-fx-min-height: 50px; " +
                "-fx-padding: 10px; " +
                "-fx-background-radius: 5px; " +
                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.4), 5, 0, 3, 3);";


        ControladorBotonAgregar controladorAgregarTienda = new ControladorBotonAgregar(modelo ,vistaPartida);
        Button botonAgregar = new CrearBoton("AGREGAR", estiloBotonAgregar);
        botonAgregar.setDisable(true);
        botonAgregar.setOnAction(controladorAgregarTienda);

        Runnable actualizarBotonAgregar= () -> {
            botonAgregar.setDisable(!controladorAgregarTienda.haySeleccion());
        };

        String estiloBotonUsar = "-fx-background-color: #007bff; " +
                "-fx-text-fill: white; " +
                "-fx-font-size: 20px; " +
                "-fx-min-width: 200px; " +
                "-fx-min-height: 50px; " +
                "-fx-padding: 10px; " +
                "-fx-background-radius: 5px; " +
                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.4), 5, 0, 3, 3);";

        ControladorBotonUsar controladorBotonUsar = new ControladorBotonUsar(modelo, vistaPartida);
        Button botonUsar = new CrearBoton("USAR", estiloBotonUsar);
        botonUsar.setDisable(true);
        botonUsar.setOnAction(controladorBotonUsar);

        final int[] contadorCartasTarotizable = {0};
        final int[] contadorTarots = {0};

        Runnable actualizarBotonUsar= () -> {
            botonUsar.setDisable(!controladorBotonUsar.haySeleccion());
        };

        controladorBotonUsar.agregarRunnable(actualizarBotonUsar);
        controladorAgregarTienda.agregarRunnable(actualizarBotonAgregar);

        HBox areaComodines = new VistaComodinesTienda(modelo, tienda.getJokers(), contador, controladorAgregarTienda, actualizarBotonAgregar);
        AnchorPane.setTopAnchor(areaComodines, 200.0);
        AnchorPane.setLeftAnchor(areaComodines, 350.0);

        BoxCartaSeleccionTarot areaCartasTarot = new BoxCartaSeleccionTarot(modelo, controladorBotonUsar, contadorCartasTarotizable, actualizarBotonUsar);
        AnchorPane.setBottomAnchor(areaCartasTarot, 200.0);
        AnchorPane.setLeftAnchor(areaCartasTarot, 350.0);

        HBox areaTarots = new VistaTarots(modelo, tienda.getTarots(), contadorTarots, this, controladorBotonUsar, actualizarBotonUsar, areaCartasTarot);
        AnchorPane.setTopAnchor(areaTarots, 20.0);
        AnchorPane.setLeftAnchor(areaTarots, 350.0);

        HBox areaCartaTienda = new BoxCartaAdquiribleTienda(modelo, tienda.getCarta(), contador, controladorAgregarTienda, actualizarBotonAgregar);
        AnchorPane.setTopAnchor(areaCartaTienda, 20.0);
        AnchorPane.setLeftAnchor(areaCartaTienda, 950.0);

        HBox contenedorBotones = new CajaGenerica(20, Pos.CENTER);
        HBox contenedorContinuar = new CajaGenerica(20, Pos.CENTER);

        String estiloBotonContinuar = "-fx-background-color: #dc3545; " +
                "-fx-text-fill: white; " +
                "-fx-font-size: 20px; " +
                "-fx-min-width: 200px; " +
                "-fx-min-height: 50px; " +
                "-fx-padding: 10px; " +
                "-fx-background-radius: 5px; " +
                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.4), 5, 0, 3, 3);";


        Button botonContinuar = new CrearBoton("CONTINUAR", estiloBotonContinuar);
        botonContinuar.setOnAction(new ControladorContinuar(modelo, vistaPartida));

        contenedorBotones.getChildren().addAll(botonAgregar, botonUsar);
        contenedorContinuar.getChildren().addAll(botonContinuar);
        AnchorPane.setBottomAnchor(contenedorBotones,  100.0);
        AnchorPane.setLeftAnchor(contenedorBotones, 520.0);
        AnchorPane.setBottomAnchor(contenedorContinuar,  30.0);
        AnchorPane.setLeftAnchor(contenedorContinuar, 1100.0);

        Image image = new Image(getClass().getResourceAsStream("/imagenes/image_4.png"));
        ImageView imageView = new ImageView(image);

        imageView.setFitHeight(165);
        imageView.setFitWidth(123.56);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);

        AnchorPane.setBottomAnchor(imageView, 100.0);
        AnchorPane.setRightAnchor(imageView, 40.0);

        this.getChildren().addAll(imageView, areaComodines, areaTarots, areaCartaTienda, contenedorBotones, contenedorContinuar);


    }


}
