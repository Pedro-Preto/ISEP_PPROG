/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.TP3.pot.controller;

import pt.ipp.isep.dei.TP3.pot.model.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Controlador do projeto
 *
 * @author pedro
 */
public class SeriarAnunciosController {

    // Identificacao do nome dos ficheiros referentes as informacoes necessarias para a aplicacao
    private static final String FICHEIRO_ANUNCIO = "FicheirosDeTexto//Anuncio.txt";
    private static final String FICHEIRO_CANDIDATURA = "FicheirosDeTexto//Candidatura.txt";
    private static final String FICHEIRO_CT_TAREFA = "FicheirosDeTexto//CompetenciasTecnicasTarefa.txt";
    private static final String FICHEIRO_CT_FREELANCER = "FicheirosDeTexto//CompetenciasTecnicasFreelancer.txt";
    private static final String FICHEIRO_FREELANCER = "FicheirosDeTexto//Freelancer.txt";
    private static final String FICHEIRO_TAREFA = "FicheirosDeTexto//Tarefa.txt";
    private static final String FICHEIRO_CT = "FicheirosDeTexto//CompetenciasTecnicas.txt";

    // Variaveis que armazenam a informacao relativa ao ficheiros que sao lidos
    private ArrayList<CompetenciaTecnica> competenciasTecnicas;
    private ArrayList<Anuncio> anuncios;
    private ArrayList<Tarefa> tarefas;
    private ArrayList<CompetenciasTecnicasFreelancer> competenciasTecnicasFreeLancers;
    private ArrayList<CompetenciasTecnicasTarefa> competenciasTecnicasTarefas;
    private ArrayList<Candidatura> candidaturas;
    private ArrayList<Freelancer> freelancers;

    /**
     * Construtor da classe que redimensiona os atributos da classe
     */
    public SeriarAnunciosController() {
        this.competenciasTecnicas = new ArrayList<>();
        this.anuncios = new ArrayList<>();
        this.tarefas = new ArrayList<>();
        this.competenciasTecnicasFreeLancers = new ArrayList<>();
        this.competenciasTecnicasTarefas = new ArrayList<>();
        this.candidaturas = new ArrayList<>();
        this.freelancers = new ArrayList<>();
    }

