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
public class VotoPapel extends Voto {

    private boolean assinatura;

    public VotoPapel(Candidato candidato, int data, int dataLim, boolean assinatura) {
        super(candidato, data, dataLim);
        this.assinatura = assinatura;
    }

    @Override
    public boolean eValido() {
        return assinatura == true;
    }

    @Override
    public String toString() {
        if (eValido()) {
            return String.format(super.toString() + " Voto Papel");
        } else {
            return String.format("Não é valido");

        }
    }
}
