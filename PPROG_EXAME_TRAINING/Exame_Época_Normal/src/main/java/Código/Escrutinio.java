package Código;

import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pedro
 */
public class Escrutinio {

    private int numEleitores;//Membros do partido
    private int numVot;
    private int data;
    private ArrayList<Candidato> Tcandidatos;

    public Escrutinio(int numEleitores, int numVot, int data, ArrayList<Candidato> Tcandidatos) {
        this.numEleitores = numEleitores;
        this.numVot = numVot;
        this.data = data;
        this.Tcandidatos = Tcandidatos;
    }

    public int getNumEleitores() {
        return numEleitores;
    }

    public int getNumVot() {
        return numVot;
    }

    public int getData() {
        return data;
    }

    public ArrayList<Candidato> getTcandidatos() {
        return Tcandidatos;
    }

    public void calcularVotantes() {
        for (Candidato c : Tcandidatos) {
            numVot += c.getNumVotos();
        }
    }

    public void inicializarVotosCandidatos() {
        for (Candidato c : Tcandidatos) {
            c.inicializarVotos();
        }
    }

     public ArrayList<Candidato> vencedor() {
        ArrayList<Candidato> vencedores = new ArrayList<>();
        int maiorNumVotos = 0;
        for (Candidato c : Tcandidatos) {
            if (c.getNumVotos() > maiorNumVotos) {
                maiorNumVotos = c.getNumVotos();
                vencedores = new ArrayList<>();
                vencedores.add(c);
            } else if (c.getNumVotos() == maiorNumVotos) {
                vencedores.add(c);
            }
        }
        return vencedores;
    }

}
