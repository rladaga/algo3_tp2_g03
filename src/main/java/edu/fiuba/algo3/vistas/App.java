package edu.fiuba.algo3.vistas;

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
        stage.show();
    }

    private Scene crearMenuInicial(){
        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: linear-gradient(to right, #8B0000, #000080);");

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

        ImageView logoImage = new ImageView(new Image("file:src/main/java/edu/fiuba/algo3/vistas/assets/logo_balatro.png"));
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
                "-fx-border-radius: 5px; " +
                "-fx-background-radius: 5px;";

        Button botonJugar = crearBotonMenu("JUGAR", estiloBoton);
        botonJugar.setOnAction(e -> switchScenes(scene2));
        Button botonCargarPartida = crearBotonMenu("CARGAR PARTIDA", estiloBoton);


        botonesMenu.getChildren().addAll(botonJugar, botonCargarPartida);
        menuInicial.getChildren().addAll(logoImage, botonesMenu);

        root.getChildren().addAll(menuInicial);


        Scene scene = new Scene(root, 1024, 768);

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
        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: #356C54");

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
        AnchorPane.setLeftAnchor(areaComodines, 300.0);

        Image image = new Image("file:src/main/java/edu/fiuba/algo3/vistas/assets/image_4.png");
        ImageView imageView = new ImageView(image);

        imageView.setFitHeight(165);
        imageView.setFitWidth(123.56);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);

        AnchorPane.setBottomAnchor(imageView, 80.0);
        AnchorPane.setRightAnchor(imageView, 40.0);

        anchor.getChildren().addAll(imageView, areaComodines);

        StackPane.setMargin(cajaGris, new Insets(0, 0, 0, 20));
        StackPane.setAlignment(cajaGris, Pos.CENTER_LEFT);

        root.getChildren().addAll(cajaGris, anchor);

        Scene scene = new Scene(root, 1024, 768);

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

        // Crear los 5 jokers
        String[] jokerImages = {
                "joker_rojo.png",
                "joker_azul.png",
                "joker_verde.png",
                "joker_morado.png",
                "joker_gris.png"
        };

        for (String imagePath : jokerImages) {
            ImageView joker = new ImageView(new Image("file:src/main/java/edu/fiuba/algo3/vistas/assets/" + imagePath));
            joker.setFitHeight(120);
            joker.setFitWidth(90);
            joker.setPreserveRatio(true);
            jokersArea.getChildren().add(joker);
        }

        return jokersArea;
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

        boton.setStyle(estiloBase);

        // Eventos de mouse para efectos visuales
        boton.setOnMouseEntered(e -> boton.setStyle(estiloHover));
        boton.setOnMouseExited(e -> boton.setStyle(estiloBase));

        System.out.println("Botón creado: " + texto);
        return boton;
    }


    public static void main(String[] args) {
        launch();
    }

}