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
import pt.ipp.isep.dei.TP3.pot.model.Candidatura;

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
 * Interface que apresenta a lista de candidaturas associadas a um determinado anuncio
 * @author pedro
 */
public class ListaCandidaturasUI implements Initializable {

    private SeriarAnunciosController appController;
    private Stage listaSeriacoesStage;
    private FXMLLoader loader;
    private Parent root;
    
    private ListaAnunciosUI listaAnunciosUI;
    @FXML
    private Button voltarAtrasBtn;
    @FXML
    private Button seriarBtn;
    @FXML
    private ListView<String> listaDeCandidaturas;
    
    String codigoAnuncio;
    /**
     * https://docs.oracle.com/javase/8/javafx/api/javafx/fxml/Initializable.html
     * Inicializa a 'controller class' depois do seu elemento raiz ser totalmente processado
     * @param url - o local usado para resolver caminhos relativos para o objeto raiz (ou nulo se o local não for conhecido)
     * @param rb - os recursos usados ​​para localizar o objeto raiz (ou nulo se o objeto raiz não foi localizado)
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            loader = new FXMLLoader(getClass().getResource("/fxml/ListaSeriacoes.fxml"));
            root = loader.load();
            
             Scene scene = new Scene(root);
            
            listaSeriacoesStage = new Stage();
            listaSeriacoesStage.initModality(Modality.APPLICATION_MODAL);
            listaSeriacoesStage.setTitle("Lista Seriacoes");
            listaSeriacoesStage.setResizable(false);
            listaSeriacoesStage.setScene(scene);
             
            appController = new SeriarAnunciosController();
            
            ListaSeriacoesUI seriacoes = loader.getController();
            seriacoes.associarParentUI(this);
            
        } catch (IOException ex) {
            Logger.getLogger(ListaCandidaturasUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    /**
     * Associa a pagina atual a anterior que lhe deu origem (ao selecionar uma linha da lista de 
	 * anuncios - anterior - e gerada na proxima pagina a lista de candidaturas referentes a esse anuncio - atual)
     * @param listaAnunciosUI - interface da qual esta pagina foi chamada
     */
    public void associarParentUI(ListaAnunciosUI listaAnunciosUI){
        this.listaAnunciosUI = listaAnunciosUI;
    }
    
    /**
     * Atualiza a lista de candidaturas de um determinado anuncio
     * @param codigoAnuncio - codigo que identifica de forma unica o anuncio 
     * @throws FileNotFoundException - indica que nao foi possivel abrir o ficheiro
     * @throws ParseException - indica que nao foi possivel realizar alguma conversao
     */
    public void atualizaListaCandidaturas(String codigoAnuncio) throws FileNotFoundException, ParseException {
        this.codigoAnuncio = codigoAnuncio;
        appController.carregarInformacao();
        ArrayList<Candidatura> candidaturas = appController.getCandidaturas();
        ArrayList<String> candidaturasString = new ArrayList<>();
        for (Candidatura candidatura : candidaturas) {
           if((candidatura.getCodigoAnuncio()).equals(codigoAnuncio)){
               candidaturasString.add("Candidato: " +candidatura.getNomeFreelancer() + "    Valor Pretendido: " +candidatura.getValorPretendido() +"   Data: " +(candidatura.getDataCandidatura()).toString());
           }
        }
        ObservableList<String> listaCandidaturas = FXCollections.observableArrayList(candidaturasString);
        listaDeCandidaturas.setItems(listaCandidaturas);
    }
    
	/**
     * Esconde a janela atual 
     * @param event - evento gerado quando se clica no botao de voltar para tras
     */
    @FXML
    private void handleVoltarAtrasBtnAction(ActionEvent event) {
        ((Node)event.getSource()).getScene().getWindow().hide();
    }
	
	/**
     * Mostra a proxima janela (interface da lista de seriacoes)
     * @param event - evento gerado quando se clica no botao de seriar
     * @throws FileNotFoundException - indica que nao foi possivel abrir o ficheiro
     * @throws ParseException - indica que nao foi possivel realizar alguma conversao
     */
    @FXML
    private void handleSeriarBtnAction(ActionEvent event) throws FileNotFoundException, ParseException {
        
        ListaSeriacoesUI seriacoes = loader.getController();
        seriacoes.atualizaListaSeriacoes(codigoAnuncio);
        listaSeriacoesStage.show();
    }

}
