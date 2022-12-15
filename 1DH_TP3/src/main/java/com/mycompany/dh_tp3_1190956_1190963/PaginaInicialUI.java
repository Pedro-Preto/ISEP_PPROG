package com.mycompany.dh_tp3_1190956_1190963;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pt.ipp.isep.dei.TP3.pot.controller.SeriarAnunciosController;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;

/**
 * Interface que apresenta a pagina inicial da aplicacao
 * @author pedro
 */
public class PaginaInicialUI implements Initializable {

    private SeriarAnunciosController appController;
    private Stage listaAnunciosStage;
    private FXMLLoader loader;
    private Parent root;
    @FXML
    private Button VisAnunciosBtn; // mudar na interface o nome <--
    @FXML
    private Label underVisTarefaLabel;

	/**
	 * https://docs.oracle.com/javase/8/javafx/api/javafx/fxml/Initializable.html
     * Inicializa a 'controller class' depois do seu elemento raiz ser totalmente processado
     * @param url - o local usado para resolver caminhos relativos para o objeto raiz (ou nulo se o local não for conhecido)
     * @param rb - os recursos usados ​​para localizar o objeto raiz (ou nulo se o objeto raiz não foi localizado)
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
		// Inicializa a propria pagina e atribui as caracteristicas da proxima
        try {
            loader = new FXMLLoader(getClass().getResource("/fxml/ListaAnuncios.fxml"));
            root = loader.load();

            Scene scene = new Scene(root);

            listaAnunciosStage = new Stage();
            listaAnunciosStage.initModality(Modality.APPLICATION_MODAL);
            listaAnunciosStage.setTitle("Escolher Anuncio");
            listaAnunciosStage.setResizable(false);
            listaAnunciosStage.setScene(scene);
            

            ListaAnunciosUI anuncios = loader.getController();
            anuncios.associarParentUI(this);
        } catch (FileNotFoundException ex) {
            AlertaUI.criarAlerta(Alert.AlertType.ERROR, MainApp.TITULO_APLICACAO, "Erro", ex.getMessage());
        } catch (IOException ex) {
            AlertaUI.criarAlerta(Alert.AlertType.ERROR, MainApp.TITULO_APLICACAO, "Erro", ex.getMessage());
        }
    }

	/**
     * Mostra a proxima janela (interface da lista de anuncios)
     * @param event - evento gerado quando se clica no botao de visualizar anuncios
     * @throws FileNotFoundException - indica que nao foi possivel abrir o ficheiro
     * @throws ParseException - indica que nao foi possivel realizar alguma conversao
     */
    @FXML
    private void handleVisAnunciosBtnAction(ActionEvent event) throws FileNotFoundException, ParseException {
        try {
            listaAnunciosStage.show();
        } catch (NullPointerException ex) {
            System.out.println("Null pointer exception!");
        }
    }
    
    /**
     * Obter o 'controller' da aplicacao - contem todas as informacoes necessarias para a implementacao das interfaces
     * @return o 'controller' da aplicacao
     */
    public SeriarAnunciosController getAplicacaoController(){
        return appController;
    }
}
