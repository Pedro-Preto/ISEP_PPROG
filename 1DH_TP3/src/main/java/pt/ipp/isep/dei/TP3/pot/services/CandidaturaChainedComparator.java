/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.TP3.pot.services;

import pt.ipp.isep.dei.TP3.pot.model.Candidatura;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/** 
 * Permite ordenar uma lista por criterios com diferentes prioridades
 * @author pedro
 */
public class CandidaturaChainedComparator implements Comparator<Candidatura> {

    private List<Comparator<Candidatura>> listComparators;
    
    /** 
     * Construtor da classe
     * @param comparators - sequencia das comparacoes encadeadas a realizar
     */
    public CandidaturaChainedComparator(Comparator<Candidatura>... comparators) {
        this.listComparators = Arrays.asList(comparators);
    }

    @Override
    public int compare(Candidatura c1, Candidatura c2) {
        for (Comparator<Candidatura> comparator : listComparators) {
            int result = comparator.compare(c1, c2);
            if (result != 0) {
                return result;
            }
        }
        return 0;
    }
}

