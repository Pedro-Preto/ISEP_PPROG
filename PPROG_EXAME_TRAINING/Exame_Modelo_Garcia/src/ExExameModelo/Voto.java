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
public abstract class Voto {

    private Candidato candidato;
    private int data;
    private int dataLim;

    public Voto(Candidato candidato, int data, int dataLim) {
        this.candidato = candidato;
        this.data = data;
        this.dataLim = dataLim;
    }

    public abstract boolean eValido();
   


 @Override
    public String toString() {
        if (eValido()){
             return String.format("< %s > ->  valido", candidato.getNome());
        } else {
            return String.format("< %s > ->  invalido", candidato.getNome());
        }
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

}
