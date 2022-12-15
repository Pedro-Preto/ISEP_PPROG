/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.TP3.pot.model;

import java.util.Objects;

/**
 * Classe que define uma competencia tecnica, relativa a um freelancer ou a uma tarefa
 * @author pedro
 */
public class CompetenciaTecnica {
    
    private String codigo;
    private String nome;

    /**
     * Construtor da classe
     * @param codigo - codigo que identifica de forma unica a competencia tecnica 
     * @param nome - nome que descreve a competencia tecnica
     */
    public CompetenciaTecnica(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    /**
     * Retorna o valor, em string, do codigo da competencia tecnica
     * @return o codigo da competencia tecnica
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Atualiza o codigo que identifica a competencia tecnica
     * @param codigo - novo codigo da competencia tecnica
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Retorna o valor, em string, do nome da competencia tecnica
     * @return o nome da competencia tecnica
     */
    public String getNome() {
        return nome;
    }

    /**
     * Atualiza o nome da competencia tecnica
     * @param nome - novo nome da competencia tecnica
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return String.format("CompetenciaTecnica-Codigo:%s,Nome:%s",codigo,nome);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompetenciaTecnica)) return false;
        CompetenciaTecnica that = (CompetenciaTecnica) o;
        return Objects.equals(codigo, that.codigo) && Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nome);
    }
}
