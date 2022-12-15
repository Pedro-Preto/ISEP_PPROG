package pt.ipp.isep.dei.TP3.pot.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.TP3.pot.model.*;
import sun.util.calendar.BaseCalendar;

import java.io.FileNotFoundException;
import java.sql.Date;
import java.text.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SeriarAnunciosControllerTest {

    private SeriarAnunciosController seriarAnunciosController;

    @BeforeEach
    void setUp() {
        seriarAnunciosController = new SeriarAnunciosController();
    }


    @Test
    void carregarInformacao() throws FileNotFoundException, ParseException {
        boolean mustBeTrue = seriarAnunciosController.carregarInformacao();
        assertTrue(mustBeTrue);
    }


    @Test
    void pesquisaTarefa() throws FileNotFoundException, ParseException {
        seriarAnunciosController.carregarInformacao();
        Tarefa a2 = seriarAnunciosController.pesquisaTarefa("TAR1");
        Tarefa a1 = new Tarefa("TAR1", "EscreverArtigoParaRevista", "Literatura");

        assertEquals(a2.toString(), a1.toString());
    }

    @Test
    void pesquisaAnuncio() throws FileNotFoundException, ParseException {
        seriarAnunciosController.carregarInformacao();
        Anuncio a2 = seriarAnunciosController.pesquisaAnuncio("ANUNC1");
        Anuncio a1 = new Anuncio("ANUNC1", new Tarefa("TAR1", "EscreverArtigoParaRevista", "Literatura"));

        assertEquals(a2.toString(), a1.toString());
    }

    @Test
    void pesquisaFreelancer() throws FileNotFoundException, ParseException {
        seriarAnunciosController.carregarInformacao();
        Freelancer a2 = seriarAnunciosController.pesquisaFreelancer("nif1");
        Freelancer a1 = new Freelancer("JoaoEscritor", "nif1", "917483989", "joao@gmail.com");

        assertEquals(a2.toString(), a1.toString());
    }

    @Test
    void pesquisaCompetenciaTecnica() throws FileNotFoundException, ParseException {
        seriarAnunciosController.carregarInformacao();
        CompetenciaTecnica a1 = new CompetenciaTecnica("CT1", "vocabulario");
        CompetenciaTecnica a2 = seriarAnunciosController.pesquisaCompetenciaTecnica("CT1");

        assertEquals(a2.toString(), a1.toString());
    }

    @Test
    void pesquisaCompetenciaTecnicaTarefa() throws FileNotFoundException, ParseException {
        seriarAnunciosController.carregarInformacao();
        Tarefa t1 = new Tarefa("TAR1", "EscreverArtigoParaRevista", "Literatura");
        Tarefa t2 = new Tarefa("TAR1", "EscreverArtigoParaRevista", "Literatura");
        CompetenciaTecnica ct1 = new CompetenciaTecnica("CT1", "vocabulario");
        CompetenciaTecnica ct2 = new CompetenciaTecnica("CT2", "gramatica");
        CompetenciasTecnicasTarefa ctt1 = new CompetenciasTecnicasTarefa(t1, ct1, true);
        CompetenciasTecnicasTarefa ctt2 = new CompetenciasTecnicasTarefa(t2, ct2, false);
        ArrayList<CompetenciasTecnicasTarefa> act1 = seriarAnunciosController.pesquisaCompetenciaTecnicaTarefa(t1);
        ArrayList<CompetenciasTecnicasTarefa> act2 = new ArrayList<>();
        act2.add(ctt1);
        act2.add(ctt2);
        assertEquals(act1.toString(), act2.toString());
    }

    @Test
    void pesquisaCompetenciaTecnicasFreelancer() throws FileNotFoundException, ParseException {
        seriarAnunciosController.carregarInformacao();

        Freelancer f1 = new Freelancer("ManelEscritor", "nif2", "968453748", "manel@gmail.com");

        ArrayList<CompetenciasTecnicasFreelancer> actf1 = seriarAnunciosController.pesquisaCompetenciaTecnicasFreelancer(f1);


        CompetenciaTecnica ct1 = new CompetenciaTecnica("CT1", "vocabulario");
        CompetenciaTecnica ct2 = new CompetenciaTecnica("CT2", "gramatica");
        CompetenciaTecnica ct3 = new CompetenciaTecnica("CT3", "filosofia");
        CompetenciaTecnica ct4 = new CompetenciaTecnica("CT6", "algoritmia");

        CompetenciasTecnicasFreelancer ctf1 = new CompetenciasTecnicasFreelancer(f1, ct1, 4);
        CompetenciasTecnicasFreelancer ctf2 = new CompetenciasTecnicasFreelancer(f1, ct2, 2);
        CompetenciasTecnicasFreelancer ctf3 = new CompetenciasTecnicasFreelancer(f1, ct3, 5);
        CompetenciasTecnicasFreelancer ctf4 = new CompetenciasTecnicasFreelancer(f1, ct4, 1);

        ArrayList<CompetenciasTecnicasFreelancer> actf2 = new ArrayList<>();
        actf2.add(ctf1);
        actf2.add(ctf2);
        actf2.add(ctf3);
        actf2.add(ctf4);
        assertEquals(actf1.toString(), actf2.toString());
    }


    @Test
    void getCompetenciasTecnicasDaTarefa() throws FileNotFoundException, ParseException {
        seriarAnunciosController.carregarInformacao();
        Tarefa t1 = new Tarefa("TAR1", "EscreverArtigoParaRevista", "Literatura");
        ArrayList<CompetenciaTecnica> ctt1 = seriarAnunciosController.getCompetenciasTecnicasDaTarefa(t1);

        ArrayList<CompetenciaTecnica> ctt2 = new ArrayList<>();

        CompetenciaTecnica ct1 = new CompetenciaTecnica("CT1", "vocabulario");
        CompetenciaTecnica ct2 = new CompetenciaTecnica("CT2", "gramatica");
        ctt2.add(ct1);
        ctt2.add(ct2);
        assertEquals(ctt1.toString(), ctt2.toString());


    }

    @Test
    void getCandidaturasAnuncio() throws FileNotFoundException, ParseException {
        seriarAnunciosController.carregarInformacao();

        ArrayList<Candidatura> c1 = seriarAnunciosController.getCandidaturasAnuncio("ANUNC1");
        ArrayList<Candidatura> c2 = new ArrayList<>();

        Freelancer f1 = new Freelancer("JoaoEscritor", "nif1", "917483989", "joao@gmail.com");

        Tarefa t1 = new Tarefa("TAR1", "EscreverArtigoParaRevista", "Literatura");

        Anuncio a1 = new Anuncio("ANUNC1", t1);

        Candidatura ca1 = new Candidatura(f1, a1, new Date(26/1/2020), 1000.0);

        c2.add(ca1);

        assertEquals(c1.toString(), c2.toString());
    }


}