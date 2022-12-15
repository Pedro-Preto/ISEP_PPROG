/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pedro
 */
public class Olxyz {

    public static void main(String[] args) {

        //alineas 1.e 2.e 3.
        Anunciante[] lista = new Anunciante[5];

        

        //Endereços dos Anunciantes
        Endereco endereco_a1 = new Endereco("Rua de São João", 4050_553, "Porto");        
        Endereco endereco_a2 = new Endereco("Rua de Santa Marta", 1050_199, "Lisboa");
        Endereco endereco_a3 = new Endereco("Rua de São Pedro", 1100_551, " Lisboa");
       
        //Anunciantes 
        int contador = 3;
        lista[0] = new Anunciante("Pedro", endereco_a1);
        lista[1] = new Anunciante("Miguel", endereco_a2);
        lista[2] = new Anunciante("Joana", endereco_a3);
       
       
        //Endereços dos Apartamentos
        Endereco endereco_ap1 = new Endereco("Rua dos Girassóis", 4510_762, "São Pedro da Cova");
        Endereco endereco_ap2 = new Endereco("Rua das Rosas", 4050_262, "Porto");
        Endereco endereco_ap3 = new Endereco("Rua das Margaridas", 4935_134, "Viana do Castelo");
        Endereco endereco_ap4 = new Endereco("Rua das Tulipas", 4935_132, "Viana do Castelo");

        //Artigos à Venda e para Alugar
        Apartamento Cenoura = new Apartamento(endereco_ap1, 70, 200);
        Apartamento Banana = new Apartamento(endereco_ap2, 80, 250);
        Apartamento Limao = new Apartamento(endereco_ap3, 90, 300);
        Apartamento Peras = new Apartamento(endereco_ap4, 100, 350);

        Telemovel Samsung = new Telemovel("GalaxyS20", 920);
        Telemovel Apple = new Telemovel("iPhone11", 820);

        Automovel carro1 = new Automovel("Audi", "R8", 160000, 980);
        Automovel carro2 = new Automovel("BMW ", "i8", 157970, 950);

        lista[0].adicionarVendavel(Samsung);
        lista[0].adicionarAlugavel(Cenoura);
        lista[0].adicionarAlugavel(carro1);
        
        lista[1].adicionarVendavel(carro2);
        lista[1].adicionarVendavel(Apple);
        lista[1].adicionarAlugavel(Banana);
                
        lista[2].adicionarAlugavel(Limao);
        lista[2].adicionarAlugavel(Peras);
        
        //5. Visualizar a quantidade de artigos disponíveis para aluguer na plataforma Olxyz;
        System.out.println("5.");
        int disponiveisAluguer = 0;
        for (int i = 0; i < contador; i++) {
            disponiveisAluguer += lista[i].getQuantidadeAlugaveis();
        }
        System.out.println(String.format("Existem %d artigos disponiveis para aluguer",disponiveisAluguer));
        
        //6. Visualizar, para cada Anunciante que publicita vendas, o respetivo nome, endereco e o somatório das suas possíveis vendas;
        System.out.println("6.");
        double valorPossivelVendas;
        for (int i = 0; i < contador; i++) {            
            valorPossivelVendas = lista[i].getValorPossivelVendas();
            if (valorPossivelVendas != 0 ) {                
                System.out.println(String.format("O anunciante %s (%s) tem um valor possivel de vendas %f", lista[i].getNome(), lista[i].getEndereco(), valorPossivelVendas));
            }

        }

        //7. Visualizar, para cada Anunciante, o seu alugável (se existir) que pode gerar maior lucro à Olxyz (quem, o quê e quanto).  
        System.out.println("7.");
        Alugavel a = null, tmp;
        int idx = -1;
        for (int i = 0; i < contador; i++) {                  
            tmp = lista[i].getAlugavelMaisCaro();
            if (tmp != null) {
                if (a == null) {
                    a = tmp;
                    idx = i;
                } else {                    
                    if (tmp.getValorAluguer() > a.getValorAluguer() ) {                    
                        a = tmp;
                        idx = i;    
                    }
                }
            }                        
        }
        
        if (a != null) {
            System.out.println(String.format("O anunciante %s tem o artigo %s com o valor de aluguer %f (lucro %f)", 
                    lista[idx].getNome(), a, a.getValorAluguerComTaxa(),a.getValorAluguerComTaxa()-a.getValorAluguer() ));
        } else {
            System.out.println("Não tem artigos para aluguer!");
        }
        
        
    }

}
