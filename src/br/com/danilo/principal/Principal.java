package br.com.danilo.principal;

import br.com.danilo.conexao.ConverterMoedaApi;
import br.com.danilo.modelos.Conversor;

public class Principal {
    public static void main(String[] args) {
        ConverterMoedaApi conversor = new ConverterMoedaApi();

        try {
            Conversor novoConversor = conversor.buscaConversor();
            System.out.println(novoConversor);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
