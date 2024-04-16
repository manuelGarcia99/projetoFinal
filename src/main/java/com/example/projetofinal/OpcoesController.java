package com.example.projetofinal;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class OpcoesController implements Initializable {
    @FXML
    Button regressa;

    ////usar o link em baixo, há que perceber onde e como e quantas vezes se ativa o darkmode de preferência o menos código possivél
    ////https://github.com/antoniopelusi/JavaFX-Dark-Theme/blob/main/README.md

    @FXML
    MenuButton lingua;
    @FXML
    MenuButton tema;

    @FXML
    protected void aoClicarRegresso(){
        FXMLLoader fxmlLoader = new FXMLLoader(OpcoesController.class.getResource("main.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 700, 600);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        stage.setTitle("Study Master!");
        stage.setScene(scene);

        stage.show();

        Stage oldStage = (Stage) regressa.getScene().getWindow();
        oldStage.close();
        oldStage = null;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        MenuItem portugues = new MenuItem("Português");
        portugues.setOnAction(e -> {
            // completar
        });

        MenuItem ingles = new MenuItem("Inglês");
        ingles.setOnAction(e -> {
            // completar
        });

        MenuItem dark = new MenuItem("Dark");
        dark.setOnAction(e -> {
            // completar
        });

        MenuItem light = new MenuItem("Light");
        light.setOnAction(e -> {
            // completar
        });
        tema.getItems().clear();
        lingua.getItems().clear();
        tema.getItems().addAll(dark,light);
        lingua.getItems().addAll(portugues, ingles);
    }
}
