package com.example.projetofinal;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EditorFrontEndController implements Initializable {

    @FXML
    private Label idCarta;
    @FXML
    private Button regressa;
    @FXML
    private TextArea pergunta;
    @FXML
    private Button novaCarta;
    @FXML
    private Button removerBotao;
    @FXML
    private ComboBox editarCartaBox;
    @FXML
    private Button proxima;
    @FXML
    private Button anterior;



    private String nomeBaralho;


    public void getNomeBaralho(String nomeBaralho)
    {
        this.nomeBaralho = nomeBaralho;
    }


    @FXML
    protected void aoClicarRegresso()
    {
        FXMLLoader fxmlLoader = new FXMLLoader(StudyMasterMainMenuController.class.getResource("editarBaralho.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 700, 600);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        stage.setTitle("Edição do Baralho!");
        stage.setScene(scene);

        stage.show();

        Stage oldStage = (Stage) regressa.getScene().getWindow();
        oldStage.close();
        oldStage = null;
    }

    @FXML
    protected void aoClicarNovaCarta()
    {

        System.out.println("Implementar nova Janela.");
    }

    @FXML
    protected void aoClicarRemoverCarta()
    {

    }

    @FXML
    protected void aoClicarProxima(){

    }

    @FXML
    protected void aoClicarAnterior()
    {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int idMaisBaixo;
        idMaisBaixo = Dados.idMaisBaixoDoBaralho();
        idCarta.setText();
    }
}
