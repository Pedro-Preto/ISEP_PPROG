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
public class VotoCorreio extends Voto implements validaVotos {

    private boolean assinatura;

    public VotoCorreio(Candidato candidato, int data, int dataLim, boolean assinatura) {
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
    public boolean verificaData() {
        if (super.getData() > super.getDataLim()) {
            return false;

        } else {
            return true;
        }
    }

    @Override
    public String toString() {
        if (Assinado() == true && verificaData() == true) {
            String str1 = String.format("Envio de voto em papel para s% ->Válido", super.getCandidato().getNome());
            return str1;

        } else {
            String str2 = String.format("Envio de voto em papel para s% ->Inválido", super.getCandidato().getNome());
            return str2;
        }

    }
}
