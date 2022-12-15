/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Código_Recurso;

import java.io.Serializable;

/**
 *
 * @author pedro
 */
public abstract class SoftwareComercial extends Software implements Serializable  {

    private String nomeEmpresa;
    private int duracaoLicença;

    public SoftwareComercial(String nomeEmpresa, int duracaoLicença, String nome, String Plataforma) {
        super(nome, Plataforma);
        this.nomeEmpresa = nomeEmpresa;
        this.duracaoLicença = duracaoLicença;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public int getDuracaoLicença() {
        return duracaoLicença;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public void setDuracaoLicença(int duracaoLicença) {
        this.duracaoLicença = duracaoLicença;
    }

    @Override
    public abstract String getDescricao() ;
    

}
