/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author topel
 */
public class Apartamento implements  Alugavel {

    private Endereco endereco;
    private double area;
    private double valorAluguer;

    private static final Endereco ENDERECO_POR_OMISSAO = new Endereco();
    private static final double AREA_POR_OMISSAO = 0;
    private static final double VALOR_ALUGUER_POR_OMISSAO = 0;

    public Apartamento(Endereco endereco, double area, double valorAluguer) {
        this.endereco = endereco;
        this.area = area;
        this.valorAluguer = valorAluguer;
    }

    public Apartamento() {
        this.endereco = ENDERECO_POR_OMISSAO;
        this.area = AREA_POR_OMISSAO;
        this.valorAluguer = VALOR_ALUGUER_POR_OMISSAO;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void setValorAluguer(double valorAluguer) {
        this.valorAluguer = valorAluguer;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public double getArea() {
        return area;
    }

    public double getValorAluguer() {
        return valorAluguer;
    }

    @Override
    public double getValorAluguerComTaxa() {
        return getValorAluguer() * (1 + taxaAlugavel);
    }
    
    @Override
    public String toString() {
        return "Apartamento: " + endereco + " / " + area;                
    }

}
