package edu.fiuba.algo3.vistas.Cajas;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class CajaGenerica extends HBox {
    public CajaGenerica(int spacing, Pos posicion) {
        this.setSpacing(spacing);
        this.setAlignment(posicion);
    }
}
