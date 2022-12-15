/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.TP3.pot.services;

import pt.ipp.isep.dei.TP3.pot.controller.SeriarAnunciosController;
import pt.ipp.isep.dei.TP3.pot.model.Candidatura;

import java.util.ArrayList;

/**
 * Definicao dos metodos que qualquer tipo de seriacao deve implementar
 * @author pedro
 */
public interface TipoSeriacao {
    
    /** 
     * Seleciona e ordena as candidaturas respetivas a um determinado anuncio
     * @param codigoAnuncio - codigo do anuncio das candidaturas que devem ser listadas
     * @param dados - conjunto de todos os dados das classes da aplicacao
     * @return das candidaturas associadas ao anuncio ordenadas por criterios especificos
     */
    ArrayList<Candidatura> executa(String codigoAnuncio, SeriarAnunciosController dados);

}


