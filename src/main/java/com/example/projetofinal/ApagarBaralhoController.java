package com.example.projetofinal;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ApagarBaralhoController implements Initializable {
    @FXML
    Button regressa;
    @FXML
    TableView<Baralho> tabela;
    @FXML
    TableColumn<Baralho,String> colunaNome;
    @FXML
    TableColumn<Baralho,Integer> colunaCartas;





    @FXML
    protected void aoClicarRegresso(){
        FXMLLoader fxmlLoader = new FXMLLoader(ApagarBaralhoController.class.getResource("main.fxml"));
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ///Aqui criamos uma Observable list de uma ArrayList já está a resposta no GPT

        ObservableList<Baralho> lista = Dados.encheALista();
        colunaNome.setCellValueFactory(new PropertyValueFactory<Baralho, String>("nome"));
        colunaCartas.setCellValueFactory(new PropertyValueFactory<Baralho,Integer>("numeroDeCartas"));
        tabela.setItems(lista);

        tabela.setRowFactory(tabela -> {
            TableRow<Baralho> linha = new TableRow<>();
            linha.setOnMouseClicked( evento ->{
                if(!linha.isEmpty() && evento.getButton() == MouseButton.PRIMARY && evento.getClickCount() == 1){

                    Baralho aRemover = linha.getItem();
                    ////Aqui devo pedir confirmação antes de apagar
                    Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION,"Deseja realmente apagar "+ aRemover.getNome() + "?", ButtonType.YES,ButtonType.NO,ButtonType.CANCEL);
                    confirmacao.showAndWait();
                    if(confirmacao.getResult() == ButtonType.YES){
                        lista.remove(aRemover);
                        Dados.apagaBaralho(aRemover.getNome());
                    }


                }
            });
            return linha;
        });
    }
}
