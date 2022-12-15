/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.TP3.pot.model;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * Class que associa um freelancer a uma determinada competencia tecnica (um freelancer pode ter mais do que uma 
 * competencia tecnica, bem como uma mesmo competencia tecnica pode ser partilhada por varios freelancers)
 * @author pedro
 */
public class CompetenciasTecnicasFreelancer {
    
    private Freelancer freelancer;
    private CompetenciaTecnica competenciaTecnica;
    private int grauProficiencia;

    /**
     * Construtor da classe
     * @param freelancer - representa o freelancer que se associa a uma competencia tecnica
     * @param competenciaTecnica - representa a competencia tecnica desse freelancer
     * @param grauProficiencia - quantifica o grau de proficiencia desse freelancer nesta competencia
     */
    public CompetenciasTecnicasFreelancer(Freelancer freelancer, CompetenciaTecnica competenciaTecnica, int grauProficiencia) {
        this.freelancer = freelancer;
        this.competenciaTecnica = competenciaTecnica;
        this.grauProficiencia = grauProficiencia;
    }

    /**
     * Retorna o freelancer referente a esta relacao
     * @return o freelancer
     */
    public Freelancer getFreelancer() {
        return freelancer;
    }

    /**
     * Atualiza o freelancer associado a esta relacao
     * @param freelancer - novo freelancer
     */
    public void setFreelancer(Freelancer freelancer) {
        this.freelancer = freelancer;
    }

    /**
     * Retorna a competencia tecnica referente a esta relacao
     * @return a competencia tecnica 
     */
    public CompetenciaTecnica getCompetenciaTecnica() {
        return competenciaTecnica;
    }

    /**
     * Atualiza a competencia tecnica associada a esta relacao
     * @param competenciaTecnica - nova competencia tecnica
     */
    public void setCompetenciaTecnica(CompetenciaTecnica competenciaTecnica) {
        this.competenciaTecnica = competenciaTecnica;
    }

    /**
     * Retorna o valor que quatifica o grau de proficiencia do freelancer nesta competencia tecnica
     * @return o grau de proficiencia
     */
    public int getGrauProficiencia() {
        return grauProficiencia;
    }

    /**
     * Atualiza o valor que quatifica o grau de proficiencia do freelancer nesta competencia tecnica
     * @param grauProficiencia - novo grau de proficiencia
     */
    public void setGrauProficiencia(int grauProficiencia) {
        this.grauProficiencia = grauProficiencia;
    }

    @Override
    public String toString() {
        return String.format("CompetenciasTecnicasFreelancer-Freelancer:%s,CompetenciaTecnica:%s,GrauProficiencia:%s",freelancer,competenciaTecnica,grauProficiencia);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompetenciasTecnicasFreelancer)) return false;
        CompetenciasTecnicasFreelancer that = (CompetenciasTecnicasFreelancer) o;
        return grauProficiencia == that.grauProficiencia && Objects.equals(freelancer, that.freelancer) && Objects.equals(competenciaTecnica, that.competenciaTecnica);
    }

    @Override
    public int hashCode() {
        return Objects.hash(freelancer, competenciaTecnica, grauProficiencia);
    }
}
