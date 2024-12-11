package edu.fiuba.algo3.vistas.AvisosYAlertas;

import edu.fiuba.algo3.modelo.Carta.Carta;
import javafx.scene.control.Alert;

public class AvisoCartaTarot {
    public AvisoCartaTarot(Carta carta) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Encantamiento exitoso");
        alert.setHeaderText("Ha aplicado un tarot en la carta " + carta.getValor().getClass().getSimpleName() + " de " + carta.getPalo().getClass().getSimpleName());
        alert.setContentText("Puede continuar usando la tienda");
        alert.showAndWait();
    }
}

