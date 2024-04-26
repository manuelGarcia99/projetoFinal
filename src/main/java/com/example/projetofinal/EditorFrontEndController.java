package com.example.projetofinal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EditorFrontEndController implements Initializable  {
/*Importante!
* Devo ter cuidado!
* Importante!
* Quando volto de adicionar uma carta ou editar uma carta v
* Tenho que criar uma função voltar o que implica andar com o id da última carta v
* Para as outras windows e voltar para esta v
* Também tenho que dar refresh desta window numa função desta window v
* Primeiro fazemos a window AdicionarCarta
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
    private int ID;


    public void getID(int ID)
    {
        this.ID = ID;
    }
    public void getNomeBaralho(String nomeBaralho)
    {
        this.nomeBaralho = nomeBaralho;
    }

    protected void refresh()
    {
        idCarta.setText(Integer.toString(ID));
        if(ID != 0)
            pergunta.setText(Dados.encheAreaDoTextoDePergunta(ID));
        else
            pergunta.setText("");
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
        /*
        * Temos que chamar as funções get e as função refresh
        *
        *
        *
        *
        *
        *  */
        FXMLLoader fxmlLoader = new FXMLLoader(StudyMasterMainMenu.class.getResource("adicionadorDeCartas.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 900, 600);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        stage.setTitle("Adicione cartas!");
        stage.setScene(scene);

        stage.show();
        AdicionarCartaController controllerAdicionador = fxmlLoader.getController();
        controllerAdicionador.getIDUltimaCarta(ID);
        controllerAdicionador.getNomeDoBaralho(nomeBaralho);

        Stage oldStage = (Stage) regressa.getScene().getWindow();
        oldStage.close();
        oldStage = null;

    }

    @FXML
    protected void aoClicarRemoverCarta()
    {
        Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION,"Queres mesmo apagar a carta?",ButtonType.OK,ButtonType.CANCEL);
        confirmacao.showAndWait();
        Dados.removerCarta(ID);
        aoClicarProxima();

    }

    @FXML
    protected void aoClicarProxima(){
        /*
        * Muda de carta para a próxima tem que se ver o caso de ser a última carta
        * */
        ID = Dados.encontraIdProximaCarta(ID, nomeBaralho);
        refresh();
    }

    @FXML
    protected void aoClicarAnterior()
    {

        ID = Dados.encontraIdCartaAnterior(ID,nomeBaralho);
        refresh();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        editarCartaBox.getItems().addAll("Pergunta", "Resposta", "Definição 1", "Definição 2");

    }

    private void editarResposta()
    {
        FXMLLoader fxmlLoader = new FXMLLoader(StudyMasterMainMenu.class.getResource("editorResposta.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 900, 600);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        stage.setTitle("Edite a resposta!");
        stage.setScene(scene);

        stage.show();
        /*
        * Fazer get do id e do nome do baralho
        *
        *
        * */
        EditorRespostaController controller = fxmlLoader.getController();
        controller.getID(ID);
        controller.getNomeBaralho(nomeBaralho);
        controller.refresh();
        Stage oldStage = (Stage) regressa.getScene().getWindow();
        oldStage.close();
        oldStage = null;
    }

    private void editarPergunta()
    {
        FXMLLoader fxmlLoader = new FXMLLoader(StudyMasterMainMenu.class.getResource("editorPergunta.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 900, 600);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        stage.setTitle("Edite a pergunta!");
        stage.setScene(scene);

        stage.show();
        /*
         * Fazer get do id e do nome do baralho
         *
         *
         * */
        EditorPerguntaController controller = fxmlLoader.getController();
        controller.getID(ID);
        controller.getNomeBaralho(nomeBaralho);
        controller.refresh();//Precisamos de usar o refresh antes do initialize porque o initialize corre antes dos gets
        Stage oldStage = (Stage) regressa.getScene().getWindow();
        oldStage.close();
        oldStage = null;
    }

    private void editarDefinicao1()
    {
        FXMLLoader fxmlLoader = new FXMLLoader(StudyMasterMainMenu.class.getResource("editorDefinicao1.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 900, 600);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        stage.setTitle("Edite a definição!");
        stage.setScene(scene);

        stage.show();
        /*
         * Fazer get do id e do nome do baralho
         *
         *
         * */
        EditorDefinicao1Controller controller = fxmlLoader.getController();
        controller.getID(ID);
        controller.getNomeBaralho(nomeBaralho);
        controller.refresh();

        Stage oldStage = (Stage) regressa.getScene().getWindow();
        oldStage.close();
        oldStage = null;
    }

    private void editarDefinicao2()
    {
        FXMLLoader fxmlLoader = new FXMLLoader(StudyMasterMainMenu.class.getResource("editorDefinicao2.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 900, 600);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        stage.setTitle("Edite a definição!");
        stage.setScene(scene);

        stage.show();
        /*
         * Fazer get do id e do nome do baralho
         *
         *
         * */
        EditorDefinicao2Controller controller = fxmlLoader.getController();
        controller.getID(ID);
        controller.getNomeBaralho(nomeBaralho);
        controller.refresh();


        Stage oldStage = (Stage) regressa.getScene().getWindow();
        oldStage.close();
        oldStage = null;
        /*Quando acabar isto só vai faltar o revisor
        *
        *
        *
        *
        * */
    }


    @FXML
    private void aoClicarEditar(ActionEvent event) {
        // Retrieve the selected item
        String selected = (String) editarCartaBox.getValue();

        // Check the selected slot and perform specific actions
        switch (selected) {
            case "Pergunta":
                editarPergunta();
                break;
            case "Resposta":
                editarResposta();
                break;
            case "Definição 1":
                editarDefinicao1();
                break;
            case "Definição 2":
                editarDefinicao2();
                break;
            default:
                System.out.println("Algo de errado!");
                break;
        }
    }
}
