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
public class SoftwareComercialExperimental extends SoftwareComercial implements Serializable {
    
    private static String acronimo;
    
    private boolean publicidade;

    public SoftwareComercialExperimental(String nome, String plataforma, boolean publicidade) {
        super(nome, plataforma);
        this.publicidade = publicidade;
    }

    public static String getAcronimo() {
        return acronimo;
    }

    public static void setAcronimo(String acronimo) {
        SoftwareComercialExperimental.acronimo = acronimo;
    }

    public boolean isPublicidade() {
        return publicidade;
    }

    public void setPublicidade(boolean publicidade) {
        this.publicidade = publicidade;
    }

    @Override
    public String getDescricao() {
        return String.format(this.getNome(), acronimo);
    }
    
}
