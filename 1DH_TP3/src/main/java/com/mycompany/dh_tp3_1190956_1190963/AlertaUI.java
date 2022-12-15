package com.mycompany.dh_tp3_1190956_1190963;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

/**
 * Apresenta ao utilizar uma caixa de confirmacao
 * @author pedro
 */
public class AlertaUI {

    /** 
     * Cria um alerta para apresentar ao utilizador
     * @param tipoAlerta - identifica o tipo de alerta a mostrar
     * @param titulo - titulo da caixa de cnfirmacao a apresentar
     * @param cabecalho - cabecalho principal da caixa de confirmacao
     * @param mensagem - corpo da mensagem da caixa de confirmacao
     * @return o alerta a gerar
     */
    public static Alert criarAlerta(Alert.AlertType tipoAlerta, String titulo, String cabecalho, String mensagem) {
        Alert alerta = new Alert(tipoAlerta);
        
        alerta.setTitle(titulo);
        alerta.setHeaderText(cabecalho);
        alerta.setContentText(mensagem);
        
        if (tipoAlerta == Alert.AlertType.CONFIRMATION) {
            ((Button) alerta.getDialogPane().lookupButton(ButtonType.OK)).setText("Sim");
            ((Button) alerta.getDialogPane().lookupButton(ButtonType.CANCEL)).setText("Não");
        }
        
        return alerta;
    }
}
