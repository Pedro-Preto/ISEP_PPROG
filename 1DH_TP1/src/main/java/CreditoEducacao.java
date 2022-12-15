/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1190956, 1190963
 */
public class CreditoEducacao extends CreditoConsumo {

    private int periodoCarencia;
    private static double taxaJuroAnual = 0.02;

    private static final int PERIODO_CARENCIA_POR_OMISSAO = 0;

    /**
     * Construtor da classe CreditoEducacao, com todos os parametros preenchidos
     *
     * @param nome o nome do cliente do credito de automovel
     * @param profissao a profissao do cliente do credito de automovel
     * @param montante o montante que o cliente pedio no credito de automovel
     * @param prazo o prazo que o cliente tem para pagar o credito de automovel
     * @param periodoCarencia o periodo acordado com o cliente no qual este nao
     * amortiza
     */
    public CreditoEducacao(String nome, String profissao, double montante, int prazo, int periodoCarencia) {
        super(nome, profissao, montante, prazo);
        this.periodoCarencia = periodoCarencia;
    }

    /**
     * Construtor da classe CreditoEducacao, sem nenhum dos parametros
     * preenchidos todos os atributos tomam os valores predefinidos quando
     * nenhum valor e especificado
     */
    public CreditoEducacao() {
        super();
        this.periodoCarencia = PERIODO_CARENCIA_POR_OMISSAO;
    }

    /**
     * Calcula a amortizacao mensal (double) que o cliente deve fazer, dividindo
     * o montante total (do imprestimo) pelo prazo que o cliente tem para pagar,
     * tirando o periodo de carencia (numero de meses)
     *
     * @return amortizacao que e feita mensalmente
     */
    public double getAmortizacaoMensal() {
        return getMontante() / (double) (getPrazo() - periodoCarencia);
    }

    /**
     * Escreve a informacao do objeto em formato string
     *
     * @return string com informacao do objeto
     */
    @Override
    public String toString() {
        return String.format(super.toString() + "Periodo de Carencia: %s\nTaxa de Juros Anual: %s\n", periodoCarencia, taxaJuroAnual);
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
        double somaJuros = 0;
        for (int i = 1; i <= getPrazo(); i++) {
            somaJuros += valor * calcularTaxaJurosMensal(taxaJuroAnual);
            if (i > periodoCarencia) {
                valor = valor - getAmortizacaoMensal();
            }
        }
        return somaJuros;
    }

}
