package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controllers.ControladorAgregarTienda;
import edu.fiuba.algo3.controllers.ControladorClickTiendaCarta;
import edu.fiuba.algo3.controllers.ControladorClickTiendaTarot;
import edu.fiuba.algo3.controllers.ControladorHoverCarta;
import edu.fiuba.algo3.modelo.Balatro;
import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.Tarot.Tarot;
import edu.fiuba.algo3.modelo.Tarot.TarotCarta;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class VistaCartaTienda extends StackPane {

    private Balatro modelo;
    private Carta carta;
    private final boolean[] estaSeleccionada = {false};

    public VistaCartaTienda(Balatro modelo, Carta carta, int[] contador, ControladorAgregarTienda controladorAgregarTienda, Runnable actualizarBotones) {

        this.modelo = modelo;
        this.carta = carta;


        ImageView cartaImagen = new ImageView(new Image(getClass().getResourceAsStream("/imagenes/cartas/" + this.carta.getImagen())));
        cartaImagen.setFitHeight(120);
        cartaImagen.setFitWidth(90);
        cartaImagen.setPreserveRatio(true);

        cartaImagen.setOnMouseClicked(new ControladorClickTiendaCarta(
                cartaImagen,
                estaSeleccionada,
                contador,
                this.carta,
                modelo,
                controladorAgregarTienda,
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