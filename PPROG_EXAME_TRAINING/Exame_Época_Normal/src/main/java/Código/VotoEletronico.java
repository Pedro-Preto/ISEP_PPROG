package Código;

import Código.Voto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pedro
 */
public class VotoEletronico extends Voto implements validaVotos {

    public VotoEletronico(Candidato candidato, int data, int dataLim) {
        super(candidato, data, dataLim);
    }

    @Override
    public boolean verificaData() {
        if (super.getData() > (super.getDataLim() - 2)) {
            return false;

        } else {
            return true;
        }

    }

    @Override
    public String toString() {
        if (verificaData() == true) {
            String str1 = String.format("Voto eletrónico para s% ->Válido",super.getCandidato().getNome());
            return str1;

        } else {
            String str2 = String.format("Voto eletrónico para s% ->Inválido",super.getCandidato().getNome());
            return str2;
        }
    }
}
