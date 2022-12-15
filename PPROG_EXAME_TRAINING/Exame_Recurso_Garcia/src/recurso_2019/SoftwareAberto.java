/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recurso_2019;

import java.io.Serializable;

/**
 *
 * @author Pedro
 */
public class SoftwareAberto extends Software implements Serializable {

    private static String acronimo;

    private String licenca;

    public SoftwareAberto(String nome, String plataforma, String licenca) {
        super(nome, plataforma);
        this.licenca = licenca;
    }

    @Override
    public String getDescricao() {
        return String.format(this.getNome(), acronimo);
    }

    public static String getAcronimo() {
        return acronimo;
    }

    public static void setAcronimo(String acronimo) {
        SoftwareAberto.acronimo = acronimo;
    }

    public String getLicenca() {
        return licenca;
    }

    public void setLicenca(String licenca) {
        this.licenca = licenca;
    }


    
}
