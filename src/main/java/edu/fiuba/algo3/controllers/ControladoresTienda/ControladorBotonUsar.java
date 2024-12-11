package edu.fiuba.algo3.controllers.ControladoresTienda;

import edu.fiuba.algo3.modelo.Balatro;
import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.ManoDePoker.ManoDePoker;
import edu.fiuba.algo3.modelo.Tarot.*;
import edu.fiuba.algo3.vistas.AvisosYAlertas.AvisoCartaTarot;
import edu.fiuba.algo3.vistas.AvisosYAlertas.AvisoManoDePokerTarot;
import edu.fiuba.algo3.vistas.VistasAuxiliares.VistaPartida;
import edu.fiuba.algo3.vistas.VistasTienda.VistaTarot;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.StackPane;

public class ControladorBotonUsar implements EventHandler<ActionEvent> {
    private Tarot tarot;
    private VistaPartida vistaPartida;
    private Balatro modelo;
    private StackPane vistaConsumible;
    private boolean[] estaSeleccionada;
    private int[] contador;
    private Runnable actualizarBoton;
    private Carta carta;
    private ManoDePoker manoDePoker;

    public ControladorBotonUsar(Balatro modelo, VistaPartida vistaPartida) {
        this.modelo = modelo;
        this.tarot = null;
        this.carta = null;
        this.vistaPartida = vistaPartida;
        this.actualizarBoton = actualizarBoton;
    }

    public void agregarTarot(Tarot tarot, StackPane vistaTarot, boolean[] estaSeleccionada, int[] contador){
        this.tarot = tarot;
        this.vistaConsumible = vistaTarot;
        this.estaSeleccionada = estaSeleccionada;
        this.contador = contador;
    }

    public void removerTarot(){
        this.tarot = null;
    }

    public void agregarCarta(Carta carta){
        this.carta = carta;
    }

    public boolean haySeleccion(){
        if(tarot != null){
        if((tarot.getClass().equals(TarotCarta.class) && carta != null) || tarot.getClass().equals(TarotManoPoker.class)){
            return true;
        }}
        return false;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (tarot.getClass().equals(TarotCarta.class)) {
            TarotCarta tarotCarta = (TarotCarta) tarot;
            tarotCarta.aplicarEfecto(carta);
            new AvisoCartaTarot(carta);
            carta = null;
            VistaTarot vista = (VistaTarot)vistaConsumible;
            vista.esconderCartas();
            vista.setVisible(false);
            tarot = null;

        } else{
            TarotManoPoker tarotManoPoker = (TarotManoPoker) tarot;
            modelo.aplicarMejoraManoDePoker(tarotManoPoker);
            new AvisoManoDePokerTarot(tarotManoPoker);
            vistaConsumible.setVisible(false);
            tarot = null;
        }
        contador[0]--;
        estaSeleccionada[0] = false;
        actualizarBoton.run();
    }

    public void agregarRunnable(Runnable actualizarBoton) {
        this.actualizarBoton = actualizarBoton;
    }

    public void removerCarta() {
        carta = null;
    }
}
