/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author topel
 */
public class Endereco {

    private String nomeRua;
    private int codigoPostal;
    private String localidade;

    private final static String NOME_RUA_POR_OMISSAO = "nao especificado";
    private final static int CODIGO_POSTAL_POR_OMISSAO = 0;
    private final static String LOCALIDADE_POR_OMISSAO = "nao especificado";

    public Endereco(String nomeRua, int codigoPostal, String localidade) {
        this.nomeRua = nomeRua;
        this.codigoPostal = codigoPostal;
        this.localidade = localidade;
    }

    public Endereco() {
        this.nomeRua = NOME_RUA_POR_OMISSAO;
        this.codigoPostal = CODIGO_POSTAL_POR_OMISSAO;
        this.localidade = LOCALIDADE_POR_OMISSAO;
    }

 
    public void setNomeRua(String nomeRua) {
        this.nomeRua = nomeRua;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getNomeRua() {
        return nomeRua;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public String getLocalidade() {
        return localidade;
    }

    @Override
    public String toString() {
        return this.nomeRua + " ( " + this.codigoPostal + " " + this.localidade + " ) ";
    }
    
    
}
