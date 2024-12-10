package edu.fiuba.algo3.vistas.AvisosYAlertas;

import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.Tarot.TarotManoPoker;
import javafx.scene.control.Alert;

public class AvisoManoDePokerTarot {
    public AvisoManoDePokerTarot(TarotManoPoker tarot) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Encantamiento exitoso");
        alert.setHeaderText("Ha mejorado la mano " + tarot.manoAAplicar().getClass().getSimpleName());
        alert.setContentText("Puede continuar usando la tienda");
        alert.showAndWait();
    }
}
