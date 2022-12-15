/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author topel
 */
public class Automovel implements  Alugavel, Vendavel {

    private String marca;
    private String modelo;
    private double valorVenda;
    private double valorAluguer;

    private static final String MARCA_POR_OMISSAO = "nao especificado";
    private static final String MODELO_POR_OMISSAO = "nao especificado";
    private static final double VALOR_VENDA_POR_OMISSAO = 0;
    private static final double VALOR_ALUGUER_POR_OMISSAO = 0;

    public Automovel(String marca, String modelo, double valorVenda, double valorAluguer) {
        this.marca = marca;
        this.modelo = modelo;
        this.valorVenda = valorVenda;
        this.valorAluguer = valorAluguer;
    }

    public Automovel() {
        this.marca = MARCA_POR_OMISSAO;
        this.modelo = MODELO_POR_OMISSAO;
        this.valorVenda = VALOR_VENDA_POR_OMISSAO;
        this.valorAluguer = VALOR_ALUGUER_POR_OMISSAO;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public void setValorAluguer(double valorAluguer) {
        this.valorAluguer = valorAluguer;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public double getValorAluguer() {
        return valorAluguer;
    }

    @Override
    public double getValorAluguerComTaxa() {
        return getValorAluguer() * (1 + taxaAlugavel);
    }

    @Override
    public double getValorVendaComTaxa() {
        return getValorVenda() * (1 + taxaVendavel);
    }

    @Override
    public String toString() {
        return "Automovel: " + marca + "/" + modelo;
    }

    
    
}
