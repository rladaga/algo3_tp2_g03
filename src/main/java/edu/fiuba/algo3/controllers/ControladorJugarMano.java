package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.Balatro;
import edu.fiuba.algo3.vistas.ElementosAuxiliares.ReproductorMusica;
import edu.fiuba.algo3.vistas.VistasAuxiliares.VistaPartida;
import edu.fiuba.algo3.vistas.VistasAuxiliares.VistaPopupDerrota;
import edu.fiuba.algo3.vistas.VistasAuxiliares.VistaPopupVictoria;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ControladorJugarMano implements EventHandler<ActionEvent> {

    Balatro modelo;
    VistaPartida vistaPartida;
    StackPane root;
    private Stage stage;
    private ReproductorMusica reproductor;
    private String nombreJugador;

    public ControladorJugarMano(Balatro modelo, VistaPartida vistaPartida, StackPane root, Stage stage, ReproductorMusica reproductorMusica, String nombreJugador) {
        this.modelo = modelo;
        this.vistaPartida = vistaPartida;
        this.root = root;
        this.stage = stage;
        this.reproductor = reproductorMusica;
        this.nombreJugador = nombreJugador;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        modelo.jugarMano();
        vistaPartida.actualizarPuntajeActual();
        if (modelo.getRonda().getPuntajeActual() >= modelo.getRonda().getPuntajeObjetivo()) {
            if (modelo.ultimaRonda()){
                VistaPopupVictoria popupVictoria = new VistaPopupVictoria(stage, reproductor, nombreJugador);
                popupVictoria.mostrar(root);
            } else {
            vistaPartida.mostrarTienda();
            }
        } else {
            if (modelo.getRonda().getManos().getManosRestantes() == 0){
                vistaPartida.actualizarCajaManos(modelo.getRonda().getManos().getManosRestantes());
                VistaPopupDerrota popupDerrota = new VistaPopupDerrota(stage, reproductor, nombreJugador);
                popupDerrota.mostrar(root);
            } else {
                vistaPartida.actualizarCajaManos(modelo.getRonda().getManos().getManosRestantes());
                vistaPartida.actualizarCartasEnMano();
            }
        }
    }
}
