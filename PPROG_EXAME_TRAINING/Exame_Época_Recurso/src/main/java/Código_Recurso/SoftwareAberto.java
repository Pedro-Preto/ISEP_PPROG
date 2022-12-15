/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Código_Recurso;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author pedro
 */
public class SoftwareAberto extends Software implements Serializable {

    private String tipoLicenca;
    private static String acronimo;

    public SoftwareAberto(String tipoLicenca, String nome, String Plataforma) {
        super(nome, Plataforma);
        this.tipoLicenca = tipoLicenca;
    }

    public String getTipoLicenca() {
        return tipoLicenca;
    }

    public void setTipoLicenca(String tipoLicenca) {
        this.tipoLicenca = tipoLicenca;
    }

    public static String getAcronimo() {
        return acronimo;
    }

    public static void setAcronimo(String acronimo) {
        SoftwareAberto.acronimo = acronimo;
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
        final SoftwareAberto other = (SoftwareAberto) obj;
        if (!Objects.equals(this.tipoLicenca, other.tipoLicenca)) {
            return false;
        }
        return true;
    }

    @Override
    public String getDescricao() {
        return String.format("<s%>:<s%>", super.getNome(), acronimo);
    }
    
}
