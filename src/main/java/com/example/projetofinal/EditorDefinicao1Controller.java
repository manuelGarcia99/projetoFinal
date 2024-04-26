package com.example.projetofinal;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EditorDefinicao1Controller  {
    @FXML
    private Button regressa;
    @FXML
    private Button concluir;
    @FXML
    private TextField termoTexto;
    @FXML
    private TextArea definicaoTexto;


    private int ID;
    private String nomeBaralho;

    public void getID(int ID){
        this.ID = ID;
    }

    public void getNomeBaralho(String nomeBaralho)
    {
        this.nomeBaralho = nomeBaralho;
    }

    @FXML
    private void aoClicarRegressa()
    {
        FXMLLoader fxmlLoader = new FXMLLoader(StudyMasterMainMenu.class.getResource("editorDeCartas.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 700, 600);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        stage.setTitle("Editor de Cartas!");
        stage.setScene(scene);

        stage.show();

        EditorFrontEndController controllerEditor = fxmlLoader.getController();

        controllerEditor.getNomeBaralho(nomeBaralho);
        controllerEditor.getID(ID);
        controllerEditor.refresh();


        Stage oldStage = (Stage) regressa.getScene().getWindow();
        oldStage.close();
        oldStage = null;
    }

    @FXML
    private void aoClicarConcluir()
    {
        Dados.novaDefinicao1(termoTexto.getText(),definicaoTexto.getText(),ID);
        FXMLLoader fxmlLoader = new FXMLLoader(StudyMasterMainMenu.class.getResource("editorDeCartas.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 700, 600);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        stage.setTitle("Editor de Cartas!");
        stage.setScene(scene);

        stage.show();

        EditorFrontEndController controllerEditor = fxmlLoader.getController();

        controllerEditor.getNomeBaralho(nomeBaralho);
        controllerEditor.getID(ID);
        controllerEditor.refresh();


        Stage oldStage = (Stage) regressa.getScene().getWindow();
        oldStage.close();
        oldStage = null;
    }

    public void refresh()
    {
        System.out.println("O que aparece na definição é " + Dados.encontraDefinicao1(ID));
        definicaoTexto.setText(Dados.encontraDefinicao1(ID));
        termoTexto.setText(Dados.encontraTermo1(ID));
    }
}
