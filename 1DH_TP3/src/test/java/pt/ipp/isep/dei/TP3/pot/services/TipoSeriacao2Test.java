package pt.ipp.isep.dei.TP3.pot.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.TP3.pot.controller.SeriarAnunciosController;
import pt.ipp.isep.dei.TP3.pot.model.Candidatura;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TipoSeriacao2Test {

    private SeriarAnunciosController seriarAnunciosController;
    private TipoSeriacao2 tipoSeriacao2;

    @BeforeEach
    void setUp() throws FileNotFoundException, ParseException {
        seriarAnunciosController = new SeriarAnunciosController();
        seriarAnunciosController.carregarInformacao();
        tipoSeriacao2 = new TipoSeriacao2();
    }

    @Test
    void executa() {

        ArrayList<Candidatura> esperado1 = tipoSeriacao2.executa("ANUNC2", seriarAnunciosController);
        String st1 = "Candidatura{freelancer=Freelancer{nome='ManelEscritor', nif='nif2', telefone='968453748', email='manel@gmail.com'}, anuncio=Anuncio{codigo='ANUNC2', tarefa=Tarefa{codigo='TAR2', designacao='ArranjarJardim', categoria='Jardinagem'}}, dataCandidatura=Mon Jan 27 00:00:00 GMT 2020, valorPretendido=1000.0, media=5.0, desvio=0.0}, Candidatura{freelancer=Freelancer{nome='a', nif='nif3', telefone='917483989', email='joao@gmail.com'}, anuncio=Anuncio{codigo='ANUNC2', tarefa=Tarefa{codigo='TAR2', designacao='ArranjarJardim', categoria='Jardinagem'}}, dataCandidatura=Sun Jan 26 00:00:00 GMT 2020, valorPretendido=1000.0, media=4.0, desvio=5.338539126015656}, Candidatura{freelancer=Freelancer{nome='JoaoEscritor', nif='nif1', telefone='917483989', email='joao@gmail.com'}, anuncio=Anuncio{codigo='ANUNC2', tarefa=Tarefa{codigo='TAR2', designacao='ArranjarJardim', categoria='Jardinagem'}}, dataCandidatura=Sun Jan 26 00:00:00 GMT 2020, valorPretendido=2000.0, media=3.0, desvio=3.6742346141747673}";
        ArrayList<String> obtido1 = new ArrayList<>();
        obtido1.add(st1);
        assertEquals(esperado1.toString(), obtido1.toString());
        assertNotNull(esperado1);

        ArrayList<Candidatura> esperado2 =new ArrayList<>();
        assertNotEquals(esperado1,esperado2);
    }
}