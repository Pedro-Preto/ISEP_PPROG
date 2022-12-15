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
public class Main {

    public static void main(String[] args) {
        
        ArrayList<Candidato> candidatos = new ArrayList<>();

        Candidato candidato1 = new Candidato("Candidum");
        Candidato candidato2 = new Candidato("Candidois");
        
        candidatos.add(candidato1);
        candidatos.add(candidato2);
        
        Escrutinio esc = new Escrutinio(candidatos, 15, 10);

        VotoCorreio vc = new VotoCorreio(candidato1, 1, 4, true);
        VotoEletronico ve = new VotoEletronico(candidato2, 1, 4);
        VotoPapel vp = new VotoPapel(candidato1, 6, 4, true);

        System.out.println(vc);
        System.out.println(ve);
        System.out.println(vp);

        System.out.println();
        System.out.println("==========================================");

        ArrayList<Voto> votos = new ArrayList<>();

        votos.add(vc);
        votos.add(ve);
        votos.add(vp);

        for (Voto voto : votos) {
            System.out.println(voto.toString());
        }
        
        SimulaEleicao simEleic = new SimulaEleicao(votos);
        simEleic.contarVotos();
        
        System.out.println(esc.vencedor());
        
    }

}
