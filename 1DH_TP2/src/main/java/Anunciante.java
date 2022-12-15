
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author topel
 */
public class Anunciante {

    private String nome;
    private Endereco endereco;

    private Alugavel[] listaAlugaveis = new Alugavel[3];
    private Vendavel[] listaVendaveis = new Vendavel[2];

    private static final String NOME_POR_OMISSAO = "nao especificado";
    private static final Endereco ENDERECO_POR_OMISSAO = new Endereco();

    public Anunciante(String nome, Endereco endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public Anunciante() {
        this.nome = NOME_POR_OMISSAO;
        this.endereco = ENDERECO_POR_OMISSAO;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public int getQuantidadeAlugaveis() {
        int contador = 0;
        for (int i = 0; i < listaAlugaveis.length; i++) {
            if (null != listaAlugaveis[i]) {
                contador++;
            }
        }
        return contador;
    }

    public int getQuantidadeVendaveis() {
        int contador = 0;
        for (int i = 0; i < listaVendaveis.length; i++) {
            if (null != listaVendaveis[i]) {
                contador++;
            }
        }
        return contador;
    }

    public boolean adicionarAlugavel(Alugavel alugavel) {        
        for (int i = 0; i < listaAlugaveis.length; i++) {            
            if (listaAlugaveis[i] == null) {
                listaAlugaveis[i] = alugavel;
                return true;
            }            
        }
        return false;
    }

    public boolean adicionarVendavel(Vendavel vendavel) {
        for (int i = 0; i < listaVendaveis.length; i++) {            
            if (listaVendaveis[i] == null) {
                listaVendaveis[i] = vendavel;
                return true;
            }            
        }
        return false;
    }

    public double getValorPossivelVendas() {
        double valor = 0;
        for (int i = 0; i < listaVendaveis.length; i++) {
            if (null != listaVendaveis[i]) {
                valor +=  listaVendaveis[i].getValorVendaComTaxa();
            }
        }
        return valor;
    }
    
    public Alugavel getAlugavelMaisCaro() {
        Alugavel a = null;
        for (int i = 0; i < listaAlugaveis.length; i++) {
            if (listaAlugaveis[i] != null) {
                if (a == null) {
                    a = listaAlugaveis[i];
                } else {
                    if (listaAlugaveis[i].getValorAluguer() > a.getValorAluguer()) {
                        a =listaAlugaveis[i];
                    }                    
                }                                            
            }
        }
        return a;    
    }

}
