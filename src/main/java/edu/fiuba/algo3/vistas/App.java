package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.Mazo;
import edu.fiuba.algo3.modelo.Mezclador.IMezclador;
import edu.fiuba.algo3.modelo.Mezclador.MezcladorMazo;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Optional;

/**
 * JavaFX App
 */
public class App extends Application {

    private Scene scene1;
    private Scene scene2;
    private Stage stage;

    @Override
    public void start(Stage stagePrimario) {
        stage = stagePrimario;
        stage.setTitle("Balatro");

        scene1 = crearMenuInicial();
        scene2 = crearVisualPartida();

        stage.setScene(scene1);
        stage.setResizable(false);
        stage.show();
    }

    private MenuBar crearBarraDeMenus() {

        Menu menuOpciones = new Menu("Opciones");

        MenuItem pantallaCompleta = new MenuItem("Pantalla completa");
        pantallaCompleta.setOnAction(event -> {
            boolean isFullScreen = stage.isFullScreen();
            stage.setFullScreen(!isFullScreen);
        });


        MenuItem cambiarEscena = new MenuItem("Cambiar escena");
        cambiarEscena.setOnAction(event -> {
            if (stage.getScene() == scene1) {
                stage.setScene(scene2);
            } else {
                stage.setScene(scene1);
            }
        });

        // Agregar opciones al menú
        menuOpciones.getItems().addAll(pantallaCompleta, cambiarEscena);

        // Crear la barra de menús
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(menuOpciones);

        return menuBar;
    }

