/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Código_Recurso;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author pedro
 */
public class CatalogoDeSoftware implements Serializable {

    private ArrayList<Software> soft;

    public CatalogoDeSoftware(ArrayList<Software> soft) {
        this.soft = soft;
    }

    public CatalogoDeSoftware() {
        soft = new ArrayList<>();
    }

    public boolean adicionarSoftware(Software newS) {
        boolean validade = true;
        for (Software sw : soft) {
            if (sw.getClass().equals(newS.getClass()) && sw.getDescricao().equals(newS.getDescricao())) {
                validade = false;
            }
        }
        if (validade == true) {
            soft.add(newS);

        }
        return validade;

    }

    public ArrayList<Software> obterListaDeSoftware() {
        ArrayList<Software> replicaListSoftwareOrdenado = Software.ordenar(soft);
        return replicaListSoftwareOrdenado;
    }

    public ArrayList<Software> obterListaDeSoftwareExperimentavel() {
        ArrayList<Software> listGratuito = new ArrayList<>();
        for (Software software : soft) {
            if (software instanceof SoftwareComercialExperimental) {
                listGratuito.add(software);
            }
        }
        return listGratuito;
    }

    public boolean guardarCatalogo(ArrayList<Software> soft) {
        this.soft = soft;
        return true;
    }
    
}
