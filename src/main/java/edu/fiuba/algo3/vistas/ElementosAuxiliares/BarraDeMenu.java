package edu.fiuba.algo3.vistas.ElementosAuxiliares;

import edu.fiuba.algo3.controllers.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class BarraDeMenu extends MenuBar {

    private Stage stage;
    private ReproductorMusica reproductorMusica;
    private Font customFont;

    public BarraDeMenu(Stage stage, ReproductorMusica reproductorMusica) {
        this.stage = stage;
        this.reproductorMusica = reproductorMusica;

        inicializarMenu();

    }

    private void inicializarMenu() {
        Menu menuOpciones = new Menu("Opciones");

        MenuItem pantallaCompleta = new MenuItem("Pantalla completa");
        pantallaCompleta.setOnAction(new ControladorPantallaCompleta(stage));
        menuOpciones.getItems().addAll(pantallaCompleta);

        Menu menuMusica = new Menu("Musica");
        MenuItem itemApagar = new MenuItem("OFF");
        MenuItem itemSiguiente = new MenuItem("Siguiente");
        MenuItem itemAnterior = new MenuItem("Anterior");
        itemApagar.setOnAction(new ControladorApagarMusica(reproductorMusica, menuMusica));
        itemSiguiente.setOnAction(e -> reproductorMusica.siguienteCancion());
        itemAnterior.setOnAction(e -> reproductorMusica.anteriorCancion());

        reproductorMusica.play();
        menuMusica.getItems().addAll(itemApagar, itemSiguiente, itemAnterior);

        Menu menuAyuda = new Menu("Ayuda");
        MenuItem informacionJuego = new MenuItem("Informacion del juego");
        MenuItem manosPoker = new MenuItem("Manos de poker");

        informacionJuego.setOnAction(new ControladorInformacionJuego(stage));
        manosPoker.setOnAction(new ControladorManosPoker(stage));

        menuAyuda.getItems().addAll(informacionJuego,manosPoker);


        this.getMenus().addAll(menuOpciones, menuMusica, menuAyuda);

    }
}
