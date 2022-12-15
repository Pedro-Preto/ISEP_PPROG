/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1190956, 1190963
 */
public class CreditoHabitacao extends CreditoBancario {

    private static int contador = 0;
    private static double taxaEuribor = 0.001;

    private double spread;

    private static final double SPREAD_POR_OMISSAO = 0;

    /**
     * Construtor da classe CreditoHabitacao, com todos os parametros
     * preenchidos
     *
     * @param nome o nome do cliente do credito de habitacao
     * @param profissao a profissao do cliente do credito de habitacao
     * @param montante o montante que o cliente pedio no credito de habitacao
     * @param prazo o prazo que o cliente tem para pagar o credito de habitacao
     * @param spread o spread e uma taxa acordada com o cliente
     */
    public CreditoHabitacao(String nome, String profissao, double montante, int prazo, double spread) {
        super(nome, profissao, montante, prazo);
        this.spread = spread;
        contador++;
    }

    /**
     * Construtor da classe CreditoHabitacao, sem nenhum dos parametros
     * preenchidos todos os atributos tomam os valores predefinidos quando
     * nenhum valor e especificado
     */
    public CreditoHabitacao() {
        super();
        this.spread = SPREAD_POR_OMISSAO;
        contador++;
    }

    /**
     * Retorna o spread acordado com o cliente (double)
     *
     * @return taxa acordada com o cliente
     */
    public double getSpread() {
        return spread;
    }

    /**
     * Retorna a taxa euribor (double)
     *
     * @return taxa euribor
     */
    public double getTaxaEuribor() {
        return taxaEuribor;
    }

    /**
     * Retorna o contador, que e o numero de creditos de habitacao criados (int)
     *
     * @return numero de creditos deste tipo
     */
    public static int getContador() {
        return contador;
    }

    /**
     * Define o double passado por parametro como o atributo spread
     *
     * @param spread taxa acordada com o cliente
     */
    public void setSpread(double spread) {
        this.spread = spread;
    }

    /**
     * Define o double passado por parametro como o atributo taxaEuribor
     * 
     * @param taxaEuribor taxa euribor
     */
    public void setTaxaEuribor(double taxaEuribor) {
        this.taxaEuribor = taxaEuribor;
    }

    /**
     * Define o double passado por parametro como o atributo contador
     *
     * @param numero numero de creditos deste tipo
     */
    public static void setContador(int numero) {
        contador = numero;
    }

    /**
     * Calcula a taxa de juros anual (double), somando a taxa euribor ao spread
     *
     * @return taxa de juros anual
     */
    public double calcularTaxaJurosAnual() {
        return taxaEuribor + spread;
    }

    /**
     * Calcula a amortizacao mensal (double) que o cliente deve fazer, dividindo
     * o montante total (do imprestimo) pelo prazo (numero de meses)
     *
     * @return amortizacao que e feita mensalmente
     */
    public double getAmortizacaoMensal() {
        return getMontante() / (double) getPrazo();
    }

    /**
     * Escreve a informacao do objeto em formato string
     *
     * @return string com a informacao do objeto
     */
    @Override
    public String toString() {
        return String.format(super.toString() + "Taxa Euribor: %s\nSpread: %s\n", taxaEuribor, spread);
    }

    /**
     * Calcula o montante total que o cliente tem de pagar, somando ao montante
     * requesitado, ao total de juros que o cliente tem de pagar
     *
     * @return montante a pagar por cada credito
     */
    @Override
    public double calcularMontanteAReceberPorCadaCredito() {
        return getMontante() + calcularMontanteTotalJuros();
    }

    /**
     * Calcula o montante de juros que o cliente tem de pagar
     *
     * @return montante de juros a pagar por cada credito
     */
    @Override
    public double calcularMontanteTotalJuros() {
        double valor = getMontante();
        double juros, somaJuros = 0;
        for (int i = 1; i <= getPrazo(); i++) {
            juros = valor * calcularTaxaJurosMensal(calcularTaxaJurosAnual());
            somaJuros += juros;
            valor = valor - getAmortizacaoMensal();
        }
        return somaJuros;
    }

}
