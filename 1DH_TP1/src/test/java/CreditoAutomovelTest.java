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
public class CreditoAutomovelTest extends TestCase {
    
    public CreditoAutomovelTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
    /**
     * Test of calcularMontanteAReceberPorCadaCredito method, of class CreditoAutomovel.
     */
    public void testCalcularMontanteAReceberPorCadaCredito() {
        System.out.println("calcularMontanteAReceberPorCadaCredito");
        CreditoAutomovel ca = new CreditoAutomovel("a", "a", 300, 6);
        double expResult = 302.1975;
        double result = ca.calcularMontanteAReceberPorCadaCredito();
        assertEquals(expResult, result, 0.001);
    }

    /**
     * Test of calcularMontanteTotalJuros method, of class CreditoAutomovel.
     */
    public void testCalcularMontanteTotalJuros() {
        System.out.println("calcularMontanteTotalJuros");
        CreditoAutomovel ca = new CreditoAutomovel("a", "a", 300, 6);
        double expResult = 2.1975;
        double result = ca.calcularMontanteTotalJuros();
        assertEquals(expResult, result, 0.001);
    }

    /**
     * Test of getTaxaJuroAnual method, of class CreditoAutomovel.
     */
    public void testGetTaxaJuroAnual() {
        System.out.println("getTaxaJuroAnual");
        CreditoAutomovel instance = new CreditoAutomovel();
        double expResult = 0.0;
        double result = instance.getTaxaJuroAnual();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescontoDePrazo method, of class CreditoAutomovel.
     */
    public void testGetDescontoDePrazo() {
        System.out.println("getDescontoDePrazo");
        CreditoAutomovel instance = new CreditoAutomovel();
        double expResult = 0.0;
        double result = instance.getDescontoDePrazo();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTaxaJuroAnual method, of class CreditoAutomovel.
     */
    public void testSetTaxaJuroAnual() {
        System.out.println("setTaxaJuroAnual");
        double taxaJuroAnual = 0.0;
        CreditoAutomovel instance = new CreditoAutomovel();
        instance.setTaxaJuroAnual(taxaJuroAnual);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescontoDePrazo method, of class CreditoAutomovel.
     */
    public void testSetDescontoDePrazo() {
        System.out.println("setDescontoDePrazo");
        double descontoDePrazo = 0.0;
        CreditoAutomovel instance = new CreditoAutomovel();
        instance.setDescontoDePrazo(descontoDePrazo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAmortizacaoMensal method, of class CreditoAutomovel.
     */
    public void testGetAmortizacaoMensal() {
        System.out.println("getAmortizacaoMensal");
        CreditoAutomovel instance = new CreditoAutomovel();
        double expResult = 0.0;
        double result = instance.getAmortizacaoMensal();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class CreditoAutomovel.
     */
    public void testToString() {
        System.out.println("toString");
        CreditoAutomovel instance = new CreditoAutomovel();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
