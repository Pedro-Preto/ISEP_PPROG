/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.TP3.pot.services;

import pt.ipp.isep.dei.TP3.pot.model.Candidatura;

import java.util.Comparator;

/** 
 * Ordena segundo a media da candidatura, da maior para a menor
 * @author pedro
 */
public class CandidaturaMediaComparator implements Comparator<Candidatura> {

    @Override
    public int compare(Candidatura c1, Candidatura c2) {
        return c2.getMedia().compareTo(c1.getMedia());
    }
}
