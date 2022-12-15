/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExExameModelo;

import java.util.ArrayList;

/**
 *
 * @author Pedro
 */
public class Escrutinio {

    private ArrayList<Candidato> candidatos;
    private int numEleitores;
    private int numVot;
    private int data;

    public Escrutinio(ArrayList<Candidato> candidatos, int numEleitores, int data) {
        this.candidatos = candidatos;
        this.numEleitores = numEleitores;
        this.numVot = 0;
        this.data = data;
    }

    public void calcularVotantes() {
        int soma = 0;
        for (Candidato candidato : candidatos) {
            soma += candidato.getNumVotos();
        }
        numVot = soma;
    }

    public void inicializarVotosCandidatos() {
        for (Candidato candidato : candidatos) {
            candidato.inicializarNumVotos();
        }
    }

    public ArrayList<Candidato> vencedor() {
        ArrayList<Candidato> vencedores = new ArrayList<>();
        int maiorNumVotos = 0;
        for (Candidato candidato : candidatos) {
            if (candidato.getNumVotos() > maiorNumVotos) {
                maiorNumVotos = candidato.getNumVotos();
                vencedores = new ArrayList<>();
                vencedores.add(candidato);
            } else if (candidato.getNumVotos() == maiorNumVotos) {
                vencedores.add(candidato);
            }
        }
        return vencedores;
    }

}
