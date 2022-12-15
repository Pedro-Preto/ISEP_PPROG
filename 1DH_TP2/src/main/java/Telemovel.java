/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author topel
 */
public class Telemovel implements  Vendavel {

    private String designacao;
    private double valorVenda;

    private static final String DESIGNACAO_POR_OMISSAO = "nao especificado";
    private static final double VALOR_VENDA_POR_OMISSAO = 0;

    public Telemovel(String designacao, double valorVenda) {
        this.designacao = designacao;
        this.valorVenda = valorVenda;
    }

    public Telemovel() {
        this.designacao = DESIGNACAO_POR_OMISSAO;
        this.valorVenda = VALOR_VENDA_POR_OMISSAO;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public String getDesignacao() {
        return designacao;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    @Override
    public double getValorVendaComTaxa() {
        return getValorVenda() * (1 + taxaVendavel);
    }

    @Override
    public String toString() {
        return designacao;
    }


}
