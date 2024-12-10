package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Balatro;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class CajaPuntaje extends HBox {

    private Label puntajeLabel;
    private Balatro modelo;

    public CajaPuntaje(Balatro modelo, String colorTexto) {
        this.modelo = modelo;
        this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-background-color: #2E393B; -fx-background-radius: 5px;");
        this.setPadding(new Insets(20, 20, 20, 20));

        ImageView fichaImagen = new ImageView(new Image(getClass().getResourceAsStream("/imagenes/ficha.png")));
        fichaImagen.setFitHeight(29);
        fichaImagen.setFitWidth(29);
        fichaImagen.setPreserveRatio(true);
        fichaImagen.setSmooth(true);
        this.getChildren().add(fichaImagen);

        this.puntajeLabel = new Label(modelo.getRonda().getPuntajeObjetivo().toString());
        puntajeLabel.setStyle("-fx-text-fill:" + colorTexto + " ; -fx-font-size: 30px;");
        puntajeLabel.setPadding(new Insets(0, 5, 0, 5));
        this.getChildren().add(puntajeLabel);
    }

    public void actualizar() {
        puntajeLabel.setText(modelo.getRonda().getPuntajeObjetivo().toString());
    }
}
