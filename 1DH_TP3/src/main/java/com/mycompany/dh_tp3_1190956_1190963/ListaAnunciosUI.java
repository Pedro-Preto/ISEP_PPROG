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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pt.ipp.isep.dei.TP3.pot.controller.SeriarAnunciosController;
import pt.ipp.isep.dei.TP3.pot.model.Anuncio;

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
 * Interface que apresenta a lista de todos os anuncios disponiveis 
 * @author pedro
 */
public class ListaAnunciosUI implements Initializable {

    private SeriarAnunciosController appController;
    private Stage listaCandidaturasStage;
    private FXMLLoader loader;
    private Parent root;

    private PaginaInicialUI paginaInicialUI;
    @FXML
    private Button voltarAtrasBtn;
    @FXML
    private Button confirmarBtn;
    @FXML
    private ListView<String> listaDeAnuncios;

    /**
	 * https://docs.oracle.com/javase/8/javafx/api/javafx/fxml/Initializable.html
     * Inicializa a 'controller class' depois do seu elemento raiz ser totalmente processado
     * @param url - o local usado para resolver caminhos relativos para o objeto raiz (ou nulo se o local não for conhecido)
     * @param rb - os recursos usados ​​para localizar o objeto raiz (ou nulo se o objeto raiz não foi localizado)
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            confirmarBtn.disableProperty().bind(listaDeAnuncios.getSelectionModel().selectedItemProperty().isNull());
            
            loader = new FXMLLoader(getClass().getResource("/fxml/ListaCandidaturas.fxml"));
            root = loader.load();

            Scene scene = new Scene(root);

            listaCandidaturasStage = new Stage();
            listaCandidaturasStage.initModality(Modality.APPLICATION_MODAL);
            listaCandidaturasStage.setTitle("Lista Candidaturas");
            listaCandidaturasStage.setResizable(false);
            listaCandidaturasStage.setScene(scene);

            appController = new SeriarAnunciosController();
            atualizaListaAnuncios();

            ListaCandidaturasUI candidaturas = loader.getController();
            candidaturas.associarParentUI(this);
        } catch (FileNotFoundException ex) {
            AlertaUI.criarAlerta(Alert.AlertType.ERROR, MainApp.TITULO_APLICACAO, "Erro", ex.getMessage());
        } catch (IOException ex) {
            AlertaUI.criarAlerta(Alert.AlertType.ERROR, MainApp.TITULO_APLICACAO, "Erro", ex.getMessage());
        } catch (ParseException ex) {
            Logger.getLogger(ListaAnunciosUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Atualiza a lista de anuncios a mostrar nesta interface
     * @throws FileNotFoundException - indica que nao foi possivel abrir o ficheiro
     * @throws ParseException - indica que nao foi possivel realizar alguma conversao
     */
    public void atualizaListaAnuncios() throws FileNotFoundException, ParseException {
        appController.carregarInformacao();
        ArrayList<Anuncio> anuncios = appController.getAnuncios();
        ArrayList<String> anunciosString = new ArrayList<>();
        for (Anuncio anuncio : anuncios) {
           anunciosString.add("Anuncio: " +(anuncio.getCodigo()) + "    Tarefa: " +anuncio.getNomeTarefa());
        }
        ObservableList<String> listaAnuncios = FXCollections.observableArrayList(anunciosString);
        listaDeAnuncios.setItems(listaAnuncios);
    }

    /**
     * Associa a pagina atual a anterior que lhe deu origem (ao escolher que se pretende visualizar
	 * anuncios - anterior - e gerada na proxima pagina a lista de todos os anuncios disponiveis - atual)
     * @param paginaInicialUI - interface da qual esta pagina foi chamada
     */
    public void associarParentUI(PaginaInicialUI paginaInicialUI) {
        this.paginaInicialUI = paginaInicialUI;
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
     * Mostra a proxima janela (interface da lista de candidaturas deste anuncio)
     * @param event - evento gerado quando se clica no botao de confirmar
     * @throws FileNotFoundException - indica que nao foi possivel abrir o ficheiro
     * @throws ParseException - indica que nao foi possivel realizar alguma conversao
     */
    @FXML
    public void handleConfirmarBtnAction(ActionEvent event) throws FileNotFoundException, ParseException {
        ListaCandidaturasUI candidaturas = loader.getController();
        String[] aux = listaDeAnuncios.getSelectionModel().getSelectedItem().split(" ");
        String codigoAnuncio = aux[1];
        candidaturas.atualizaListaCandidaturas(codigoAnuncio);
        listaCandidaturasStage.show();
    }
}
