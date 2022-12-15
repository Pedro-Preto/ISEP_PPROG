/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1190956, 1190963
 */
public class CreditoAutomovel extends CreditoConsumo {

    private static double descontoDePrazo = 0.01;
    private static double taxaJuroAnual = 0.06;

    /**
     * Construtor da classe CreditoAutomovel, com todos os parametros
     * preenchidos
     *
     * @param nome o nome do cliente do credito de automovel
     * @param profissao a profissao do cliente do credito de automovel
     * @param montante o montante que o cliente pedio no credito de automovel
     * @param prazo o prazo que o cliente tem para pagar o credito de automovel
     */
    public CreditoAutomovel(String nome, String profissao, double montante, int prazo) {
        super(nome, profissao, montante, prazo);
    }

    /**
     * Construtor da classe CreditoComsumo, sem nenhum dos parametros
     * preenchidos todos os atributos tomam os valores predefinidos quando
     * nenhum valor e especificado
     */
    public CreditoAutomovel() {
        super();
    }

    /**
     * Retorna a taxa de juro anual (double)
     *
     * @return taxa de juros anual
     */
    public double getTaxaJuroAnual() {
        return taxaJuroAnual;
    }

    /**
     * Retorna o desconto, quando o prazo e inferior a 24 meses (double)
     *
     * @return desconto a aplicar quando o prazo e inferior a 24 meses
     */
    public double getDescontoDePrazo() {
        return descontoDePrazo;
    }

    /**
     * Define o double passado por parametro como o atributo taxaJuroAnual
     *
     * @param taxaJuroAnual taxa de juros a pagar anualmente
     */
    public void setTaxaJuroAnual(double taxaJuroAnual) {
        this.taxaJuroAnual = taxaJuroAnual;
    }

    /**
     * Define o double passado por parametro como o atributo descontoDePrazo
     *
     * @param descontoDePrazo desconto aplicado quando o prazo e inferior a 24
     * meses
     */
    public void setDescontoDePrazo(double descontoDePrazo) {
        this.descontoDePrazo = descontoDePrazo;
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
     * @return string com informacao do objeto
     */
    @Override
    public String toString() {
        return String.format(super.toString() + "Desconto: %s\nTaxa de Juros Anual: %s\n", descontoDePrazo, taxaJuroAnual);
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
        double prestacaoMensal;
        double valorDesconto;
        for (int i = 1; i <= getPrazo(); i++) {
            juros = valor * calcularTaxaJurosMensal(taxaJuroAnual);
            prestacaoMensal = getAmortizacaoMensal() + juros;
            valorDesconto = 0;
            if (getPrazo() <= 24) {
                valorDesconto = prestacaoMensal * descontoDePrazo;
            }
            somaJuros += (juros - valorDesconto);
            valor = valor - getAmortizacaoMensal();
        }
        return somaJuros;
    }

}
