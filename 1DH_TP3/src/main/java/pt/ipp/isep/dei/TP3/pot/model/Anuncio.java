/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.TP3.pot.model;

import java.util.Objects;

/**
 * Classe a qual esta associada uma candidatura
 * @author pedro
 */
public class Anuncio {
    
    private String codigo;
    private Tarefa tarefa;

    /**
     * Construtor da classe
     * @param codigo - codigo que identifica de forma unica o anuncio
     * @param tarefa - tarefa associada a esse codigo de anuncio
     */
    public Anuncio(String codigo, Tarefa tarefa) {
       this.codigo = codigo;
        this.tarefa = tarefa;
    }

    /**
     * Retorna o valor, em string, do codigo do anuncio
     * @return o codigo do anuncio
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Atualiza o codigo do anuncio
     * @param codigo - codigo do anuncio
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Retorna a tarefa referente a tarefa do anuncio
     * @return a tarefa do anuncio
     */
    public Tarefa getTarefa() {
        return tarefa;
    }

    /**
     * Atualiza a tarefa associada ao anuncio
     * @param tarefa - nova tarefa do anuncio
     */
    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }
    
    /**
     * Retorna o valor, em string, do nome da tarefa do anuncio
     * @return o nome da tarefa do anuncio
     */
    public String getNomeTarefa(){
        return tarefa.getDesignacao();
    }

    @Override
    public String toString() {
        return String.format("Anuncio-Codigo:%s,Tarefa:%s", codigo, tarefa);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Anuncio)) return false;
        Anuncio anuncio = (Anuncio) o;
        return Objects.equals(codigo, anuncio.codigo) && Objects.equals(tarefa, anuncio.tarefa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, tarefa);
    }
}
