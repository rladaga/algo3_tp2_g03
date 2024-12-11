package edu.fiuba.algo3.vistas.VistasTienda;

import edu.fiuba.algo3.controllers.ControladoresTienda.ControladorBotonUsar;
import edu.fiuba.algo3.controllers.ControladoresTienda.ControladorClickTiendaTarot;
import edu.fiuba.algo3.modelo.Balatro;
import edu.fiuba.algo3.modelo.Tarot.Tarot;
import edu.fiuba.algo3.modelo.Tarot.TarotCarta;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class VistaTarot extends StackPane {

    private Balatro modelo;
    private Tarot tarot;
    private final boolean[] estaSeleccionada = {false};
    BoxCartaSeleccionTarot vistaCartas;
    VistaTienda vistaTienda;

    public VistaTarot(Balatro modelo, Tarot tarot, int[] contador, VistaTienda vistaTienda, ControladorBotonUsar controladorBotonUsar, Runnable actualizarBotonUsar, BoxCartaSeleccionTarot vistaCartas) {

        this.modelo = modelo;
        this.tarot = tarot;


        ImageView tarotImagen = new ImageView(new Image(getClass().getResourceAsStream("/imagenes/Tarots/" + (tarot.getClass().equals(TarotCarta.class) ? "tarot_emperador.png" : "tarot_mago.png"))));
        tarotImagen.setFitHeight(120);
        tarotImagen.setFitWidth(90);
        tarotImagen.setPreserveRatio(true);

        Tooltip tooltip = new Tooltip("Nombre: " + tarot.getNombre() + "\n\nDescripcion: " + tarot.getDescripcion());
        tooltip.setStyle("-fx-font-size: 15px; " +
                "-fx-padding: 20px;");
        Tooltip.install(tarotImagen, tooltip);

        this.vistaTienda = vistaTienda;
        this.vistaCartas = vistaCartas;

        tarotImagen.setOnMouseClicked(new ControladorClickTiendaTarot(
                tarotImagen,
                estaSeleccionada,
                contador,
                this.tarot,
                modelo,
                vistaTienda,
                controladorBotonUsar,
                actualizarBotonUsar,
                vistaCartas,
                this
        ));


        this.getChildren().add(tarotImagen);
    }

    public void esconderCartas(){
        vistaTienda.getChildren().removeAll(vistaCartas);

    }
}
