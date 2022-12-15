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
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import pt.ipp.isep.dei.TP3.pot.controller.SeriarAnunciosController;
import pt.ipp.isep.dei.TP3.pot.model.Candidatura;
import pt.ipp.isep.dei.TP3.pot.services.TipoSeriacao1;
import pt.ipp.isep.dei.TP3.pot.services.TipoSeriacao2;

import java.io.FileNotFoundException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 * Interface que apresenta a lista de candidaturas associadas a um determinado anuncio ordenadas por um tipo de seriacao especifico
 * @author pedro
 */
public class ListaCandidaturasSeriadasUI implements Initializable {

    private SeriarAnunciosController appController;
    private String codigoAnuncio;

    private ListaSeriacoesUI listaSeriacoesUI;
    @FXML
    private Button voltarAtrasBtn;
    @FXML
    private ListView<String> listaDeCandidaturasSeriadas;

    /**
     * https://docs.oracle.com/javase/8/javafx/api/javafx/fxml/Initializable.html
     * Inicializa a 'controller class' depois do seu elemento raiz ser totalmente processado
     * @param url - o local usado para resolver caminhos relativos para o objeto raiz (ou nulo se o local não for conhecido)
     * @param rb - os recursos usados ​​para localizar o objeto raiz (ou nulo se o objeto raiz não foi localizado)
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        appController = new SeriarAnunciosController();

    }

    /**
     * Atualiza a lista de candidaturas de um determinado anuncio ordenadas por um tipo de seriacao especifico
     * @param codigoAnuncio - codigo que identifica de forma unica o anuncio 
     * @param codigoSeriacao - codigo que identifica o tipo de seriacao a considerar (1 ou 2)
     * @throws FileNotFoundException - indica que nao foi possivel abrir o ficheiro
     * @throws ParseException - indica que nao foi possivel realizar alguma conversao
     */
    public void atualizaListaCandidaturas(String codigoAnuncio, int codigoSeriacao) throws FileNotFoundException, ParseException {
       this.codigoAnuncio = codigoAnuncio;
        appController.carregarInformacao();
        ArrayList<Candidatura> candidaturas = new ArrayList<>();
        ArrayList<String> candidaturasSeriadasString = new ArrayList<>();
        if (codigoSeriacao == 1) {
            TipoSeriacao1 tipoSeriacao = new TipoSeriacao1();
            candidaturas = tipoSeriacao.executa(codigoAnuncio, appController);
            for (Candidatura candidatura : candidaturas) {
                if (candidatura.getAnuncio().getCodigo().equals(codigoAnuncio)) {
                    candidaturasSeriadasString.add("Candidato: " + candidatura.getNomeFreelancer() + "    Valor Pretendido: " + candidatura.getValorPretendido() + "   Data: " + ((candidatura).getDataCandidatura()).toString());
                }
            }
        } else if (codigoSeriacao == 2) {
            TipoSeriacao2 tipoSeriacao = new TipoSeriacao2();
            candidaturas = tipoSeriacao.executa(codigoAnuncio, appController);
            for (Candidatura candidatura : candidaturas) {
                if (candidatura.getAnuncio().getCodigo().equals(codigoAnuncio)) {
                    candidaturasSeriadasString.add("Candidato: " + candidatura.getNomeFreelancer() + "    Valor Pretendido: " + candidatura.getValorPretendido() + "   Data: " + ((candidatura).getDataCandidatura()).toString());
                }
            }

        }

        ObservableList<String> listaCandidaturasSeriadas = FXCollections.observableArrayList(candidaturasSeriadasString);
        listaDeCandidaturasSeriadas.setItems(listaCandidaturasSeriadas); //comentado pois a seriacao ainda nao esta devidamente implementada
    }

	/**
     * Associa a pagina atual a anterior que lhe deu origem (ao escolher o tipo pelo qual se pretende seriar
	 * as candidaturas - anterior - e gerada na proxima pagina a lista das candidaturas associadas a um 
	 * anuncio segundo um tipo de seriacao escolhido - atual)
     * @param paginaInicialUI - interface da qual esta pagina foi chamada
     */
    void associarParentUI(ListaSeriacoesUI listaSeriacoesUI) {
        this.listaSeriacoesUI = listaSeriacoesUI;
    }

	/**
     * Esconde a janela atual 
     * @param event - evento gerado quando se clica no botao de voltar para tras
     */
    @FXML
    private void handleVoltarAtrasBtnAction(ActionEvent event) {
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

}
