package edu.fiuba.algo3.vistas.VistaMesaJuego;

import edu.fiuba.algo3.controllers.ControladorDescartar;
import edu.fiuba.algo3.controllers.ControladorJugarMano;
import edu.fiuba.algo3.modelo.Balatro;
import edu.fiuba.algo3.vistas.Cajas.CajaGenerica;
import edu.fiuba.algo3.vistas.ElementosAuxiliares.CrearBoton;
import edu.fiuba.algo3.vistas.ElementosAuxiliares.ReproductorMusica;
import edu.fiuba.algo3.vistas.VistasAuxiliares.VistaPartida;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class VistaPrincipalMesa extends AnchorPane {

    private Balatro modelo;
    private VistaCartas vistaCartas;
    public VistaPartida vistaPartida;
    public VistaComodines vistaComodines;
    private Stage stage;
    private ReproductorMusica reproductor;
    private String nombreJugador;


    public VistaPrincipalMesa(Balatro modelo, VistaPartida vistaPartida, StackPane root, Stage stage, ReproductorMusica reproductor, String nombreJugador) {

        this.modelo = modelo;
        this.vistaPartida = vistaPartida;
        this.stage = stage;
        this.reproductor = reproductor;
        this.nombreJugador = nombreJugador;

        VistaComodines areaComodines = new VistaComodines(modelo);
        this.vistaComodines = areaComodines;
        AnchorPane.setTopAnchor(areaComodines, 20.0);
        AnchorPane.setLeftAnchor(areaComodines, 350.0);

        HBox contenedorBotones = new CajaGenerica(20, Pos.CENTER);

        String estiloBotonJugar = "-fx-background-color: #007bff; " +
                "-fx-text-fill: white; " +
                "-fx-font-size: 20px; " +
                "-fx-min-width: 200px; " +
                "-fx-min-height: 50px; " +
                "-fx-padding: 10px; " +
                "-fx-background-radius: 5px; " +
                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.4), 5, 0, 3, 3);";

        String estiloBotonDescartar = "-fx-background-color: #dc3545; " +
                "-fx-text-fill: white; " +
                "-fx-font-size: 20px; " +
                "-fx-min-width: 200px; " +
                "-fx-min-height: 50px; " +
                "-fx-padding: 10px; " +
                "-fx-background-radius: 5px; " +
                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.4), 5, 0, 3, 3);";

        Button botonJugarMano = new CrearBoton("JUGAR MANO", estiloBotonJugar);
        botonJugarMano.setDisable(true);
        botonJugarMano.setOnAction(new ControladorJugarMano(modelo, vistaPartida, root, stage, reproductor, nombreJugador));

        Button botonDescartar = new CrearBoton("DESCARTAR", estiloBotonDescartar);
        botonDescartar.setDisable(true);
        botonDescartar.setOnAction(new ControladorDescartar(modelo, vistaPartida));

        contenedorBotones.getChildren().addAll(botonJugarMano, botonDescartar);
        AnchorPane.setBottomAnchor(contenedorBotones,  100.0);
        AnchorPane.setLeftAnchor(contenedorBotones, 520.0);

        VistaCartas areaCartas = new VistaCartas(modelo, botonJugarMano, botonDescartar);
        AnchorPane.setBottomAnchor(areaCartas, 200.0);
        AnchorPane.setLeftAnchor(areaCartas, 350.0);
        this.vistaCartas = areaCartas;

        Image image = new Image(getClass().getResourceAsStream("/imagenes/image_4.png"));
        ImageView imageView = new ImageView(image);

        imageView.setFitHeight(165);
        imageView.setFitWidth(123.56);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);

        AnchorPane.setBottomAnchor(imageView, 100.0);
        AnchorPane.setRightAnchor(imageView, 40.0);

        this.getChildren().addAll(imageView, areaComodines, areaCartas, contenedorBotones);
    }

    public void actualizarMano() {
        if(modelo.getRonda().getDescartes().getDescartesRestantes() == 0){
            vistaCartas.repartirSinDescartes();
        }else {
            vistaCartas.repartir();
        }
    }

    public void actualizarJokers() {
        vistaComodines.actualizar();
    }

}
