/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.TP3.pot.services;

import pt.ipp.isep.dei.TP3.pot.controller.SeriarAnunciosController;
import pt.ipp.isep.dei.TP3.pot.model.Candidatura;
import pt.ipp.isep.dei.TP3.pot.model.CompetenciaTecnica;
import pt.ipp.isep.dei.TP3.pot.model.CompetenciasTecnicasFreelancer;
import pt.ipp.isep.dei.TP3.pot.model.Tarefa;

import java.util.ArrayList;
import java.util.Collections;

import static java.lang.Math.sqrt;

/**
 * Ordena as candidaturas de um anuncio segundo a ordem dos seguintes criterios: 
 * media do grau de proficiencia das competencias tecnicas do seu freelancer, desvio padrao do grau de proficiencia das 
 * competencias tecnicas do seu freelancer, valor pretendido da tarefa, data da candidatura
 * @author pedro
 */
public class TipoSeriacao2 implements TipoSeriacao {

    private ArrayList<Candidatura> candidaturasDoAnuncio = new ArrayList<>();

    public ArrayList<Candidatura> executa(String codigoAnuncio, SeriarAnunciosController dados) {

        // Obter as candidaturas relativas a este anuncio especifico
        candidaturasDoAnuncio = dados.getCandidaturasAnuncio(codigoAnuncio);

		// Calcular a media e o desvio padrao do grau de proficiencia das competencias tecnicas de cada candidatura
        // (apenas sao contabilizadas as competencias tecnicas do freelancer que 
		//  tambem sao competencias tecnicas da tarefa de cada candidatura)
        // 
        // Formula alternativa para o calculo do desvio padrao:
        // desvio padrao^2 = (somatorio(grauProficiencia^2))/N - media^2
        for (Candidatura candidatura : candidaturasDoAnuncio) {
            // Obter todas as competencias tecnicas relativas ao freelancer da candidatura
            ArrayList<CompetenciasTecnicasFreelancer> competenciasTecnicasFreelancer = dados.pesquisaCompetenciaTecnicasFreelancer(candidatura.getFreeLancer());

            // Tarefa associada a candidatura
            Tarefa tarefaCandidatura = candidatura.getAnuncio().getTarefa();
            // Obter todas as competencias tecnicas relativas a tarefa
            ArrayList<CompetenciaTecnica> competenciasTarefa = dados.getCompetenciasTecnicasDaTarefa(tarefaCandidatura);

            int somaGrauProficiencia = 0;
            int somaQuadradoGrauProficiencia = 0;
            int numeroCT = 0;
            for (CompetenciasTecnicasFreelancer competenciaFreelancer : competenciasTecnicasFreelancer) {
                if (competenciasTarefa.contains(competenciaFreelancer.getCompetenciaTecnica())) {
                    // Competencia tecnica do freelancer coincide com uma requirida pela tarefa da candidatura
                    somaGrauProficiencia += competenciaFreelancer.getGrauProficiencia();
                    somaQuadradoGrauProficiencia += (somaGrauProficiencia * somaGrauProficiencia);
                    numeroCT++;
                }
            }

            Double media = (double) somaGrauProficiencia / (double) numeroCT;
            candidatura.setMedia(media);
            Double variancia = ((double) somaQuadradoGrauProficiencia / (double) numeroCT) - (double) (media * media);
            candidatura.setDesvio(sqrt(variancia));
        }

        // 1º ordenar candidaturas segundo a sua maior media (maior para menor)
        // 2º ordenar candidaturas segundo o seu desvio padrao (menor para maior)
        // 3º ordenar candidaturas segundo o menor valorPretendido da tarefa (menor para maior)
        // 4º ordenar candidaturas segundo a data (mais antiga para mais recente)
        Collections.sort(candidaturasDoAnuncio, new CandidaturaChainedComparator(
                new CandidaturaMediaComparator(),
                new CandidaturaDesvioComparator(),
                new CandidaturaValorComparator(),
                new CandidaturaDataComparator())
        );

        return candidaturasDoAnuncio;
    }
}
