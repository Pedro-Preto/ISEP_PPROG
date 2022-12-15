/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExExameModelo;

/**
 *
 * @author Pedro
 */
public class Candidato {

    private String nome;
    private int numVotos;

    public Candidato(String nome) {
        this.nome = nome;
        this.numVotos = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getNumVotos() {
        return numVotos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNumVotos(int numVotos) {
        this.numVotos = numVotos;
    }

    public void incrementarVotos() {
        numVotos++;
    }

    public void inicializarNumVotos() {
        numVotos = 0;
    }
    
    @Override
    public String toString(){
        return String.format("Candidato: " +nome +" || Numero de Votos: " +numVotos);
    }

}
