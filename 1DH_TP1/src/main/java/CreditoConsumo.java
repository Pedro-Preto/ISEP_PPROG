/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1190956, 1190963
 */
public abstract class CreditoConsumo extends CreditoBancario {

    private static int contador = 0;

    /**
     * Construtor da classe CreditoConsumo, com todos os parametros preenchidos
     *
     * @param nome o nome do cliente do credito de consumo
     * @param profissao a profissao do cliente do credito de consumo
     * @param montante o montante que o cliente pedio no credito de consumo
     * @param prazo o prazo que o cliente tem para pagar o credito de consumo
     */
    public CreditoConsumo(String nome, String profissao, double montante, int prazo) {
        super(nome, profissao, montante, prazo);
        contador++;
    }

    /**
     * Construtor da classe CreditoComsumo, sem nenhum dos parametros
     * preenchidos todos os atributos tomam os valores predefinidos quando
     * nenhum valor e especificado
     */
    public CreditoConsumo() {
        super();
        contador++;
    }

    /**
     * Retorna o contador, que e o numero de creditos de habitacao criados (int)
     *
     * @return contador de creditos deste tipo
     */
    public static int getContador() {
        return contador;
    }

    /**
     * Define o double passado por parametro como o atributo contador
     *
     * @param numero numero de creditos deste tipo
     */
    public static void setContador(int numero) {
        contador = numero;
    }
}
