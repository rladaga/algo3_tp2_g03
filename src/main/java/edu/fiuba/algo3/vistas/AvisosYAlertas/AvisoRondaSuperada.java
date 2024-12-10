package edu.fiuba.algo3.vistas.AvisosYAlertas;

import edu.fiuba.algo3.modelo.Tarot.TarotManoPoker;
import javafx.scene.control.Alert;

public class AvisoRondaSuperada {

    public AvisoRondaSuperada() {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("");
    alert.setHeaderText("Has superado la ronda con exito!");
    alert.setContentText("Has desbloqueado la tienda, mejora tus cartas y continua la partida!");
    alert.showAndWait();
    }
}
