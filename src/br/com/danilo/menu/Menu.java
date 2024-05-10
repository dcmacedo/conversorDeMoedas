package br.com.danilo.menu;

import br.com.danilo.conexao.ConverterMoedaApi;
import br.com.danilo.modelos.Conversor;
import br.com.danilo.modelos.ParDeMoeda;

import java.util.Scanner;

public class Menu {

    private final ParDeMoeda[] paresDeMoedas = {
            new ParDeMoeda("Dólar Americano USD", "Real Brasileiro BRL"),
            new ParDeMoeda("Real Brasileiro BRL", "Boliviano Boliviano BOB"),
            new ParDeMoeda("Dólar Americano USD", "Peso Argentino ARS"),
            new ParDeMoeda("Peso Argentino ARS", "Peso Chileno CLP"),
            new ParDeMoeda("Real Brasileiro BRL", "Peso Colombiano COP"),
            new ParDeMoeda("Peso Argentino ARS", "Real Brasileiro BRL")
    };

    public void displayMenu(){
        Scanner opcao = new Scanner(System.in);
        int escolha = 0;
        ConverterMoedaApi conversor = new ConverterMoedaApi();

        String menu = """
        *********************************************************
                     Bem vindo(a) ao Conversor de Moeda
        *********************************************************
                    
        Escolha uma opção para converter:
        """;

        while (escolha != paresDeMoedas.length + 1){
            try {
                System.out.println(menu);
                for (int i = 0; i < paresDeMoedas.length; i++) {
                    System.out.println((i + 1) + ". " +
                            paresDeMoedas[i].fromMoeda() + " para >>>> " + paresDeMoedas[i].toMoeda());
                }
                System.out.println(paresDeMoedas.length + 1 + ". SAIR");
                System.out.println("\nOpção: ");

                escolha = opcao.nextInt();
                double valor;

                switch (escolha){
                    case 1:
                        System.out.println("Digite o valor");
                        valor = opcao.nextDouble();
                        Conversor usdBrl = conversor.buscaConversor("USD", "BRL", valor);
                        System.out.println("\nVocê selecionou a opção 1. Dólar Americano para Real Brasileiro");
                        System.out.println("O valor de: " + valor
                                + " USD convertido para real é: " + usdBrl.conversion_result() + " BRL");
                        System.out.println(" ");
                        break;
                    case 2:
                        System.out.println("Digite o valor");
                        valor = opcao.nextDouble();
                        Conversor brlBob = conversor.buscaConversor("BRL", "BOB", valor);
                        System.out.println("\nVocê selecionou a opção 2. Real Brasileiro para Boliviano Boliviano");
                        System.out.println("O valor de: " + valor
                                + " BRL convertido para boliviano boliviano é: " + brlBob.conversion_result() + " BOB");
                        System.out.println(" ");
                        break;
                    case 3:
                        System.out.println("Digite o valor");
                        valor = opcao.nextDouble();
                        Conversor usdArs = conversor.buscaConversor("USD", "ARS", valor);
                        System.out.println("\nVocê selecionou a opção 3. Dólar Americano para Peso Argentino");
                        System.out.println("O valor de: " + valor
                                + " USD convertido para peso argentino é: " + usdArs.conversion_result() + " ARS");
                        System.out.println(" ");
                        break;
                    case 4:
                        System.out.println("Digite o valor");
                        valor = opcao.nextDouble();
                        Conversor arsClp = conversor.buscaConversor("ARS", "CLP", valor);
                        System.out.println("\nVocê selecionou a opção 4. Peso Argentino para Peso Chileno");
                        System.out.println("O valor de: " + valor
                                + " ARS convertido para peso chileno é: " + arsClp.conversion_result() + " CLP");
                        System.out.println(" ");
                        break;
                    case 5:
                        System.out.println("Digite o valor");
                        valor = opcao.nextDouble();
                        Conversor brlCop = conversor.buscaConversor("BRL", "COP", valor);
                        System.out.println("\nVocê selecionou a opção 5. Real Brasileiro para Peso Colombiano");
                        System.out.println("O valor de: " + valor
                                + " BRL convertido para peso colombiano é: " + brlCop.conversion_result() + " COP");
                        System.out.println(" ");
                        break;
                    case 6:
                        System.out.println("Digite o valor");
                        valor = opcao.nextDouble();
                        Conversor arsBrl = conversor.buscaConversor("ARS", "BRL", valor);
                        System.out.println("\nVocê selecionou a opção 6. Peso Argentino para Real Brasileiro");
                        System.out.println("O valor de: " + valor
                                + " ARS convertido para real é: " + arsBrl.conversion_result() + " BRL");
                        System.out.println(" ");
                        break;
                }

                if (escolha > paresDeMoedas.length + 1){
                        System.out.println("Opção inválida.");
                        System.out.println("Digite uma das opções do menu!");
                }

            } catch (Exception e) {
                System.out.println("Não consegui converter, verifique se vc digitou o valor correto");
                break;
            }
        }
        System.out.println("Finalizando a Aplicação");
    }
}
