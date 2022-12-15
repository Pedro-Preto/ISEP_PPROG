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
public class TestExamePPROG  {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        CatalogoDeSoftware catalogo = new CatalogoDeSoftware();
        CatalogoFile catFile = new CatalogoFile();

        boolean saved;
        saved = catalogo.guardarCatalogo(catFile.read().obterListaDeSoftware());

        SoftwareAberto softA = new SoftwareAberto("Nome A", "Plat A", "Lic A");
        SoftwareComercialExperimental softE = new SoftwareComercialExperimental(false, "Nome1", 2, "Soft1", "Pat2");
        SoftwareComercialIntegral softI = new SoftwareComercialIntegral(12, "Nome2", 2, "Soft2", "Plat2");

        catalogo.adicionarSoftware(softA);
        catalogo.adicionarSoftware(softE);
        catalogo.adicionarSoftware(softI);
        
        ArrayList<Software> catalogoCompleto = catalogo.obterListaDeSoftware();
     
        System.out.println("======== Catalogo Completo ========");
        for (Software software : catalogoCompleto) {
            System.out.println(software);
        }

        System.out.println("===================================");

        ArrayList<Software> catalogoExperimental = catalogo.obterListaDeSoftwareExperimentavel();

        System.out.println("====== Catalogo Experimental ======");
        for (Software software : catalogoExperimental) {
            System.out.println(software);
        }

        catFile.save(catalogo);

    }

}
