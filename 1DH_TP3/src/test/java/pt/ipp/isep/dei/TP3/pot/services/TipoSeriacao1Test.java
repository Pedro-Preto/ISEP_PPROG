package pt.ipp.isep.dei.TP3.pot.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.TP3.pot.controller.SeriarAnunciosController;
import pt.ipp.isep.dei.TP3.pot.model.Anuncio;
import pt.ipp.isep.dei.TP3.pot.model.Candidatura;
import pt.ipp.isep.dei.TP3.pot.model.Freelancer;
import pt.ipp.isep.dei.TP3.pot.model.Tarefa;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TipoSeriacao1Test {
    private SeriarAnunciosController seriarAnunciosController;
    private TipoSeriacao1 tipoSeriacao1;

    @BeforeEach
    void setUp() throws FileNotFoundException, ParseException {
        seriarAnunciosController = new SeriarAnunciosController();
        seriarAnunciosController.carregarInformacao();
        tipoSeriacao1 = new TipoSeriacao1();
    }

    @Test
    void executa() {

        ArrayList<Candidatura> esperado = tipoSeriacao1.executa("ANUNC2", seriarAnunciosController);
        String st1 ="Candidatura{freelancer=Freelancer{nome='ManelEscritor', nif='nif2', telefone='968453748', email='manel@gmail.com'}, anuncio=Anuncio{codigo='ANUNC2', tarefa=Tarefa{codigo='TAR2', designacao='ArranjarJardim', categoria='Jardinagem'}}, dataCandidatura=Mon Jan 27 00:00:00 GMT 2020, valorPretendido=1000.0, media=5.0, desvio=null}, Candidatura{freelancer=Freelancer{nome='a', nif='nif3', telefone='917483989', email='joao@gmail.com'}, anuncio=Anuncio{codigo='ANUNC2', tarefa=Tarefa{codigo='TAR2', designacao='ArranjarJardim', categoria='Jardinagem'}}, dataCandidatura=Sun Jan 26 00:00:00 GMT 2020, valorPretendido=1000.0, media=4.0, desvio=null}, Candidatura{freelancer=Freelancer{nome='JoaoEscritor', nif='nif1', telefone='917483989', email='joao@gmail.com'}, anuncio=Anuncio{codigo='ANUNC2', tarefa=Tarefa{codigo='TAR2', designacao='ArranjarJardim', categoria='Jardinagem'}}, dataCandidatura=Sun Jan 26 00:00:00 GMT 2020, valorPretendido=2000.0, media=3.0, desvio=null}";
                ArrayList<String> obtido = new ArrayList<>();
        obtido.add(st1);
        assertEquals(esperado.toString(), obtido.toString());

    }
}