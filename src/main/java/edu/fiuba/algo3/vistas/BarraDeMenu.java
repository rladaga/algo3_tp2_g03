package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controllers.ControladorApagarMusica;
import edu.fiuba.algo3.controllers.ControladorInformacionJuego;
import edu.fiuba.algo3.controllers.ControladorManosPoker;
import edu.fiuba.algo3.controllers.ControladorPantallaCompleta;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class BarraDeMenu extends MenuBar {

    private Stage stage;
    private MediaPlayer mediaPlayer;
    private Font customFont;

    public BarraDeMenu(Stage stage, MediaPlayer mediaPlayer) {
        this.stage = stage;
        this.mediaPlayer = mediaPlayer;

        inicializarMenu();

    }

    private void inicializarMenu() {
        Menu menuOpciones = new Menu("Opciones");

        MenuItem pantallaCompleta = new MenuItem("Pantalla completa");
        pantallaCompleta.setOnAction(new ControladorPantallaCompleta(stage));
        menuOpciones.getItems().addAll(pantallaCompleta);

        Menu menuMusica = new Menu("Musica");
        MenuItem itemApagar = new MenuItem("OFF");
        itemApagar.setOnAction(new ControladorApagarMusica(mediaPlayer, menuMusica));
        mediaPlayer.play();
        menuMusica.getItems().addAll(itemApagar);

        Menu menuAyuda = new Menu("Ayuda");
        MenuItem informacionJuego = new MenuItem("Informacion del juego");
        MenuItem manosPoker = new MenuItem("Manos de poker");

        informacionJuego.setOnAction(new ControladorInformacionJuego(stage));
        manosPoker.setOnAction(new ControladorManosPoker(stage));

        menuAyuda.getItems().addAll(informacionJuego,manosPoker);


        this.getMenus().addAll(menuOpciones, menuMusica, menuAyuda);

    }
}
