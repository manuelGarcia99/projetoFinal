package com.example.projetofinal;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class AdicionarCartaController
{
    /*
    *
    *
    * Aqui temos que andar com as definições de um lado para o outro também*/
    @FXML
    private Button regressa;
    @FXML
    private TextArea textoPergunta;
    @FXML
    private TextArea textoResposta;
    @FXML
    private Button definicaoBotao1;//Ao carregar neste botão caso o definicao1 não seja null pedir confirmação
    @FXML
    private Button definicaoBotao2;//Ao carregar neste botão caso o definicao2 não seja null pedir confirmação
    @FXML
    private Button concluir;


    private int idUltimaCarta;
    private String nomeDoBaralho;
    private String termo1;
    private String termo2;
    private String definicao1;
    private String definicao2;

    public void getIDUltimaCarta(int idUltimaCarta)
    {
        this.idUltimaCarta = idUltimaCarta;
    }

    public void getNomeDoBaralho(String nomeDoBaralho)
    {
        this.nomeDoBaralho = nomeDoBaralho;
    }

    public void getDefinicao1(String termo1 ,String definicao1)
    {
        this.termo1 = termo1;
        this.definicao1 = definicao1;
    }

    public void getDefinicao2(String termo2, String definicao2)
    {
        this.termo2 = termo2;
        this.definicao2 = definicao2;
    }


    @FXML
    protected void aoClicarDefinicao1(){
        FXMLLoader fxmlLoader = new FXMLLoader(StudyMasterMainMenu.class.getResource("adicionarDefinicao1.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 700, 600);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        stage.setTitle("Definição 1");
        stage.setScene(scene);
        stage.show();

        AdicionadorDefinicao1Controller controllerEditor = fxmlLoader.getController();

        controllerEditor.getIdCarta(idUltimaCarta);
        controllerEditor.getNomeBaralho(nomeDoBaralho);
        controllerEditor.getDefinicao1(definicao1,termo1);
        controllerEditor.getDefinicao2(definicao2,termo2);

        Stage oldStage = (Stage) regressa.getScene().getWindow();
        oldStage.close();
        oldStage = null;

    }

    @FXML
    protected void aoClicarDefinicao2(){
        FXMLLoader fxmlLoader = new FXMLLoader(StudyMasterMainMenu.class.getResource("adicionarDefinicao2.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 700, 600);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        stage.setTitle("Definição 2");
        stage.setScene(scene);
        stage.show();

        AdicionadorDefinicao2Controller controllerEditor = fxmlLoader.getController();

        controllerEditor.getIdCarta(idUltimaCarta);
        controllerEditor.getNomeBaralho(nomeDoBaralho);
        controllerEditor.getDefinicao2(definicao2,termo2);
        controllerEditor.getDefinicao1(definicao1,termo1);

        Stage oldStage = (Stage) regressa.getScene().getWindow();
        oldStage.close();
        oldStage = null;
    }

    @FXML
    protected void aoClicarConcluir(){
        ///Ao clicar concluido começa-se por este
        Carta carta = new Carta(textoPergunta.getText(),textoResposta.getText(),termo1,definicao1,termo2,definicao2,nomeDoBaralho);
        System.out.println(termo1 + "- " + definicao1);
        System.out.println(termo2 + "- " + definicao2);

        Dados.criaCarta(carta);
        textoPergunta.setText("");
        textoResposta.setText("");
    }

    @FXML
    protected void aoClicarRegressa(){
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

        controllerEditor.getNomeBaralho(nomeDoBaralho);
        controllerEditor.getID(idUltimaCarta);
        controllerEditor.refresh();


        Stage oldStage = (Stage) regressa.getScene().getWindow();
        oldStage.close();
        oldStage = null;


    }



}
