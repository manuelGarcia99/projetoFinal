package com.example.projetofinal;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class StudyMasterMainMenuController {
    @FXML
    private Button opcoes;
    @FXML
    private Button criar;
    @FXML
    private Button rever;
    @FXML
    private Button apagar;
    @FXML
    private Button editar;



    @FXML
    protected void aoClicarBotaoDefinicoes() {
        FXMLLoader fxmlLoader = new FXMLLoader(StudyMasterMainMenuController.class.getResource("opcoes.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 600, 600);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        stage.setTitle("Definições");
        stage.setScene(scene);

        stage.show();

        Stage oldStage = (Stage) opcoes.getScene().getWindow();
        oldStage.close();
        oldStage = null;
    }

    @FXML
    protected void aoClicarBotaoCriar(){
        FXMLLoader fxmlLoader = new FXMLLoader(StudyMasterMainMenuController.class.getResource("criarBaralho.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 600, 600);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        stage.setTitle("Criação do Baralho");
        stage.setScene(scene);

        stage.show();

        Stage oldStage = (Stage) criar.getScene().getWindow();
        oldStage.close();
        oldStage = null;
    }

    @FXML
    protected void aoClicarBotaoApagar(){
        FXMLLoader fxmlLoader = new FXMLLoader(StudyMasterMainMenuController.class.getResource("apagarBaralho.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 600, 600);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        stage.setTitle("Apagar do Baralho");
        stage.setScene(scene);

        stage.show();

        Stage oldStage = (Stage) apagar.getScene().getWindow();
        oldStage.close();
        oldStage = null;
    }

    @FXML
    protected void aoClicarBotaoRever(){
        FXMLLoader fxmlLoader = new FXMLLoader(StudyMasterMainMenuController.class.getResource("reverBaralho.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 600, 600);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        stage.setTitle("Revisão do Baralho");
        stage.setScene(scene);

        stage.show();

        Stage oldStage = (Stage) rever.getScene().getWindow();
        oldStage.close();
        oldStage = null;
    }

    @FXML
    protected void aoClicarBotaoEditar(){
        FXMLLoader fxmlLoader = new FXMLLoader(StudyMasterMainMenuController.class.getResource("editarBaralho.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 600, 600);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        stage.setTitle("Edição do Baralho");
        stage.setScene(scene);

        stage.show();

        Stage oldStage = (Stage) editar.getScene().getWindow();
        oldStage.close();
        oldStage = null;
    }
}