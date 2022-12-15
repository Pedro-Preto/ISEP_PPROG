/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1190956, 1190963
 */
public abstract class CreditoBancario {

    private String nome;
    private String profissao;
    private double montante;
    private int prazo;

    private static final String NOME_POR_OMISSAO = "Not Specified";
    private static final String PROFISSAO_POR_OMISSAO = "Not Specified";
    private static final double MONTANTE_POR_OMISSAO = 0;
    private static final int PRAZO_POR_OMISSAO = 1;

    /**
     * Construtor da classe CreditoBancario, com todos os parametros preenchidos
     *
     * @param nome o nome do cliente do credito bancario
     * @param profissao a profissao do cliente do credito bancario
     * @param montante o montante que o cliente pedio no credito bancario
     * @param prazo o prazo que o cliente tem para pagar o credito bancario
     */
    public CreditoBancario(String nome, String profissao, double montante, int prazo) {
        this.nome = nome;
        this.profissao = profissao;
        this.montante = montante;
        this.prazo = prazo;
    }

    /**
     * Construtor da classe CreditoBancario, sem nenhum dos parametros
     * preenchidos todos os atributos tomam os valores predefinidos quando
     * nenhum valor e especificado
     */
    public CreditoBancario() {
        this.nome = NOME_POR_OMISSAO;
        this.profissao = PROFISSAO_POR_OMISSAO;
        this.montante = MONTANTE_POR_OMISSAO;
        this.prazo = PRAZO_POR_OMISSAO;
    }

    /**
     * Retorna o nome do cliente (String)
     *
     * @return nome do cliente
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna a profissao do cliente (String)
     *
     * @return profissao do cliente
     */
    public String getProfissao() {
        return profissao;
    }

    /**
     * Retorna o montante pedido pelo cliente em euros (double)
     *
     * @return montante requisitado
     */
    public double getMontante() {
        return montante;
    }

    /**
     * Retorna o prazo que o cliente tem para pagar em meses (int)
     *
     * @return prazo de pagamento
     */
    public int getPrazo() {
        return prazo;
    }

    /**
     * Define a String passada por parametro como o atributo nome
     *
     * @param nome nome do cliente
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Define a String passada por parametro como o atributo profissao
     *
     * @param profissao profissao do cliente
     */
    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    /**
     * Define o double passado por parametro como o atributo montante
     *
     * @param montante montante requisitado
     */
    public void setMontante(double montante) {
        this.montante = montante;
    }

    /**
     * Define o int passado por parametro como o atributo prazo
     *
     * @param prazo prazo de pagamento
     */
    public void setPrazo(int prazo) {
        this.prazo = prazo;
    }

    /**
     * Metodo abstrato, a implementar nas sublcasses que calcula a amortizacao
     * mensal (double) que o cliente deve fazer
     *
     * @return amortizacao que e feita mensalmente
     */
    public abstract double getAmortizacaoMensal();

    /**
     * Calcula a taxa de juros mensal (double), dividindo a taxa de juros anual
     * por 12 (12 meses de um ano)
     *
     * @return taxa de juros mensal
     */
    public double calcularTaxaJurosMensal(double taxaJuroAnual) {
        return taxaJuroAnual / 12;
    }

    /**
     * Escreve a informacao do objeto em formato string
     *
     * @return string com a informacao do objeto
     */
    @Override
    public String toString() {
        return String.format("Nome: %s\nProfissao: %s\nMontante: %s\nPrazo: %s\n", nome, profissao, montante, prazo);
    }

    /**
     * Metodo abstrato, a ser implementado nas subclasses, que calcula o
     * montante total que o cliente tem que pagar
     *
     * @return montante a pagar por cada credito
     */
    public abstract double calcularMontanteAReceberPorCadaCredito();

    /**
     * Metodo abstrato, a ser implementado nas subclasses, que calcula o
     * montante de juros que o cliente tem de pagar
     *
     * @return montante de juros a pagar por cada credito
     */
    public abstract double calcularMontanteTotalJuros();

}
