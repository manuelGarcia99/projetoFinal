package com.example.projetofinal;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EditorFrontEndController implements Initializable {
/*Importante!
* Devo ter cuidado!
* Importante!
* Quando volto de adicionar uma carta ou editar uma carta
* Tenho que criar uma função voltar o que implica andar com o id da última carta
* Para as outras windows e voltar para esta
* Também tenho que dar refresh desta window numa função desta window
* Primeiro fazemos a função AdicionarCarta
* Esta vai precisar do initialize do método get do ID e get do NomeDoBaralho
* Vai precisar da função regressar que vai ter que usar o método get do ID e Get do NomeDoBaralho  e o método refresh daqui*/
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
        FXMLLoader fxmlLoader = new FXMLLoader(StudyMasterMainMenu.class.getResource("editarBaralho.fxml"));
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
        idMaisBaixo = Dados.idMaisBaixoDoBaralho(nomeBaralho);


        idCarta.setText(Integer.toString(idMaisBaixo));
        if(idMaisBaixo != 0){
            ///Vai executar quando o baralho não está vazio.

        }
        else{
            ///Vai executar quando o baralho está vazio
        }
    }
}
