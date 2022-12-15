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
public class SimulaEleicao {
    
    ArrayList<Voto> votos;
    
    public SimulaEleicao(ArrayList<Voto> votos){
        this.votos = votos;
    }
    
    public void contarVotos(){
        for(Voto voto : votos) {
            if (voto.eValido()){
                voto.getCandidato().incrementarVotos();
            }
        }
    }
    
    
}
