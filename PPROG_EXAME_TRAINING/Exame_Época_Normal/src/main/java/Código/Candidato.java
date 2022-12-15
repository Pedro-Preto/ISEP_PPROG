package Código;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pedro
 */
public class Candidato {

    private String nome;
    private int numVotos;

    public Candidato(String nome, int numVotos) {
        this.nome = nome;
        this.numVotos = 0;

    }

    public String getNome() {
        return nome;
    }

    public int getNumVotos() {
        return numVotos;
    }

    public void incrementarVotos() {
        numVotos++;

    }

    public void inicializarVotos() {
        if (numVotos != 0) ;
        numVotos = numVotos - numVotos;
    }
@Override
    public String toString(){
        return String.format("Candidato: " +nome +" || Numero de Votos: " +numVotos);
    }
}
