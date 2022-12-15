/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recurso_2019;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Pedro
 */
public class CatalogoDeSoftware implements Serializable {

    private ArrayList<Software> catalogo;

    public CatalogoDeSoftware() {

        catalogo = new ArrayList<>();
    }
    
    public boolean adicionarSofware(Software newSoftware) {
/*
        if (catalogo.contains(newSoftware)) {
            return false;
        } else {
            catalogo.add(newSoftware);
            return true;
        }*/

        boolean copia = true;
        for (Software software : catalogo) {
            if (software.getClass() == (newSoftware.getClass()) && software.getDescricao().equals(newSoftware.getDescricao()) ) {
                copia = false;
            }
        }
        if (copia == true) {
            catalogo.add(newSoftware);
        }
        return copia;
    }

    public ArrayList<Software> obterListaDeSoftware() {
        ArrayList<Software> catalogoOrdenado = Software.ordenar(catalogo);
        return catalogoOrdenado;
    }

    public ArrayList<Software> obterListaDeSoftwareExperimentar() {
        ArrayList<Software> catalogoExperimental = new ArrayList<>();
        for (Software software : catalogo) {
            if (software instanceof SoftwareComercialExperimental) {
                catalogoExperimental.add(software);
            }
        }
        return catalogoExperimental;
    }

    public boolean guardarCatalogo(ArrayList<Software> catalogo) {
        this.catalogo = catalogo;
        return true;
    }

}
