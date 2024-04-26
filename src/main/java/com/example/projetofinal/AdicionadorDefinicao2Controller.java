package com.example.projetofinal;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AdicionadorDefinicao2Controller {
    @FXML
    private Button regressa;
    @FXML
    private Button concluir;
    @FXML
    private TextField textoTermo;
    @FXML
    private TextArea textoDefinicao;


    private int IDcarta;
    private String nomeBaralho;
    private String definicao1;
    private String termo1;
    private String definicao2;
    private String termo2;

    public void getIdCarta(int IDCarta){
        this.IDcarta = IDCarta;
    }


    public void getNomeBaralho(String nomeBaralho)
    {
        this.nomeBaralho = nomeBaralho;
    }

    public void getDefinicao1(String definicao1,String termo1 )
    {
        this.definicao1 = definicao1;
        this.termo1 = termo1;
    }

    public void getDefinicao2(String definicao2,String termo2 )
    {
        this.definicao2 = definicao2;
        this.termo2 = termo2;
    }

    @FXML
    private void aoClicarRegressa()
    {
        FXMLLoader fxmlLoader = new FXMLLoader(StudyMasterMainMenu.class.getResource("adicionadorDeCartas.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 700, 600);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        stage.setTitle("Adiciona cartas!");
        stage.setScene(scene);

        stage.show();
        ///Agora tenho que fazer umas coisas V
        ///tenho que voltar mas com o UltimoId e com o NomeDoBaralho V
        ///tenho também que dar refresh aos componentes V
        ///Ultima alteração 18-04-24 15:18
        AdicionarCartaController controllerAdicionador = fxmlLoader.getController();
        controllerAdicionador.getNomeDoBaralho(nomeBaralho);
        controllerAdicionador.getIDUltimaCarta(IDcarta);





        Stage oldStage = (Stage) regressa.getScene().getWindow();
        oldStage.close();
        oldStage = null;
    }

    @FXML
    private void aoClicarConcluir()
    {
        if(textoTermo.getText().isEmpty() || textoDefinicao.getText().isEmpty())
        {
            aoClicarRegressa();
        }
        else{
            FXMLLoader fxmlLoader = new FXMLLoader(StudyMasterMainMenu.class.getResource("adicionadorDeCartas.fxml"));
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load(), 900, 600);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Stage stage = new Stage();
            stage.setTitle("Adiciona cartas!");
            stage.setScene(scene);

            stage.show();
            ///Agora tenho que fazer umas coisas V
            ///tenho que voltar mas com o UltimoId e com o NomeDoBaralho V
            ///tenho também que dar refresh aos componentes V
            ///Ultima alteração 18-04-24 15:18
            AdicionarCartaController controllerAdicionador = fxmlLoader.getController();
            controllerAdicionador.getNomeDoBaralho(nomeBaralho);
            controllerAdicionador.getIDUltimaCarta(IDcarta);
            controllerAdicionador.getDefinicao1(termo1,definicao1);
            controllerAdicionador.getDefinicao2(textoTermo.getText(),textoDefinicao.getText());


            Stage oldStage = (Stage) regressa.getScene().getWindow();
            oldStage.close();
            oldStage = null;
        }

    }
}
