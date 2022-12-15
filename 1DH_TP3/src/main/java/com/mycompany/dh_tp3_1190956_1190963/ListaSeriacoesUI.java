/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dh_tp3_1190956_1190963;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pt.ipp.isep.dei.TP3.pot.controller.SeriarAnunciosController;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * FXML Controller class
 * Interface que apresenta ao utilizador os tipos de seriacao pelos quais pode ordenar as condidaturas associadas a um anuncio
 * @author pedro
 */
public class ListaSeriacoesUI implements Initializable {

    private SeriarAnunciosController appController;
    private Stage listaCandidaturasSeriadasStage;
    private FXMLLoader loader;
    private Parent root;
    private ListaCandidaturasUI listaCandidaturasUI;

    @FXML
    private Button voltarAtrasBtn;
    @FXML
    private Button confirmarBtn;
    @FXML
    private ListView<String> listaDeSeriacoes;
    private String codigoAnuncio;

    /**
     * https://docs.oracle.com/javase/8/javafx/api/javafx/fxml/Initializable.html
     * Inicializa a 'controller class' depois do seu elemento raiz ser totalmente processado
     * @param url - o local usado para resolver caminhos relativos para o objeto raiz (ou nulo se o local não for conhecido)
     * @param rb - os recursos usados ​​para localizar o objeto raiz (ou nulo se o objeto raiz não foi localizado)
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            confirmarBtn.disableProperty().bind(listaDeSeriacoes.getSelectionModel().selectedItemProperty().isNull());

            loader = new FXMLLoader(getClass().getResource("/fxml/ListaCandidaturasSeriadas.fxml"));
            root = loader.load();

            Scene scene = new Scene(root);

            listaCandidaturasSeriadasStage = new Stage();
            listaCandidaturasSeriadasStage.initModality(Modality.APPLICATION_MODAL);
            listaCandidaturasSeriadasStage.setTitle("Lista Candidaturas Seriadas");
            listaCandidaturasSeriadasStage.setResizable(false);
            listaCandidaturasSeriadasStage.setScene(scene);

            appController = new SeriarAnunciosController();
            atualizaListaSeriacoes(codigoAnuncio);

            ListaCandidaturasSeriadasUI candidaturasSeriadas = loader.getController();
            candidaturasSeriadas.associarParentUI(this);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ListaSeriacoesUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ListaSeriacoesUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ListaSeriacoesUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

	/**
     * Associa a pagina atual a anterior que lhe deu origem (ao escolher que se pretende seriar as candidaturas de 
	 * um anuncio - anterior - e gerada na proxima pagina a lista de todos tipos de seriacao possiveis - atual)
     * @param listaCandidaturasUI - interface da qual esta pagina foi chamada
     */
    void associarParentUI(ListaCandidaturasUI listaCandidaturasUI) {
        this.listaCandidaturasUI = listaCandidaturasUI;
    }

    /**
     * Atualiza a lista de tipos de seriacoes possiveis de escolher
     * @param codigoAnuncio - codigo que identifica de forma unica o anuncio 
     * @throws FileNotFoundException - indica que nao foi possivel abrir o ficheiro
     * @throws ParseException - indica que nao foi possivel realizar alguma conversao
     */
    public void atualizaListaSeriacoes(String codigoAnuncio) throws FileNotFoundException, ParseException {
        this.codigoAnuncio = codigoAnuncio;
        ArrayList<String> seriacoesString = new ArrayList<>();
        seriacoesString.add("Seriacao: 1" + "   Descricao: " + "Maior media de niveis de proficiencia, preco mais baixo, candidatura mais antiga");
        seriacoesString.add("Seriacao: 2" + "   Descricao: " + "Maior media de niveis de proficiencia, menor desvio padrao de niveis de proficiencia, preco mais baixo, candidatura mais antiga");
        ObservableList<String> listaSeriacoes = FXCollections.observableArrayList(seriacoesString);
        listaDeSeriacoes.setItems(listaSeriacoes);
    }

    /**
     * Esconde a janela atual 
     * @param event - evento gerado quando se clica no botao de voltar para tras
     */
    @FXML
    public void handleVoltarAtrasBtnAction(ActionEvent event) {
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    /**
     * Mostra a proxima janela (interface da lista de candidaturas seriadas)
     * @param event - evento gerado quando se clica no botao de confirmar
     * @throws FileNotFoundException - indica que nao foi possivel abrir o ficheiro
     * @throws ParseException - indica que nao foi possivel realizar alguma conversao
     */
    @FXML
    public void handleConfirmarBtnAction(ActionEvent event) throws FileNotFoundException, ParseException {
        appController.carregarInformacao();
        String[] aux = listaDeSeriacoes.getSelectionModel().getSelectedItem().split(" ");
        String codigoSeriacao = aux[1];

        ListaCandidaturasSeriadasUI candidaturasSeriadas = loader.getController();
        candidaturasSeriadas.atualizaListaCandidaturas(codigoAnuncio, Integer.parseInt(codigoSeriacao));
        listaCandidaturasSeriadasStage.show();
    }

}
