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
public class VotoCorreio extends Voto implements validaVotos {

    private boolean assinatura;

    public VotoCorreio(Candidato candidato, int data, int dataLim, boolean assinatura) {
        super(candidato, data, dataLim);
        this.assinatura = assinatura;
    }

    @Override
    public boolean eValido() {
        return verificaData() == true && assinatura == true;
    }

    @Override
    public boolean verificaData() {
        System.out.println();
        return super.getData() <= super.getDataLim();
    }

    @Override
    public String toString() {
        if (eValido()) {
            return String.format(super.toString() + " Voto Correio");
        } else {
            return String.format("Não é valido");
        }

    }

}
