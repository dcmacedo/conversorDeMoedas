package br.com.danilo.menu;

import br.com.danilo.modelos.ParDeMoeda;

import java.util.Scanner;

public class Menu {

    private final ParDeMoeda[] paresDeMoedas = {
            new ParDeMoeda("USD", "EUR"),
            new ParDeMoeda("USD", "BRL"),
            new ParDeMoeda("BRL", "EUR"),
            new ParDeMoeda("BRL", "USD"),
            new ParDeMoeda("EUR", "USD"),
            new ParDeMoeda("EUR", "BRL")
    };

    public int displayMenu(){
        Scanner opcao = new Scanner(System.in);

        while (true){
            System.out.println("Escolha uma opção para converter:");

            for (int i = 0; i < paresDeMoedas.length; i++) {
                System.out.println((i + 1) + ". " +
                        paresDeMoedas[i].fromMoeda() + "/" + paresDeMoedas[i].toMoeda());
            }
            System.out.println("0. SAIR");

            System.out.println("\nOpção: ");
            int escolha = opcao.nextInt();

            if (escolha == 0){
                return escolha;
            }

            if (escolha < 1 || escolha > paresDeMoedas.length){
                System.out.println("Opção Inválida.");
                continue;
            }

            return escolha;
        }
    }
}
