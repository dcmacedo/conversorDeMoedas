package br.com.danilo.conexao;

import br.com.danilo.modelos.Conversor;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConverterMoedaApi {

    public Conversor buscaConversor(){
        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/e574b9bf3b07f41cec793c00/pair/USD/BRL/50.00");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request,HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Conversor.class);
        } catch (Exception e){
            throw new RuntimeException("Não foi possivel obter a cotação!");
        }
    }
}