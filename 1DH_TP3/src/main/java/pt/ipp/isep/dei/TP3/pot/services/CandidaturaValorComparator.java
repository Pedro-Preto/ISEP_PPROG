/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.TP3.pot.services;

import pt.ipp.isep.dei.TP3.pot.model.Candidatura;

import java.util.Comparator;

/** 
 * Ordena segundo a valor pretendido da candidatura, do menor para o maior
 * @author pedro
 */
public class CandidaturaValorComparator implements Comparator<Candidatura> {

    @Override
    public int compare(Candidatura c1, Candidatura c2) {
        return c1.getValorPretendido().compareTo(c2.getValorPretendido());
    }
}
