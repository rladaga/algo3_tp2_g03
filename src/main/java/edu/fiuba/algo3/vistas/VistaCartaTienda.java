package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controllers.ControladoresTienda.ControladorBotonAgregar;
import edu.fiuba.algo3.controllers.ControladoresTienda.ControladorClickTiendaCarta;
import edu.fiuba.algo3.modelo.Balatro;
import edu.fiuba.algo3.modelo.Carta.Carta;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class VistaCartaTienda extends StackPane {

    private Balatro modelo;
    private Carta carta;
    private final boolean[] estaSeleccionada = {false};

    public VistaCartaTienda(Balatro modelo, Carta carta, int[] contador, ControladorBotonAgregar controladorAgregarTienda, Runnable actualizarBotones) {

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
                actualizarBotones,
                this
        ));


        this.getChildren().add(cartaImagen);
    }

    public void actualizarSeleccionado(){
        this.estaSeleccionada[0] = false;
    }
}