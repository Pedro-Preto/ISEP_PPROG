/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recurso_2019;

import java.util.ArrayList;

/**
 *
 * @author Pedro
 */
public class TestExamePPROG {

    public static void main(String[] args) {

        CatalogoDeSoftware catalogo = new CatalogoDeSoftware();

        CatalogoFile catalogoFile = new CatalogoFile();

        boolean guardou;
        guardou = catalogo.guardarCatalogo(catalogoFile.read().obterListaDeSoftware());

        SoftwareAberto softA = new SoftwareAberto("Nome A", "Plat A", "Lic A");
        SoftwareComercialExperimental softE = new SoftwareComercialExperimental("Nome C", "Plat C", false);
        SoftwareComercialIntegral softI = new SoftwareComercialIntegral("Nome B", "Plat B", 15);

        catalogo.adicionarSofware(softA);
        catalogo.adicionarSofware(softE);
        catalogo.adicionarSofware(softI);

        ArrayList<Software> catalogoCompleto = catalogo.obterListaDeSoftware();

        System.out.println("======== Catalogo Completo ========");
        for (Software software : catalogoCompleto) {
            System.out.println(software);
        }

        System.out.println("===================================");

        ArrayList<Software> catalogoExperimental = catalogo.obterListaDeSoftwareExperimentar();

        System.out.println("====== Catalogo Experimental ======");
        for (Software software : catalogoExperimental) {
            System.out.println(software);
        }

        catalogoFile.save(catalogo);

    }

}
