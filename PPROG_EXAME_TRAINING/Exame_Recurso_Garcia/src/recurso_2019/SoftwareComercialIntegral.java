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
public class SoftwareComercialIntegral extends SoftwareComercial implements Serializable {
    
    private static String acronimo;
    
    private double preco;

    public SoftwareComercialIntegral(String nome, String plataforma, double preco) {
        super(nome, plataforma);
        this.preco = preco;
    }

    public static String getAcronimo() {
        return acronimo;
    }

    public static void setAcronimo(String acronimo) {
        SoftwareComercialIntegral.acronimo = acronimo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String getDescricao() {
        return String.format(this.getNome(), acronimo);
    }
    
}
