package edu.fiuba.algo3.vistas.VistaMesaJuego;

import edu.fiuba.algo3.controllers.ControladorClickCarta;
import edu.fiuba.algo3.controllers.ControladorHoverCarta;
import edu.fiuba.algo3.modelo.Balatro;
import edu.fiuba.algo3.modelo.Carta.Carta;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class VistaCarta extends StackPane {

    private Balatro modelo;
    private Carta carta;
    private final boolean[] estaSeleccionada = {false};

    public VistaCarta(Balatro modelo, Carta carta, int[] contadorCartas, Runnable actualizarBotones) {

        this.modelo = modelo;
        this.carta = carta;

        ImageView cartaImagen = new ImageView(new Image(getClass().getResourceAsStream("/imagenes/cartas/" + this.carta.getImagen())));
        cartaImagen.setFitHeight(120);
        cartaImagen.setFitWidth(90);
        cartaImagen.setPreserveRatio(true);

        cartaImagen.setOnMouseClicked(new ControladorClickCarta(
                cartaImagen,
                estaSeleccionada,
                contadorCartas,
                this.carta,
                modelo,
                actualizarBotones
        ));

        cartaImagen.setOnMouseEntered(new ControladorHoverCarta(
                cartaImagen,
                estaSeleccionada,
                true
        ));


        cartaImagen.setOnMouseExited(new ControladorHoverCarta(
                cartaImagen,
                estaSeleccionada,
                false
        ));


        this.getChildren().add(cartaImagen);
    }
}
