package br.com.danilo.conexao;

import br.com.danilo.modelos.Conversor;
import com.google.gson.*;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConverterMoedaApi {

    public Conversor buscaConversor(String baseCode, String targetCode, double valor){
        String BASE_URL = "https://v6.exchangerate-api.com/v6/";
        String API_KEY = "e574b9bf3b07f41cec793c00";

        URI endereco = URI.create(BASE_URL + API_KEY + "/pair/" + baseCode + "/" + targetCode + "/" + valor);

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