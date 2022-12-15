/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Código_Recurso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author pedro
 */
public abstract class Software implements Experimentavel, Comparable<Software>, Serializable  {

    private String nome;
    private String Plataforma;

    public Software(String nome, String Plataforma) {
        this.nome = nome;
        this.Plataforma = Plataforma;
    }

    @Override
    public String getNome() {
        return nome;
    }

    public String getPlataforma() {
        return Plataforma;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPlataforma(String Plataforma) {
        this.Plataforma = Plataforma;
    }

    public abstract String getDescricao();

    public static ArrayList<Software> ordenar(ArrayList<Software> listaSoftware) {
        ArrayList<Software> listaSoftwareOrdenado = listaSoftware;
        Collections.sort(listaSoftwareOrdenado);
        return listaSoftwareOrdenado;
    }

    @Override
    public int compareTo(Software software) {
        String plataformaSoftware = software.getPlataforma();
        String nomeSoftware = software.getNome();
        if ((this.getPlataforma()).compareTo(plataformaSoftware) != 0) {
            return (this.getPlataforma()).compareTo(plataformaSoftware);
        } else {
            return (this.getNome()).compareTo(nomeSoftware);
        }
    }
    
     @Override
    public String toString(){
        return String.format("Nome: " +nome +" || Plataforma: " +Plataforma);
    }
}
