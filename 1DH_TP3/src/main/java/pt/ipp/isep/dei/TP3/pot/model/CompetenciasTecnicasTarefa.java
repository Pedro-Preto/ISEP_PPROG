/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.TP3.pot.model;

import java.util.Objects;

/**
 * Class que associa uma tarefa a uma determinada competencia tecnica (uma tarefa pode ter mais do que uma 
 * competencia tecnica, bem como uma mesmo competencia tecnica pode ser partilhada por varias tarefas)
 * @author Pedro
 */
public class CompetenciasTecnicasTarefa {
    
    private Tarefa tarefa;
    private CompetenciaTecnica competenciaTecnica;
    private boolean obrigatoria;

    /**
     * Construtor da classe
     * @param tarefa - representa a tarefa que se associa a uma competencia tecnica
     * @param competenciaTecnica - representa a competencia tecnica dessa tarefa
     * @param obrigatoria - distingue se uma competencia tecnica e obrigatoria ou apenas desejavel
     */
    public CompetenciasTecnicasTarefa(Tarefa tarefa, CompetenciaTecnica competenciaTecnica, boolean obrigatoria) {
        this.tarefa = tarefa;
        this.competenciaTecnica = competenciaTecnica;
        this.obrigatoria = obrigatoria;
    }

    /**
     * Retorna a tarefa referente a esta relacao
     * @return a tarefa 
     */
    public Tarefa getTarefa() {
        return tarefa;
    }

    /**
     * Atualiza a tarefa associada a esta relacao
     * @param tarefa - nova tarefa 
     */
    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
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
     * Retorna o estado de obrigatoriedade da competencia tecnica
     * @return o estado de obrigatoriedade
     */
    public boolean isObrigatoria() {
        return obrigatoria;
    }

    /**
     * Atualiza o estado de obrigatoriedade da competencia tecnica
     * @param obrigatoria - novo estado de obrigatoriedade
     */
    public void setObrigatoria(boolean obrigatoria) {
        this.obrigatoria = obrigatoria;
    }

    @Override
    public String toString() {
        return String.format("CompetenciasTecnicasTarefa-Tarefa:%s,CompetenciaTecnica:%s,Obrigatoria:%s",tarefa,competenciaTecnica,obrigatoria);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompetenciasTecnicasTarefa)) return false;
        CompetenciasTecnicasTarefa that = (CompetenciasTecnicasTarefa) o;
        return obrigatoria == that.obrigatoria && Objects.equals(tarefa, that.tarefa) && Objects.equals(competenciaTecnica, that.competenciaTecnica);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tarefa, competenciaTecnica, obrigatoria);
    }
}
