package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controllers.ControladorAgregarTienda;
import edu.fiuba.algo3.controllers.ControladorClickTiendaJoker;
import edu.fiuba.algo3.controllers.ControladorHoverCarta;
import edu.fiuba.algo3.modelo.Balatro;
import edu.fiuba.algo3.modelo.Joker.Joker;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class VistaComodinMesa extends StackPane {

    private Balatro modelo;
    private Joker joker;
    private final boolean[] estaSeleccionada = {false};

    public VistaComodinMesa(Balatro modelo, Joker joker) {

        this.modelo = modelo;
        this.joker = joker;

        ImageView jokerImagen = new ImageView(new Image(getClass().getResourceAsStream(obtenerImagenJoker())));
        jokerImagen.setFitHeight(120);
        jokerImagen.setFitWidth(90);
        jokerImagen.setPreserveRatio(true);

        Tooltip tooltip = new Tooltip("Nombre: " + joker.getNombre() + "\n\nDescripcion: " + joker.getDescripcion());
        tooltip.setStyle("-fx-font-size: 15px; " +
                "-fx-padding: 20px;");
        Tooltip.install(jokerImagen, tooltip);


        jokerImagen.setOnMouseEntered(new ControladorHoverCarta(
                jokerImagen,
                estaSeleccionada,
                true
        ));

        jokerImagen.setOnMouseExited(new ControladorHoverCarta(
                jokerImagen,
                estaSeleccionada,
                false
        ));


        this.getChildren().add(jokerImagen);
    }

    public String obtenerImagenJoker(){
        String[] jokerImagenes = {
                "joker_rojo.png",
                "joker_azul.png",
                "joker_verde.png",
                "joker_morado.png",
                "joker_gris.png"
        };

        switch(this.joker.getTipo()){
            case "Normal":
                return "/imagenes/" + jokerImagenes[0];
            case "Descarte":
                return "/imagenes/" + jokerImagenes[1];
            case "Aleatorio":
                return "/imagenes/" + jokerImagenes[2];
            case "Mano":
                return "/imagenes/" + jokerImagenes[3];
            case "Combinado":
                return "/imagenes/" + jokerImagenes[4];
            default:
                return "";
        }
    }
}
