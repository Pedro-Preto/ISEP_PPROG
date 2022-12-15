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
public class VotoEletronico extends Voto implements validaVotos {

    public VotoEletronico(Candidato candidato, int data, int dataLim) {
        super(candidato, data, dataLim);
    }

    @Override
    public boolean eValido() {
        return verificaData();
    }

    @Override
    public boolean verificaData() {
        return (super.getData() <= (super.getDataLim() - 2));
    }

    @Override
    public String toString() {
        if (eValido()) {
            return String.format(super.toString() + " Voto Eletronico");
        } else {
            return String.format("Não é valido");

        }
    }
}