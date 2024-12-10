package edu.fiuba.algo3.vistas.AvisosYAlertas;

import javafx.scene.control.Alert;

public class AlertaLimiteJoker  {
    public AlertaLimiteJoker() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Limite de Jokers alcanzado");
        alert.setHeaderText("Has alcanzado el limite de 5 jokers usables en la partida");
        alert.setContentText("Para agregar más Jokers debera eliminar alguno de los existentes en el transcurso de la ronda");
        alert.showAndWait();
    }
}