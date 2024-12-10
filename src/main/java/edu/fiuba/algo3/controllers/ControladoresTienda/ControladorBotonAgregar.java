package edu.fiuba.algo3.controllers.ControladoresTienda;

import edu.fiuba.algo3.modelo.Balatro;
import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.EspacioJokersLlenoExcepction;
import edu.fiuba.algo3.modelo.Joker.Joker;
import edu.fiuba.algo3.vistas.AvisosYAlertas.AlertaLimiteJoker;
import edu.fiuba.algo3.vistas.VistaPartida;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.StackPane;

public class ControladorBotonAgregar implements EventHandler<ActionEvent> {
    private Carta carta;
    private Joker joker;
    private VistaPartida vistaPartida;
    private Balatro modelo;
    private StackPane vistaConsumible;
    private boolean[] estaSeleccionada;
    private int[] contador;
    private Runnable actualizarBoton;

    public ControladorBotonAgregar(Balatro modelo, VistaPartida vistaPartida){
        this.modelo = modelo;
        this.carta = null;
        this.joker = null;
        this.vistaPartida = vistaPartida;
    }

    public void agregarCarta(Carta carta, StackPane vistaCarta, boolean[] estaSeleccionada, int[] contador){
        this.carta = carta;
        this.vistaConsumible = vistaCarta;
        this.estaSeleccionada = estaSeleccionada;
        this.contador = contador;
    }

    public void removerCarta(){
        this.carta = null;
    }

    public void agregarJoker(Joker joker, StackPane vistaComodin, boolean[] estaSeleccionada, int[] contador){
        this.joker = joker;
        this.vistaConsumible = vistaComodin;
        this.estaSeleccionada = estaSeleccionada;
        this.contador = contador;
    }

    public void removerJoker(){
        this.joker = null;
    }

    public void agregarVista(StackPane vistaConsumible) {this.vistaConsumible = vistaConsumible; }

    public boolean haySeleccion(){
        if(carta != null || joker != null){
            return true;
        }
        return false;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (carta != null) {
            modelo.agregarCarta(carta);
            carta = null;
            vistaConsumible.setVisible(false);
        } else if (joker != null) {
            try{
                modelo.agregarJoker(joker);
                vistaConsumible.setVisible(false);
            } catch(EspacioJokersLlenoExcepction ex){
                new AlertaLimiteJoker();
                vistaConsumible.autosize();
            }
            joker = null;
        }
        contador[0]--;
        estaSeleccionada[0] = false;
        actualizarBoton.run();
    }

    public void agregarRunnable(Runnable actualizarBoton) {
        this.actualizarBoton = actualizarBoton;
    }
}
