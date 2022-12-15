/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.TP3.pot.model;

import java.util.Date;
import java.util.Objects;

/**
 * Classe que representa uma candidatura da aplicacao
 * @author pedro
 */
public class Candidatura {
        
    private Freelancer freelancer;
    private Anuncio anuncio;
    private Date dataCandidatura;
    private Double valorPretendido;
    private Double media;
    private Double desvio;
        
    /**
     * Construtor da classe
     * @param freelancer - freelancer associado a candidatura
     * @param anuncio - anuncio associado a candidatura
     * @param dataCandidatura - data em que se realizou a condidatura
     * @param valorPretendido - valor pretendido da candidatura
     */
    public Candidatura(Freelancer freelancer, Anuncio anuncio,Date dataCandidatura, Double valorPretendido) {
        this.freelancer = freelancer;
        this.anuncio = anuncio;
        this.dataCandidatura = dataCandidatura;
        this.valorPretendido = valorPretendido;
    }

    /**
     * Retorna o freelancer referente a candidatura
     * @return o freelancer da candidatura
     */
    public Freelancer getFreeLancer() {
        return freelancer;
    }
	
    /**
     * Retorna o nome do freelancer referente a candidatura
     * @return o nome do freelancer da candidatura
     */
    public String getNomeFreelancer(){
        return freelancer.getNome();
    }

    /**
     * Atualiza o freelancer associado a candidatura
     * @param freelancer - novo freelancer da candidatura
     */
    public void setFreeLancer(Freelancer freelancer) {
        this.freelancer = freelancer;
    }

    /**
     * Retorna o anuncio referente a candidatura
     * @return o anuncio da candidatura
     */
    public Anuncio getAnuncio() {
        return anuncio;
    }
	 
    /**
     * Retorna o nome do anuncio referente a candidatura
     * @return o nome anuncio da candidatura
     */
    public String getCodigoAnuncio(){
       return anuncio.getCodigo();
    }

    /**
     * Atualiza o anuncio associado a candidatura
     * @param anuncio - novo anuncio da candidatura
     */
    public void setAnuncio(Anuncio anuncio) {
        this.anuncio = anuncio;
    }

    /**
     * Retorna a data referente a candidatura
     * @return a data da candidatura
     */
    public Date getDataCandidatura() {
        return dataCandidatura;
    }

    /**
     * Atualiza a data da candidatura
     * @param dataCandidatura - nova data da candidatura
     */
    public void setDataCandidatura(Date dataCandidatura) {
        this.dataCandidatura = dataCandidatura;
    }

    /**
     * Retorna o valor do valor pretendido da candidatura
     * @return do valor pretendido da candidatura
     */
    public Double getValorPretendido() {
        return valorPretendido;
    }

    /**
     * Atualiza o valor pretendido da candidatura
     * @param valorPretendido - novo valor pretendido
     */
    public void setValorPretendido(Double valorPretendido) {
        this.valorPretendido = valorPretendido;
    }
       
    /**
     * Retorna o valor da media da candidatura
     * @return da media da candidatura
     */
    public Double getMedia(){
        return media;
    }
	
	/**
     * Atualiza a media do grau de proficiencia da candidatura
     * @param media - nova media da candidatura
     */
    public void setMedia(Double media){
        this.media = media;
    }
    
    /**
     * Retorna o valor do desvio da candidatura
     * @return o desvio do grau de proficiencia da candidatura
     */
    public Double getDesvio(){
        return desvio;
    }
	
	/**
     * Atualiza o valor do desvio da candidatura
     * @param desvio - desvio do grau de proficiencia da candidatura
     */
    public void setDesvio(Double desvio){
        this.desvio = desvio;
    }

    @Override
    public String toString() {
        return String.format("Candidatura-Freelancer:%s,Anuncio:%s,DataCadidatura:%s,ValorPretendido:%s,Média:%s,Desvio:%s",freelancer,anuncio,dataCandidatura,valorPretendido,media,desvio);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Candidatura)) return false;
        Candidatura that = (Candidatura) o;
        return Objects.equals(freelancer, that.freelancer) && Objects.equals(anuncio, that.anuncio) && Objects.equals(dataCandidatura, that.dataCandidatura) && Objects.equals(valorPretendido, that.valorPretendido) && Objects.equals(media, that.media) && Objects.equals(desvio, that.desvio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(freelancer, anuncio, dataCandidatura, valorPretendido, media, desvio);
    }
}
