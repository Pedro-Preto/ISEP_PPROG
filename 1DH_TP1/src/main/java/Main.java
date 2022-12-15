
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 1190956, 1190963
 */
public class Main {

    public static void main(String[] args) {

        double totalAmount = 0;
        double interest = 0;
        
        //alineas a e b
        CreditoBancario[] lista = new CreditoBancario[100];
        int contador = 0;

        CreditoHabitacao hab1 = new CreditoHabitacao("Pedro", "dev", 300, 6, 0.119);

        CreditoHabitacao hab2 = new CreditoHabitacao();

        lista[contador] = hab1;
        contador++;
        lista[contador] = hab2;
        contador++;

        CreditoAutomovel auto1 = new CreditoAutomovel("a", "dev", 300, 6);

        CreditoAutomovel auto2 = new CreditoAutomovel();

        lista[contador] = auto1;
        contador++;
        lista[contador] = auto2;
        contador++;

        CreditoEducacao ed1 = new CreditoEducacao("Pedro", "dev", 300, 6, 3);

        CreditoEducacao ed2 = new CreditoEducacao();

        lista[contador] = ed1;
        contador++;
        lista[contador] = ed2;
        contador++;

        //alinea c
        for (int i = 0; i < contador; i++) {
            if (lista[i] != null) {
                System.out.printf("Client's name: %s; Amount the bank will receive at the end of the credit: %.2f eur\n", lista[i].getNome(), lista[i].calcularMontanteAReceberPorCadaCredito());
            }
        }

        for (int i = 0; i < contador; i++) {
            if (lista[i] != null) {
                System.out.printf("Client's name: %s; Interest amount: %.2f eur\n", lista[i].getNome(), lista[i].calcularMontanteTotalJuros());
            }
        }

        //alinea d
        System.out.printf("Number of home credits: %s\n", CreditoHabitacao.getContador());

        System.out.printf("Number of consumer credits: %s\n", CreditoConsumo.getContador());

        //alinea e
        for (int i = 0; i < contador; i++) {
            if (lista[i] != null) {
                totalAmount += lista[i].calcularMontanteAReceberPorCadaCredito();
                interest += lista[i].calcularMontanteTotalJuros();
            }
        }
        System.out.printf("Total amount the bank will receive for all the bank credtis made: %.2f eur\nTotal interest the bank will receive for all the bank credtis made: %.2f eur\n", totalAmount, interest);
    }
}