    /**
     * Le os ficheiros e carrega as informacoes lidas para os atributos da
     * classe correspondentes
     *
     * @throws FileNotFoundException - indica que nao foi possivel abrir o
     * ficheiro
     * @throws ParseException - indica que nao foi possivel realizar alguma
     * conversao
     * @throws RuntimeException - indica que as informacoes no ficheiro tem
     * erros sintaticos
     */
    public Boolean carregarInformacao() throws FileNotFoundException, ParseException, RuntimeException {
        // Redimensiona os atributos da classe (para nao gerar informacao duplicada)
        this.competenciasTecnicas = new ArrayList<>();
        this.anuncios = new ArrayList<>();
        this.tarefas = new ArrayList<>();
        this.competenciasTecnicasFreeLancers = new ArrayList<>();
        this.competenciasTecnicasTarefas = new ArrayList<>();
        this.candidaturas = new ArrayList<>();
        this.freelancers = new ArrayList<>();

        // Tenta ler todos os ficheiros e caso algum erro seja gerado, mostra a sua mensagem
        try {
            // Ordem de leitura considera a interdependencia entre classes
            lerTarefas();
            lerAnuncios();
            lerFreelancers();
            lerCandidaturas();
            lerCompetenciasTecnicas();
            lerCompetenciasTecnicasFreelancer();
            lerCompetenciasTecnicasTarefas();
        } catch (FileNotFoundException ex) {
            System.out.println("Localizacao de algum ficheiro e invalida!");
            return false;
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
            return false;
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    /**
     * Retorna a tarefa referente a um determinado codigo
     *
     * @param codigo - codigo que identifica de forma unica a tarefa
     * @return a tarefa deste codigo
     */
    public Tarefa pesquisaTarefa(String codigo) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getCodigo().equalsIgnoreCase(codigo)) {
                return tarefa;
            }
        }
        return null;
    }

    /**
     * Retorna o anuncio referente a um determinado codigo
     *
     * @param codigo - codigo que identifica de forma unica o anuncio
     * @return o anuncio deste codigo
     */
    public Anuncio pesquisaAnuncio(String codigo) {
        for (Anuncio anuncio : anuncios) {
            if (anuncio.getCodigo().equalsIgnoreCase(codigo)) {
                return anuncio;
            }
        }
        return null;
    }

    /**
     * Retorna o freelancer referente a um determinado numero de identificacao
     * fiscal
     *
     * @param nif - numero que identifica de forma unica o freelancer
     * @return o freelancer deste NIF
     */
    public Freelancer pesquisaFreelancer(String nif) {
        for (Freelancer freelancer : freelancers) {
            if (freelancer.getNif().equalsIgnoreCase(nif)) {
                return freelancer;
            }
        }
        return null;
    }

    /**
     * Retorna a competencia tecnica referente a um determinado codigo
     *
     * @param codigo - codigo que identifica de forma unica a competencia
     * tecnica
     * @return a competencia tecnica deste codigo
     */
    public CompetenciaTecnica pesquisaCompetenciaTecnica(String codigo) {
        for (CompetenciaTecnica competenciaTecnica : competenciasTecnicas) {
            if (competenciaTecnica.getCodigo().equalsIgnoreCase(codigo)) {
                return competenciaTecnica;
            }
        }
        return null;
    }

    /**
     * Retorna todas as relacoes de competencias tecnicas associadas a uma
     * determinada tarefa
     *
     * @param tarefa - identifica a tarefa sobre a qual queremos obter as
     * relacoes
     * @return a lista de 'competencias tecnicas tarefa' desta tarefa
     */
    public ArrayList<CompetenciasTecnicasTarefa> pesquisaCompetenciaTecnicaTarefa(Tarefa tarefa) {
        ArrayList<CompetenciasTecnicasTarefa> result = new ArrayList<>();
        for (CompetenciasTecnicasTarefa competenciaTecnicaTarefa : competenciasTecnicasTarefas) {
            if (competenciaTecnicaTarefa.getTarefa().equals(tarefa)) {
                result.add(competenciaTecnicaTarefa);
            }
        }
        return result;
    }

    /**
     * Retorna todas as relacoes de competencias tecnicas associadas a um
     * determinado freelancer
     *
     * @param freelancer - identifica o freelancer sobre o qual queremos obter
     * as relacoes
     * @return a lista de 'competencias tecnicas freelancer' deste freelancer
     */
    public ArrayList<CompetenciasTecnicasFreelancer> pesquisaCompetenciaTecnicasFreelancer(Freelancer freelancer) {
        ArrayList<CompetenciasTecnicasFreelancer> result = new ArrayList<>();
        for (CompetenciasTecnicasFreelancer competenciaTecnicaFreelancer : competenciasTecnicasFreeLancers) {
            if (competenciaTecnicaFreelancer.getFreelancer().equals(freelancer)) {
                result.add(competenciaTecnicaFreelancer);
            }
        }
        return result;
    }

    private void lerCompetenciasTecnicas() throws FileNotFoundException {
        // Le e guarda as informacoes referentes ao ficheiro de competencias tecnicas
        String[] aux;
        Scanner sc = new Scanner(new FileReader(FICHEIRO_CT));
        sc.nextLine();
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            if (linha != null) {
                aux = linha.split(";");
                competenciasTecnicas.add(new CompetenciaTecnica(aux[0].trim(), aux[1].trim()));
            }
        }
        sc.close();
        System.out.println("Ficheiro CompetenciasTecnicasObrigatorias lido");
    }

    private void lerFreelancers() throws FileNotFoundException {
        // Le e guarda as informacoes referentes ao ficheiro de freelancers
        String[] aux;
        Scanner sc = new Scanner(new FileReader(FICHEIRO_FREELANCER));
        sc.nextLine();
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            if (linha != null) {
                aux = linha.split(";");
                freelancers.add(new Freelancer(aux[0].trim(), aux[1].trim(), aux[2].trim(), aux[3].trim()));
            }
        }
        sc.close();
        System.out.println("Ficheiro Freelancer lido");
    }

    private void lerTarefas() throws FileNotFoundException {
        // Le e guarda as informacoes referentes ao ficheiro de tarefas
        String[] aux;
        Scanner sc = new Scanner(new FileReader(FICHEIRO_TAREFA));
        sc.nextLine();
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            if (linha != null) {
                aux = linha.split(";");
                tarefas.add(new Tarefa(aux[0].trim(), aux[1].trim(), aux[2].trim()));
            }
        }
        sc.close();
        System.out.println("Ficheiro Tarefa lido");
    }

    private void lerAnuncios() throws FileNotFoundException, RuntimeException {
        // Le e guarda as informacoes referentes ao ficheiro de anuncios
        String[] aux;
        Scanner sc = new Scanner(new FileReader(FICHEIRO_ANUNCIO));
        sc.nextLine();
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            if (linha != null) {
                aux = linha.split(";");
                Tarefa tarefa = pesquisaTarefa(aux[1].trim());
                if (tarefa == null) {
                    throw new RuntimeException("A tarefa com o código " + aux[1].trim() + " não foi encontrada");
                }
                anuncios.add(new Anuncio(aux[0].trim(), tarefa));
            }
        }
        sc.close();
        System.out.println("Ficheiro Anuncio lido");
    }

    private void lerCandidaturas() throws FileNotFoundException, ParseException {
        // Le e guarda as informacoes referentes ao ficheiro de candidaturas
        String[] aux;
        Scanner sc = new Scanner(new FileReader(FICHEIRO_CANDIDATURA));
        sc.nextLine();
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            if (linha != null) {
                aux = linha.split(";");
                Anuncio anuncio = pesquisaAnuncio(aux[1].trim());
                if (anuncio == null) {
                    throw new RuntimeException("O anúncio com o código " + aux[1].trim() + " não foi encontrado");
                }
                Freelancer freelancer = pesquisaFreelancer(aux[0].trim());
                if (freelancer == null) {
                    throw new RuntimeException("O freelancer com o nif " + aux[0].trim() + " não foi encontrado");
                }
                candidaturas.add(new Candidatura(freelancer,
                        anuncio,
                        new SimpleDateFormat("dd/MM/yyyy").parse(aux[2].trim()),
                        Double.parseDouble(aux[3].trim())));
            }

        }
        sc.close();
        System.out.println("Ficheiro Candidaturas lido");
    }

    private void lerCompetenciasTecnicasFreelancer() throws FileNotFoundException, ParseException {
        // Le e guarda as informacoes referentes ao ficheiro de relacoes entre competencias tecnicas e freelancers
        String[] aux, aux2, aux3;
        Scanner sc = new Scanner(new FileReader(FICHEIRO_CT_FREELANCER));
        sc.nextLine();
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            if (linha != null) {
                aux = linha.split(";");
                Freelancer freelancer = pesquisaFreelancer(aux[0].trim());
                if (freelancer == null) {
                    throw new RuntimeException("O freelancer com o nif " + aux[0].trim() + " não foi encontrado");
                }

                aux2 = aux[1].trim().split(",");
                aux3 = aux[2].trim().split(",");

                if (aux2.length != aux3.length) {
                    throw new RuntimeException("Nem todas as competencias tem o grau definido!");
                }
                for (int i = 0; i < aux2.length; i++) {
                    CompetenciaTecnica competenciaTecnica = pesquisaCompetenciaTecnica(aux2[i].trim());
                    if (competenciaTecnica == null) {
                        throw new RuntimeException("A competencia técnica  com o código" + aux2[i].trim() + " não foi encontrada");
                    }

                    competenciasTecnicasFreeLancers.add(new CompetenciasTecnicasFreelancer(freelancer,
                            competenciaTecnica,
                            Integer.parseInt(aux3[i].trim())));
                }
            }

        }
        sc.close();
        System.out.println("Ficheiro CompetenciasTecnicasFreelancer lido");
    }

    private void lerCompetenciasTecnicasTarefas() throws FileNotFoundException, ParseException {
        // Le e guarda as informacoes referentes ao ficheiro de relacoes entre competencias tecnicas e tarefas
        String[] aux, aux2, aux3;
        Scanner sc = new Scanner(new FileReader(FICHEIRO_CT_TAREFA));
        sc.nextLine();
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            if (linha != null) {
                aux = linha.split(";");
                Tarefa tarefa = pesquisaTarefa(aux[0].trim());
                if (tarefa == null) {
                    throw new RuntimeException("A tarefa com o códigof " + aux[0].trim() + " não foi encontrada");
                }

                aux2 = aux[1].trim().split(",");
                aux3 = aux[2].trim().split(",");

                if (aux2.length != aux3.length) {
                    throw new RuntimeException("Nem todas as competencias tem a obrigatoriedade definida!");
                }
                for (int i = 0; i < aux2.length; i++) {
                    CompetenciaTecnica competenciaTecnica = pesquisaCompetenciaTecnica(aux2[i].trim());
                    if (competenciaTecnica == null) {
                        throw new RuntimeException("A competencia técnica  com o codigo" + aux2[i].trim() + " não foi encontrada");
                    }

                    competenciasTecnicasTarefas.add(new CompetenciasTecnicasTarefa(tarefa,
                            competenciaTecnica,
                            Boolean.parseBoolean(aux3[i].trim())));
                }
            }

        }
        sc.close();
        System.out.println("Ficheiro CompetenciasTecnicasTarefa lido");
    }

    /**
     * Retorna as informacoes lidas do ficheiro de competencias tecnicas
     *
     * @return a lista de todas as competencias tecnicas
     */
    public ArrayList<CompetenciaTecnica> getCompetenciasTecnicas() {
        return competenciasTecnicas;
    }

    /**
     * Retorna as informacoes lidas do ficheiro de anuncios
     *
     * @return a lista de todos os anuncios
     */
    public ArrayList<Anuncio> getAnuncios() {
        return anuncios;
    }

    /**
     * Retorna as informacoes lidas do ficheiro de tarefas
     *
     * @return a lista de todas as tarefas
     */
    public ArrayList<Tarefa> getTarefas() {
        return tarefas;
    }

    /**
     * Retorna as informacoes lidas do ficheiro de relacoes entre competencias
     * tecnicas e freelancers
     *
     * @return a lista de todas as 'competencias tecnicas freelancers'
     */
    public ArrayList<CompetenciasTecnicasFreelancer> getCompetenciasTecnicasFreeLancers() {
        return competenciasTecnicasFreeLancers;
    }

    /**
     * Retorna as informacoes lidas do ficheiro de relacoes entre competencias
     * tecnicas e tarefas
     *
     * @return a lista de todas as 'competencias tecnicas tarefas'
     */
    public ArrayList<CompetenciasTecnicasTarefa> getCompetenciasTecnicasTarefas() {
        return competenciasTecnicasTarefas;
    }

    /**
     * Retorna as informacoes lidas do ficheiro de candidaturas
     *
     * @return a lista de todas as candidaturas
     */
    public ArrayList<Candidatura> getCandidaturas() {
        return candidaturas;
    }

    /**
     * Retorna as informacoes lidas do ficheiro de freelancers
     *
     * @return a lista de todos os freelancers
     */
    public ArrayList<Freelancer> getFreelancers() {
        return freelancers;
    }

    /**
     * Retorna todas as competencias tecnicas associadas a uma determinada
     * tarefa
     *
     * @param tarefa - identifica a tarefa sobre a qual queremos obter as
     * competencias tecnicas
     * @return a lista de competencias tecnicas desta tarefa
     */
    public ArrayList<CompetenciaTecnica> getCompetenciasTecnicasDaTarefa(Tarefa tarefa) {
        ArrayList<CompetenciaTecnica> result = new ArrayList<>();
        for (CompetenciasTecnicasTarefa competenciaTecnicaTarefa : competenciasTecnicasTarefas) {
            if (competenciaTecnicaTarefa.getTarefa().equals(tarefa)) {
                result.add(competenciaTecnicaTarefa.getCompetenciaTecnica());
            }
        }
        return result;
    }

    /**
     * Retorna todas as candidaturas associadas a um determinado codigo de um
     * anuncio
     *
     * @param codigoAnuncio - codigo que identifica de forma unica o anuncio
     * @return a lista de candidaturas deste codigo de anuncio
     */
    public ArrayList<Candidatura> getCandidaturasAnuncio(String codigoAnuncio) {
        ArrayList<Candidatura> result = new ArrayList<>();
        for (Candidatura candidatura : candidaturas) {
            if (candidatura.getCodigoAnuncio().equalsIgnoreCase(codigoAnuncio)) {
                result.add(candidatura);
            }
        }
        return result;
    }
}
