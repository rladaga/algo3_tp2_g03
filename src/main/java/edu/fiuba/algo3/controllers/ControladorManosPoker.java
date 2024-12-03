package edu.fiuba.algo3.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ControladorManosPoker implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        Stage ventanaReglas = new Stage();
        ventanaReglas.getIcons().add(new Image(getClass().getResourceAsStream("/imagenes/logo_balatro.png")));
        ventanaReglas.initModality(Modality.APPLICATION_MODAL);
        ventanaReglas.setTitle("Manos de Poker y Puntuación");
        ventanaReglas.setResizable(false);

        String cssBackground = "-fx-background-color: #2C363F;";


        VBox contenedorPrincipal = new VBox();
        contenedorPrincipal.setStyle(cssBackground);
        contenedorPrincipal.setPadding(new Insets(20));

        contenedorPrincipal.setFillWidth(true);


        VBox listaItems = new VBox(5);
        listaItems.setStyle(cssBackground);

        String[][] manos = {
                {"Royal Flush (Escalera Real)", "100", "8", "/imagenes/escalera_real.png"},
                {"Straight Flush (Escalera de Color)", "100", "8", "/imagenes/escalera_color.png"},
                {"Four of a Kind (Poker)", "60", "7", "/imagenes/poker.png"},
                {"Full House", "40", "4", "/imagenes/full_house.png"},
                {"Flush (Color)", "35", "4", "/imagenes/color.png"},
                {"Straight (Escalera)", "30", "4", "/imagenes/escalera.png"},
                {"Three of a Kind (Trio)", "30", "3", "/imagenes/trio.png"},
                {"Two Pair (Doble Par)", "20", "2", "/imagenes/doble_par.png"},
                {"Pair (Par)", "10", "2", "/imagenes/par.png"},
                {"High Card (Carta Alta)", "5", "1", "/imagenes/carta_alta.png"}
        };

        for (String[] mano : manos) {
            VBox item = new VBox(10);
            item.setStyle("-fx-background-color: #B8C0C9; -fx-background-radius: 5; -fx-padding: 10;");
            item.setMaxWidth(Double.MAX_VALUE);

            Text nombre = new Text(mano[0]);
            nombre.setStyle("-fx-font-family: 'Balatro'; -fx-font-size: 14px; -fx-font-weight: bold;");


            HBox puntosBox = new HBox(1);
            puntosBox.setAlignment(Pos.CENTER_LEFT);

            Text puntos = new Text(mano[1]);
            puntos.setStyle("-fx-font-family: 'Balatro'; -fx-fill: #3973E5;");

            Text cruz = new Text(" × ");
            cruz.setStyle("-fx-font-family: 'Balatro'; -fx-fill: #dc3545;");

            Text multi = new Text(mano[2]);
            multi.setStyle("-fx-font-family: 'Balatro'; -fx-fill: #dc3545;");

            puntosBox.getChildren().addAll(puntos, cruz, multi);

            item.getChildren().addAll(nombre, puntosBox);

            Image imagen = new Image(getClass().getResourceAsStream(mano[3]));
            ImageView imageView = new ImageView(imagen);
            imageView.setFitWidth(375);
            imageView.setFitHeight(100);

            Tooltip tooltip = new Tooltip();
            tooltip.setGraphic(imageView);
            tooltip.setShowDelay(Duration.millis(100));
            tooltip.setHideDelay(Duration.millis(100));

            Tooltip.install(item, tooltip);

            listaItems.getChildren().add(item);
        }

        StackPane stackPane = new StackPane(listaItems);
        stackPane.setStyle(cssBackground);
        VBox.setVgrow(stackPane, Priority.ALWAYS);
        stackPane.setMaxWidth(Double.MAX_VALUE);


        String fontFamily = "Balatro";
        String css = "-fx-font-family: '" + fontFamily + "';";

        contenedorPrincipal.getChildren().add(stackPane);

        Scene scene = new Scene(contenedorPrincipal, 400, 650);
        scene.getRoot().setStyle(css + cssBackground);

        ventanaReglas.setScene(scene);
        ventanaReglas.show();
    }
}
