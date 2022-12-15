/*
 * To change this license header, choose License Headers in Project Properties.
*  To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.TP3.pot.model;

import java.util.Objects;

/**
 * Classe que representa uma tarefa de um anuncio da aplicacao
 * @author pedro
 */
public class Tarefa {

    private String codigo;
    private String designacao;
    private String categoria;    

    /**
     * Construtor da classe
     * @param codigo - codigo que identifica de forma unica a tarefa
     * @param designacao - designacao da tarefa
     * @param categoria - categoria da tarefa
     */
    public Tarefa(String codigo, String designacao, String categoria) {
        this.codigo = codigo;
        this.designacao = designacao;
        this.categoria = categoria;
    }

    /**
     * Retorna o valor, em string, do codigo da tarefa
     * @return o codigo da tarefa
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Atualiza o codigo da tarefa
     * @param codigo - novo codigo da tarefa
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Retorna o valor, em string, da designacao da tarefa
     * @return a designacao da tarefa
     */
    public String getDesignacao() {
        return designacao;
    }

    /**
     * Atualiza a designacao da tarefa
     * @param designacao - nova designacao da tarefa
     */
    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    /**
     * Retorna o valor, em string, da categoria da tarefa
     * @return a categoria da tarefa
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Atualiza a categoria da tarefa
     * @param categoria - nova categoria da tarefa
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return String.format("Tarefa-Codigo:%s,Designação:%s,Categoria:%s",codigo,designacao,categoria);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tarefa)) return false;
        Tarefa tarefa = (Tarefa) o;
        return Objects.equals(codigo, tarefa.codigo) && Objects.equals(designacao, tarefa.designacao) && Objects.equals(categoria, tarefa.categoria);
    }


}