    private Scene crearMenuInicial(){
        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: linear-gradient(to right, #8B0000, #000080);");

        MenuBar menuBar = crearBarraDeMenus();

        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Bienvenido a Balatro");
        dialog.setHeaderText("Por favor, ingresa tu nombre:");


        ButtonType loginButtonType = new ButtonType("Guardar", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);


        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField username = new TextField();
        username.setPromptText("Nombre");
        grid.add(new Label("Nombre:"), 0, 0);
        grid.add(username, 1, 0);

        dialog.getDialogPane().setContent(grid);


        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == loginButtonType) {
                return username.getText();
            }
            return null;
        });

        VBox menuInicial = new VBox(30);
        menuInicial.setAlignment(Pos.CENTER);

        ImageView logoImage = new ImageView(new Image("file:recursos/imagenes/logo_balatro.png"));
        logoImage.setFitWidth(600);
        logoImage.setPreserveRatio(true);


        VBox botonesMenu = new VBox(15);
        botonesMenu.setAlignment(Pos.CENTER);
        botonesMenu.setPadding(new Insets(20, 20, 20, 20));
        botonesMenu.setMinWidth(300);
        botonesMenu.setMinHeight(200);


        String estiloBoton = "-fx-background-color: #2C3E50; " +
                "-fx-text-fill: white; " +
                "-fx-font-size: 20px; " +
                "-fx-min-width: 200px; " +
                "-fx-padding: 10px; " +
                "-fx-border-color: white; " +
                "-fx-border-radius: 5px; " +
                "-fx-background-radius: 5px;";

        Button botonJugar = crearBotonMenu("JUGAR", estiloBoton);
        botonJugar.setOnAction(e -> switchScenes(scene2));
        Button botonCargarPartida = crearBotonMenu("CARGAR PARTIDA", estiloBoton);


        botonesMenu.getChildren().addAll(botonJugar, botonCargarPartida);
        menuInicial.getChildren().addAll(logoImage, botonesMenu);

        root.getChildren().addAll(menuInicial);

        BorderPane root2 = new BorderPane();
        root2.setTop(menuBar);
        root2.setCenter(root);

        Scene scene = new Scene(root2, 1366, 768);

        Platform.runLater(() -> {
            Optional<String> result = dialog.showAndWait();
            result.ifPresent(nombre -> {

                System.out.println("Nombre del jugador: " + nombre);
                menuInicial.setVisible(true);
            });
        });

        return scene;
    }

    private Scene crearVisualPartida(){
        IMezclador mezclador = new MezcladorMazo();
        Mazo mazo = new Mazo(mezclador);
        ArrayList<Carta> cartas = mazo.repartir();

        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: #356C54");

        MenuBar menuBar = crearBarraDeMenus();

        VBox cajaGris = new VBox(10);
        cajaGris.setStyle("-fx-background-color: #2E393B");
        cajaGris.setPrefWidth(256);
        cajaGris.setMaxWidth(256);
        cajaGris.setMinWidth(256);
        cajaGris.setPrefHeight(Double.MAX_VALUE);
        cajaGris.setAlignment(Pos.CENTER);
        cajaGris.setPadding(new Insets(20, 20, 20, 20));
        cajaGris.setSpacing(20);
        cajaGris.setFillWidth(true);

        VBox cajaInterna1 = crearCajaInterna("#E29000", "NOMBRE RONDA", 65, 120);
        VBox cajaInterna2 = crearCajaInterna("#9D6400", "PUNTAJE \nNECESARIO", 147, 120);
        VBox cajaInterna3 = crearCajaInterna("#242B2C", "PUNTOS DE \nLA RONDA", 66, 120);
        VBox cajaInterna4 = crearCajaInterna("#242B2C", "PUNTUACION TIRADA", 136, 120);
        VBox cajaInterna5 = crearCajaInterna("#242B2C", "MANO RONDA DESCARTES", 124, 120);

        cajaGris.getChildren().addAll(cajaInterna1, cajaInterna2, cajaInterna3, cajaInterna4, cajaInterna5);

        AnchorPane anchor = new AnchorPane();

        HBox areaComodines = crearAreaComodines();
        AnchorPane.setTopAnchor(areaComodines, 20.0);
        AnchorPane.setLeftAnchor(areaComodines, 350.0);

        HBox areaTarots = crearAreaTarots();
        AnchorPane.setTopAnchor(areaTarots, 20.0);
        AnchorPane.setLeftAnchor(areaTarots, 950.0);

        HBox areaCartas = crearAreaCartas(cartas);
        AnchorPane.setBottomAnchor(areaCartas, 200.0);
        AnchorPane.setLeftAnchor(areaCartas, 350.0);

        HBox contenedorBotones = new HBox(20);
        contenedorBotones.setAlignment(Pos.CENTER);

        String estiloBotonJugar = "-fx-background-color: #007bff; " +
                "-fx-text-fill: white; " +
                "-fx-font-size: 20px; " +
                "-fx-min-width: 200px; " +
                "-fx-min-height: 50px; " +
                "-fx-padding: 10px; " +
                "-fx-background-radius: 5px; " +
                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.4), 5, 0, 3, 3);";

        String estiloBotonDescartar = "-fx-background-color: #dc3545; " +
                "-fx-text-fill: white; " +
                "-fx-font-size: 20px; " +
                "-fx-min-width: 200px; " +
                "-fx-min-height: 50px; " +
                "-fx-padding: 10px; " +
                "-fx-background-radius: 5px; " +
                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.4), 5, 0, 3, 3);";

        Button botonJugarMano = crearBotonMenu("JUGAR MANO", estiloBotonJugar);
        Button botonDescartar = crearBotonMenu("DESCARTAR", estiloBotonDescartar);

        contenedorBotones.getChildren().addAll(botonJugarMano, botonDescartar);
        AnchorPane.setBottomAnchor(contenedorBotones,  100.0);
        AnchorPane.setLeftAnchor(contenedorBotones, 520.0);

        Image image = new Image("file:recursos/imagenes/image_4.png");
        ImageView imageView = new ImageView(image);

        imageView.setFitHeight(165);
        imageView.setFitWidth(123.56);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);

        AnchorPane.setBottomAnchor(imageView, 100.0);
        AnchorPane.setRightAnchor(imageView, 40.0);

        anchor.getChildren().addAll(imageView, areaComodines, areaTarots, areaCartas, contenedorBotones);

        StackPane.setMargin(cajaGris, new Insets(0, 0, 0, 20));
        StackPane.setAlignment(cajaGris, Pos.CENTER_LEFT);

        root.getChildren().addAll(cajaGris, anchor);

        BorderPane root2 = new BorderPane();
        root2.setTop(menuBar);
        root2.setCenter(root);

        Scene scene = new Scene(root2, 1366, 768);

        return scene;
    }

    private HBox crearAreaComodines() {
        HBox jokersArea = new HBox(10);
        jokersArea.setStyle("-fx-background-color: rgba(111,115,107,0.6); -fx-background-radius: 15px");
        jokersArea.setPrefHeight(150);
        jokersArea.setPadding(new Insets(20, 20, 20, 20));
        jokersArea.setAlignment(Pos.CENTER);
        jokersArea.setPrefWidth(550);
        jokersArea.setMinWidth(550);

        String[] jokerImagenes = {
                "joker_rojo.png",
                "joker_azul.png",
                "joker_verde.png",
                "joker_morado.png",
                "joker_gris.png"
        };

        for (String imagePath : jokerImagenes) {
            ImageView joker = new ImageView(new Image("file:recursos/imagenes/" + imagePath));
            joker.setFitHeight(120);
            joker.setFitWidth(90);
            joker.setPreserveRatio(true);
            jokersArea.getChildren().add(joker);
        }

        return jokersArea;
    }

    private HBox crearAreaTarots() {
        HBox areaTarots = new HBox(10);
        areaTarots.setStyle("-fx-background-color: rgba(111,115,107,0.6); -fx-background-radius: 15px");
        areaTarots.setPrefHeight(150);
        areaTarots.setPadding(new Insets(20, 20, 20, 20));
        areaTarots.setAlignment(Pos.CENTER);
        areaTarots.setPrefWidth(230);
        areaTarots.setMinWidth(230);

        String[] imagenesTarot = {
                "tarot_mago.png",
                "tarot_emperador.png",
        };

        for (String imagePath : imagenesTarot) {
            ImageView tarot = new ImageView(new Image("file:recursos/imagenes/" + imagePath));
            tarot.setFitHeight(120);
            tarot.setFitWidth(90);
            tarot.setPreserveRatio(true);
            areaTarots.getChildren().add(tarot);
        }

        return areaTarots;
    }

    private HBox crearAreaCartas(ArrayList<Carta> cartas) {
        HBox areaCartas = new HBox(10);
        areaCartas.setPrefHeight(150);
        areaCartas.setPadding(new Insets(20, 20, 20, 20));
        areaCartas.setAlignment(Pos.CENTER);
        areaCartas.setPrefWidth(800);
        areaCartas.setMinWidth(800);

        String[] imagenesCartas = {
                "cartas_repartidas.png",
        };

        for (Carta carta : cartas) {
            ImageView cartaImagen = new ImageView(new Image("file:recursos/imagenes/cartas/" + carta.getImagen()));
            cartaImagen.setFitHeight(120);
            cartaImagen.setFitWidth(90);
            cartaImagen.setPreserveRatio(true);
            areaCartas.getChildren().add(cartaImagen);
        }

        return areaCartas;
    }

    private VBox crearCajaInterna(String color, String label, double height, double width) {
        VBox vbox = new VBox();
        vbox.setStyle("-fx-background-color: " + color + "; -fx-background-radius: 5;");

        Label label1 = new Label(label);
        label1.setStyle("-fx-text-fill: white;");

        vbox.getChildren().add(label1);

        vbox.setPrefWidth(width);
        vbox.setPrefHeight(height);
        vbox.setMinHeight(height);
        vbox.setMaxHeight(height);

        vbox.setAlignment(Pos.TOP_CENTER);

        vbox.setPadding(new Insets(10));

        return vbox;
    }

    public void switchScenes(Scene scene) {
        stage.setScene(scene);
    }

    private Button crearBotonMenu(String texto, String estilo) {
        Button boton = new Button(texto);

        String estiloBase = "-fx-background-color: #2C3E50; " +
                "-fx-text-fill: white; " +
                "-fx-font-size: 20px; " +
                "-fx-min-width: 200px; " +
                "-fx-min-height: 50px; " +
                "-fx-padding: 10px; " +
                "-fx-border-color: white; " +
                "-fx-border-width: 2px; " +
                "-fx-border-radius: 5px; " +
                "-fx-background-radius: 5px;";


        String estiloHover = estiloBase + "-fx-background-color: #34495E;";

        String estiloInicial = (estilo == null || estilo.isEmpty()) ? estiloBase : estilo;
        boton.setStyle(estiloInicial);

        String estiloHoverFinal = (estilo == null || estilo.isEmpty()) ? estiloHover : estilo + "-fx-opacity: 0.8;";
        boton.setOnMouseEntered(e -> boton.setStyle(estiloHoverFinal));
        boton.setOnMouseExited(e -> boton.setStyle(estiloInicial));

        System.out.println("Botón creado: " + texto);
        return boton;
    }


    public static void main(String[] args) {
        launch();
    }

}