package Código;

import Código.Candidato;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pedro
 */
public abstract class Voto {

    private Candidato candidato;
    private int data;
    private int dataLim;

    public Voto(Candidato candidato, int data, int dataLim) {
        this.candidato = candidato;
        this.data = data;
        this.dataLim = dataLim;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public int getData() {
        return data;
    }

    public int getDataLim() {
        return dataLim;
    }

    public boolean eValido() {
        if (data > dataLim) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String toString() {
        if (eValido() == true) {
            String str = String.format("Nome Candidato: %s -> é válido  ", this.candidato);
            return str;

        } else {

            String str = String.format("Nome Candidato: %s -> é inválido", this.candidato);
            return str;
        }
    }

}
