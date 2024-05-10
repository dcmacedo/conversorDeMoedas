package br.com.danilo.conexao;

import br.com.danilo.credenciais.ApiKey;
import br.com.danilo.modelos.Conversor;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class ConverterMoedaApi {

    ApiKey apiKey = new ApiKey();

    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";
    private String baseCode;
    private String targetCode;
    private double amount;
    private double conversion_result;
    private double conversion_rate;
    private List<Conversor> conversorList = new ArrayList<>();

    public void Api(Conversor conversor) {
        this.baseCode = conversor.base_code();
        this.targetCode = conversor.target_code();
        this.amount = conversor.valor();
        this.conversion_rate = conversor.conversion_rate();
        this.conversion_result = conversor.conversion_result();
    }

    public String callApi(){
        try {
            String uriQuery = apiKey + "/pair/" + baseCode + "/" + targetCode + "/" + amount;
            URI uri = URI.create(BASE_URL + uriQuery);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest
                    .newBuilder()
                    .uri(uri)
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200){
                return "Erro na chamada da API: " + response.statusCode();
            }

            String jsonResponse = response.body();
            Gson gson = new Gson();
            Conversor conversor = gson.fromJson(jsonResponse, Conversor.class);
            conversorList.add(conversor);

            return conversor.toString();

        } catch (Exception e){
            return "Erro na chamada da API: " + e.getMessage();
        }
    }

    public List<Conversor> getConversorList() {
        return conversorList;
    }
}