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
public abstract class SoftwareComercial extends Software implements Serializable {
    
    private String empresa;
    private int duracao;

    public SoftwareComercial(String nome, String plataforma) {
        super(nome, plataforma);
    }

    @Override
    public abstract String getDescricao();

    
}
