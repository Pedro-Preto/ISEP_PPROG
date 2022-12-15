package Código_Recurso;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pedro
 */
public class SoftwareComercialExperimental extends SoftwareComercial implements Serializable  {

    private boolean publicidade;
    private static String acronimo;

    public SoftwareComercialExperimental(boolean publicidade, String nomeEmpresa, int duracaoLicença, String nome, String Plataforma) {
        super(nomeEmpresa, duracaoLicença, nome, Plataforma);
        this.publicidade = publicidade;
    }

    public boolean isPublicidade() {
        return publicidade;
    }

    public void setPublicidade(boolean publicidade) {
        this.publicidade = publicidade;
    }

    public static String getAcronimo() {
        return acronimo;
    }

    public static void setAcronimo(String acronimo) {
        SoftwareComercialExperimental.acronimo = acronimo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SoftwareComercialExperimental other = (SoftwareComercialExperimental) obj;
        if (this.publicidade != other.publicidade) {
            return false;
        }
        return true;
    }

    @Override
    public String getDescricao() {
        return String.format("<s%>:<s%>", super.getNome(), acronimo);

    }

}
