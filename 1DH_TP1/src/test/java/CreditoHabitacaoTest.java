/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import junit.framework.TestCase;

/**
 *
 * @author 1190956, 1190963
 */
public class CreditoHabitacaoTest extends TestCase {
    
    public CreditoHabitacaoTest(String testName) {
        super(testName);
    }
    /**
     * Test of calcularMontanteAReceberPorCadaCredito method, of class CreditoHabitacao.
     */
    public void testCalcularMontanteAReceberPorCadaCredito() {
        System.out.println("calcularMontanteAReceberPorCadaCredito");
        CreditoHabitacao ch = new CreditoHabitacao("a", "a", 300, 6, 0.119);
        double expResult = 310.5;
        double result = ch.calcularMontanteAReceberPorCadaCredito();
        assertEquals(expResult, result, 0.001);
    }

    /**
     * Test of calcularMontanteTotalJuros method, of class CreditoHabitacao.
     */
    public void testCalcularMontanteTotalJuros() {
        System.out.println("calcularMontanteTotalJuros");
        CreditoHabitacao ch = new CreditoHabitacao("a", "a", 300, 6, 0.119);
        double expResult = 10.5;
        double result = ch.calcularMontanteTotalJuros();
        assertEquals(expResult, result, 0.001);
    }
    
}
