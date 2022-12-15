package com.mycompany.dh_tp3_1190956_1190963;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Interface principal da aplicacao que inicia todo o processo e carrega a interface da pagina inicial da aplicacao
 * @author pedro
 */
public class MainApp extends Application {

    /**
     * Identifica o titulo da aplicacao desenvolvida
     */
    public static final String TITULO_APLICACAO = "Seriar Anuncios";

    @Override
    public void start(Stage stage) throws Exception {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PaginaInicial.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            stage.setTitle(TITULO_APLICACAO);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();

        } catch (FileNotFoundException ex) {
            AlertaUI.criarAlerta(Alert.AlertType.ERROR, MainApp.TITULO_APLICACAO, "Erro", ex.getMessage());
        } catch (IOException ex) {
            AlertaUI.criarAlerta(Alert.AlertType.ERROR, TITULO_APLICACAO,
                    "Problemas no arranque da aplicação.", ex.getMessage()).show();
        }
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
