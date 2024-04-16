package com.example.projetofinal;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CriarBaralhoController {
    @FXML
    Button regressa;
    @FXML
    Button botaoCriar;
    @FXML
    TextField nome;


    @FXML
    protected void aoClicarRegresso(){
        FXMLLoader fxmlLoader = new FXMLLoader(CriarBaralhoController.class.getResource("main.fxml"));
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

    @FXML
    protected void aoClicarCriar(){
        if(!nome.getText().equals("")){
            Alert confirma = new Alert(Alert.AlertType.CONFIRMATION,"Quer criar o baralho " + nome.getText() + "?", ButtonType.YES,ButtonType.NO);
            confirma.showAndWait();
            if(confirma.getResult() == ButtonType.YES){
                //Cria-se e adiciona-se á lista e à base de dados.
            }
        }
    }
}
