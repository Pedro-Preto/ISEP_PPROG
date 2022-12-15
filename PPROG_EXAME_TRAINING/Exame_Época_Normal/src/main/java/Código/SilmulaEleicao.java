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
public class SilmulaEleicao {

    private ArrayList<Voto> votoList;

    public SilmulaEleicao(ArrayList<Voto> votoList) {
        this.votoList = votoList;
    }

    public void contarVotos(){
        for(Voto voto : votoList) {
            if (voto.eValido()){
                voto.getCandidato().incrementarVotos();
            }
        }
    }
}
