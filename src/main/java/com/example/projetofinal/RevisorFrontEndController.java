package com.example.projetofinal;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class RevisorFrontEndController {
    private String nomeDoBaralho;///Quando acabarmos o BackEnd Temos que escolher isto
    @FXML
    private TextArea pergunta;
    @FXML
    private TextArea resposta;
    @FXML
    private Button mostraOVerso;
    @FXML
    private Button mostraD1;
    @FXML
    private Button mostraD2;
    @FXML
    private Button proxima;
    @FXML
    private Label definicao1;
    @FXML
    private Label definicao2;
    @FXML
    private Label escolhido;
    @FXML
    private MenuButton entendimento;
    @FXML
    private MenuItem opcao0;
    @FXML
    private MenuItem opcao1;
    @FXML
    private MenuItem opcao2;
    @FXML
    private MenuItem opcao3;
    @FXML
    private MenuItem opcao4;
    @FXML
    private MenuItem opcao5;

    private int ID;////Esta variável deve ser apagada quando concluido o Backend


    private ArrayList<Carta> cartas;
    ///para apagar a ArrayList de baixo quando concluirmos o Backend
    private ArrayList<CartaTeste> cartasDeTeste;
    private int qualidade;
    public void GetNomeDoBaralho(String nomeDoBaralho)
    {
        this.nomeDoBaralho = nomeDoBaralho;
    }


    @FXML
    protected void aoClicarMostra(){///vamos começar com 3 cartas depois vamos ter base de dados e uma classe de Bacckend

        mostraOVerso.setVisible(false);
        mostraOVerso.setMouseTransparent(true);
        resposta.setVisible(true);
        entendimento.setVisible(true);
        mostraD1.setVisible(true);
        mostraD2.setVisible(true);
        definicao1.setVisible(true);
        definicao2.setVisible(true);
        proxima.setVisible(true);
        entendimento.setMouseTransparent(false);
        mostraD1.setMouseTransparent(false);
        mostraD2.setMouseTransparent(false);
        proxima.setMouseTransparent(false);
        pergunta.setMouseTransparent(true);

        resposta.setText(Dados.encheAreaDoTextoDeResposta(ID));
        definicao1.setText(Dados.encontraTermo1(ID));
        definicao2.setText(Dados.encontraTermo2(ID));
    }

    @FXML
    protected void aoClicarMostraD1()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION,Dados.encontraDefinicao1(ID));
        alert.showAndWait();

    }
    @FXML
    protected void aoClicarMostraD2()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION,Dados.encontraDefinicao2(ID));
        alert.showAndWait();

    }
    @FXML
    protected void aoClicarOpcao0()
    {
        escolhido.setText("0");
        escolhido.setVisible(true);
        resposta.setVisible(false);
        ///Depois temos que implementar mais coisas no Backend noutra Classe
    }

    @FXML
    protected void aoClicarOpcao1()
    {
        escolhido.setText("1");
        escolhido.setVisible(true);
        resposta.setVisible(false);

        ///Depois temos que implementar mais coisas no Backend noutra Classe
    }

    @FXML
    protected void aoClicarOpcao2()
    {
        escolhido.setText("2");
        escolhido.setVisible(true);
        resposta.setVisible(false);
        ///Depois temos que implementar mais coisas no Backend noutra Classe
    }

    @FXML
    protected void aoClicarOpcao3()
    {
        escolhido.setText("3");
        escolhido.setVisible(true);
        resposta.setVisible(false);
        ///Depois temos que implementar mais coisas no Backend noutra Classe
    }

    @FXML
    protected void aoClicarOpcao4()
    {
        escolhido.setText("4");
        escolhido.setVisible(true);
        resposta.setVisible(false);
        ///Depois temos que implementar mais coisas no Backend noutra Classe
    }

    @FXML
    protected void aoClicarOpcao5()
    {
        escolhido.setText("5");
        escolhido.setVisible(true);
        resposta.setVisible(false);
        ///Depois temos que implementar mais coisas no Backend noutra Classe
    }

    public void refresh()
    {



        resposta.setVisible(false);
        mostraD1.setVisible(false);
        mostraD2.setVisible(false);
        definicao1.setVisible(false);
        definicao2.setVisible(false);
        proxima.setVisible(false);
        entendimento.setVisible(false);
        escolhido.setVisible(false);
        mostraD1.setMouseTransparent(true);
        mostraD2.setMouseTransparent(true);
        proxima.setMouseTransparent(true);
        entendimento.setMouseTransparent(true);
        ID = Dados.idMaisBaixoDoBaralho(nomeDoBaralho);///para alterar mais tarde
        pergunta.setText(Dados.encheAreaDoTextoDePergunta(ID));
    }


}
