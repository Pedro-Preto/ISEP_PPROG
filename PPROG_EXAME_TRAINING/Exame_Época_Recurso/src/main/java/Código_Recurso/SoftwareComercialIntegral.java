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
public class SoftwareComercialIntegral extends SoftwareComercial implements Serializable {

    private int preco;
    private static String acronimo;

    public SoftwareComercialIntegral(int preco, String nomeEmpresa, int duracaoLicença, String nome, String Plataforma) {
        super(nomeEmpresa, duracaoLicença, nome, Plataforma);
        this.preco = preco;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public static String getAcronimo() {
        return acronimo;
    }

    public static void setAcronimo(String acronimo) {
        SoftwareComercialIntegral.acronimo = acronimo;
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
        final SoftwareComercialIntegral other = (SoftwareComercialIntegral) obj;
        if (this.preco != other.preco) {
            return false;
        }
        return true;
    }

    @Override
    public String getDescricao() {
        return String.format("<s%>:<s%>", super.getNome(), acronimo);
    }

   

}
