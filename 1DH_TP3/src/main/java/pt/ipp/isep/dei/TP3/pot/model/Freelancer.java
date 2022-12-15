/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.TP3.pot.model;

import java.util.Objects;

/**
 * Classe que representa um freelancer de uma candidatura da aplicacao
 * @author pedro
 */
public class Freelancer {
    
    private String nome;
    private String nif;
    private String telefone;
    private String email;

    /**
     * Construtor da classe
     * @param nome - nome do freelancer
     * @param nif - numero de identificacao fiscal do freelancer (identifica este de forma unica)
     * @param telefone - numero de telefone do freelancer
     * @param email - email do freelancer
     */
    public Freelancer(String nome, String nif, String telefone, String email) {
        this.nome = nome;
        this.nif = nif;
        this.telefone = telefone;
        this.email = email;
    }

    /**
     * Retorna o valor, em string, do nome do freelancer
     * @return o nome do freelancer
     */
    public String getNome() {
        return nome;
    }

    /**
     * Atualiza o nome do freelancer
     * @param nome - novo nome do freelancer
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o valor, em string, do numero de identificacao fiscal do freelancer
     * @return o NIF do freelancer
     */
    public String getNif() {
        return nif;
    }

    /**
     * Atualiza o numero de identificacao fiscal do freelancer
     * @param nif - novo NIF do freelancer
     */
    public void setNif(String nif) {
        this.nif = nif;
    }

    /**
     * Retorna o valor, em string, do numero de telefone do freelancer
     * @return o numero de telefone do freelancer
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Atualiza o numero de telefone do freelancer
     * @param telefone - novo numero de telefone do freelancer
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Retorna o valor, em string, do email do freelancer
     * @return o email do freelancer
     */
    public String getEmail() {
        return email;
    }

    /**
     * Atualiza o email do freelancer
     * @param email - novo email do freelancer
     */
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("Freelancer-Nome:%s,NIF-%s,Telefone:%s,email:%s",nome,nif,telefone,email);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Freelancer)) return false;
        Freelancer that = (Freelancer) o;
        return Objects.equals(nome, that.nome) && Objects.equals(nif, that.nif) && Objects.equals(telefone, that.telefone) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, nif, telefone, email);
    }
}
