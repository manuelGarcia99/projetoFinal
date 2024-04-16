package com.example.projetofinal;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class RevisorFrontEndController implements Initializable {
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

    private int ultimoId;////Esta variável deve ser apagada quando concluido o Backend


    private ArrayList<Carta> cartas;
    ///para apagar a ArrayList de baixo quando concluirmos o Backend
    private ArrayList<CartaTeste> cartasDeTeste;
    public void GetNomeDoBaralho(String nomeDoBaralho)
    {
        this.nomeDoBaralho = nomeDoBaralho;
    }


    @FXML
    protected void aoClicarMostra(){///vamos começar com 3 cartas depois vamos ter base de dados e uma classe de Bacckend
        mostraOVerso.setVisible(false);
        mostraOVerso.setMouseTransparent(true);
        pergunta.setVisible(true);
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
    }

    @FXML
    protected void aoClicarMostraD1()
    {
        for(CartaTeste cartinha : cartasDeTeste) {
            if(cartinha.getId() ==ultimoId) {
                Alert box = new Alert(Alert.AlertType.INFORMATION,cartinha.getDefinicao1(),ButtonType.OK);
            }
        }

    }
    @FXML
    protected void aoClicarMostraD2()
    {
        for(CartaTeste cartinha : cartasDeTeste) {
            if(cartinha.getId() ==ultimoId) {
                Alert box = new Alert(Alert.AlertType.INFORMATION,cartinha.getDefinicao2(),ButtonType.OK);
            }
        }

    }
    @FXML
    protected void aoClicarOpcao0()
    {
        escolhido.setText("0");
        escolhido.setVisible(true);
        ///Depois temos que implementar mais coisas no Backend noutra Classe
    }

    @FXML
    protected void aoClicarOpcao1()
    {
        escolhido.setText("1");
        escolhido.setVisible(true);
        ///Depois temos que implementar mais coisas no Backend noutra Classe
    }

    @FXML
    protected void aoClicarOpcao2()
    {
        escolhido.setText("2");
        escolhido.setVisible(true);
        ///Depois temos que implementar mais coisas no Backend noutra Classe
    }

    @FXML
    protected void aoClicarOpcao3()
    {
        escolhido.setText("3");
        escolhido.setVisible(true);
        ///Depois temos que implementar mais coisas no Backend noutra Classe
    }

    @FXML
    protected void aoClicarOpcao4()
    {
        escolhido.setText("4");
        escolhido.setVisible(true);
        ///Depois temos que implementar mais coisas no Backend noutra Classe
    }

    @FXML
    protected void aoClicarOpcao5()
    {
        escolhido.setText("5");
        escolhido.setVisible(true);
        ///Depois temos que implementar mais coisas no Backend noutra Classe
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {//aqui vamos chamar a função mostra
        ///Sem backend primeiro
        ///No backend povoamos a arrayListCartas com as cartas do dia
        ///No backend escolhemos aleatoriamente as cartas
        ///No backend alteramos o valor das cartas a cada iteração
        ///O resto é no FrontEnd
        CartaTeste carta1 = new CartaTeste(1,"Quantos faraós teve o Egipto?","Reinaram 170 faraós em menos de 30 dinastias","Faraó","Faraó é o título que se refere ao monarca governante do Egito Antigo.","Dinastia","Dinastia é o período de sucessão, que reis e rainhas, pertencentes a uma mesma família, permanecem no poder.","Baralho 1");
        CartaTeste carta2 = new CartaTeste(2,"Quem foi Leonardo Da Vinci?","Leonardo di Ser Piero da Vinci, ou simplesmente Leonardo da Vinci, foi um polímata nascido na atual Itália, uma das figuras mais importantes do Alto Renascimento, que se destacou como cientista, matemático, engenheiro, inventor, anatomista, pintor, escultor, arquiteto, botânico, poeta e músico.","Polímata","Polímata vem do grego polymathēs, que significa “aquele que aprendeu muito”. Atualmente, o termo é usado para designar pessoas que estudaram e aprenderam muito em várias áreas do conhecimento humano.","Alto Renascimento","A Alta Renascença, Alto Renascimento ou Alto Renascentismo representa, na história da arte, o ponto culminante da arte da Renascença italiana entre 1450 e 1527.","Baralho 1");
        CartaTeste carta3 = new CartaTeste(3,"Quem construiu Versalhes?","Considera-se que a construção do Palácio de Versalhes iniciou-se por ordem do rei Luís XIV, o mais poderoso rei francês do período absolutista.","Baralho 1");
        cartasDeTeste.add(carta1);
        cartasDeTeste.add(carta2);
        cartasDeTeste.add(carta3);
        ultimoId = 1;
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
        for(CartaTeste cartinha : cartasDeTeste) {
            if(cartinha.getId() ==ultimoId) {
                pergunta.setText(cartinha.getPergunta());
                definicao1.setText(cartinha.getTermo1());
                definicao2.setText(cartinha.getTermo2());
            }
        }
    }
}
