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
public class CreditoEducacaoTest extends TestCase {
    
    public CreditoEducacaoTest(String testName) {
        super(testName);
    }
    /**
     * Test of calcularMontanteAReceberPorCadaCredito method, of class CreditoEducacao.
     */
    public void testCalcularMontanteAReceberPorCadaCredito() {
        System.out.println("calcularMontanteAReceberPorCadaCredito");
        CreditoEducacao ce = new CreditoEducacao("a", "a", 300, 6, 3);
        double expResult = 302.5;
        double result = ce.calcularMontanteAReceberPorCadaCredito();
        assertEquals(expResult, result, 0.001);
    }

    /**
     * Test of calcularMontanteTotalJuros method, of class CreditoEducacao.
     */
    public void testCalcularMontanteTotalJuros() {
        System.out.println("calcularMontanteTotalJuros");
        CreditoEducacao ce = new CreditoEducacao("a", "a", 300, 6, 3);
        double expResult = 2.5;
        double result = ce.calcularMontanteTotalJuros();
        assertEquals(expResult, result, 0.001);
    }
    
}
