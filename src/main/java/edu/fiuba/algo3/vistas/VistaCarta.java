package edu.fiuba.algo3.vistas;

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

        // Configurar comportamiento
        cartaImagen.setOnMouseClicked(event -> {
            estaSeleccionada[0] = !estaSeleccionada[0];
            if (estaSeleccionada[0]) {
                cartaImagen.setScaleX(1.2);
                cartaImagen.setScaleY(1.2);
                contadorCartas[0]++;
                modelo.seleccionarCarta(this.carta);
            } else {
                cartaImagen.setScaleX(1.0);
                cartaImagen.setScaleY(1.0);
                contadorCartas[0]--;
                modelo.deseleccionarCarta(this.carta);
            }
            actualizarBotones.run();
        });

        cartaImagen.setOnMouseEntered(event -> {
            if (!estaSeleccionada[0]) {
                cartaImagen.setScaleX(1.2);
                cartaImagen.setScaleY(1.2);
            }
        });

        cartaImagen.setOnMouseExited(event -> {
            if (!estaSeleccionada[0]) {
                cartaImagen.setScaleX(1.0);
                cartaImagen.setScaleY(1.0);
            }
        });

        // Añadir el componente al StackPane
        this.getChildren().add(cartaImagen);
    }
}
