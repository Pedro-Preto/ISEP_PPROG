/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recurso_2019;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Pedro
 */
public abstract class Software implements Experimentavel, Comparable<Software>, Serializable {

    private String nome;
    private String plataforma;

    public Software(String nome, String plataforma) {
        this.nome = nome;
        this.plataforma = plataforma;
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    public String getPlataforma() {
        return this.plataforma;
    }

    public abstract String getDescricao();
    
    @Override
    public String toString(){
        return String.format("Nome: " +nome +" || Plataforma: " +plataforma);
    }
    
    
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

}
