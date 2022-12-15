package Código;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pedro
 */
public class VotoPapel extends Voto {

    private boolean assinatura;

    public VotoPapel(Candidato candidato, int data, int dataLim, boolean assinatura) {
        super(candidato, data, dataLim);
        this.assinatura = assinatura;
    }

    public boolean Assinado() {
        if (assinatura) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public String toString() {

        if (Assinado() == true) {
            String str1 = String.format("Voto em papel para s% -> válido", super.getCandidato().getNome());
            return str1;
        } else {
            String str2 = String.format("Voto em papel para s% -> inválido", super.getCandidato().getNome());
            return str2;

        }
    }
}
