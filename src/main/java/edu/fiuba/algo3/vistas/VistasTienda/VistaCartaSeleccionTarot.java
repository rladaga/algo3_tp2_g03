package edu.fiuba.algo3.vistas.VistasTienda;

import edu.fiuba.algo3.controllers.ControladoresTienda.ControladorBotonAgregar;
import edu.fiuba.algo3.controllers.ControladoresTienda.ControladorBotonUsar;
import edu.fiuba.algo3.controllers.ControladoresTienda.ControladorClickCartaTarot;
import edu.fiuba.algo3.controllers.ControladoresTienda.ControladorClickTiendaCarta;
import edu.fiuba.algo3.modelo.Balatro;
import edu.fiuba.algo3.modelo.Carta.Carta;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class VistaCartaSeleccionTarot extends StackPane {

    private Balatro modelo;
    private Carta carta;
    private final boolean[] estaSeleccionada = {false};

    public VistaCartaSeleccionTarot(Balatro modelo, Carta carta, int[] contadorCartaTarotizable, ControladorBotonUsar controladorBotonUsar, Runnable actualizarBotones) {

        this.modelo = modelo;
        this.carta = carta;


        ImageView cartaImagen = new ImageView(new Image(getClass().getResourceAsStream("/imagenes/cartas/" + this.carta.getImagen())));
        cartaImagen.setFitHeight(120);
        cartaImagen.setFitWidth(90);
        cartaImagen.setPreserveRatio(true);

        cartaImagen.setOnMouseClicked(new ControladorClickCartaTarot(
                cartaImagen,
                estaSeleccionada,
                contadorCartaTarotizable,
                this.carta,
                modelo,
                controladorBotonUsar,
                actualizarBotones,
                this
        ));


        this.getChildren().add(cartaImagen);
    }

    public void actualizarSeleccionado(){
        this.estaSeleccionada[0] = false;
    }

}
