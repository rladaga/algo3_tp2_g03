package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Balatro;
import edu.fiuba.algo3.modelo.parser.ParserBalatro;
import edu.fiuba.algo3.vistas.ElementosAuxiliares.ReproductorMusica;
import edu.fiuba.algo3.vistas.VistasAuxiliares.VistaMenuInicial;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;


import java.io.FileNotFoundException;

/**
 * JavaFX App
 */
public class App extends Application {

    private Stage stage;
    private ReproductorMusica reproductorMusica;
    private Font customFont;

    @Override
    public void start(Stage stagePrimario) throws FileNotFoundException {
        stage = stagePrimario;
        stagePrimario.setTitle("Balatro");
        stagePrimario.getIcons().add(new Image(getClass().getResourceAsStream("/imagenes/logo_balatro.png")));
        ParserBalatro parser = new ParserBalatro();
        Balatro modelo = parser.pasearBalatro();

        reproductorMusica = new ReproductorMusica();

        customFont = Font.loadFont(
                getClass().getResourceAsStream("/tipografia/balatro.ttf"),
                20
        );

        VistaMenuInicial menuVisual = new VistaMenuInicial(stagePrimario, reproductorMusica, modelo, null);
        Scene escenaMenu = new Scene(menuVisual, 1366, 768);

        String fontFamily = "Balatro";
        String css = "-fx-font-family: '" + fontFamily + "';";

        escenaMenu.getRoot().setStyle(css);

        stagePrimario.setScene(escenaMenu);
        stagePrimario.setResizable(false);
        stagePrimario.show();
    }

    public static void main(String[] args) {
        launch();
    }

}