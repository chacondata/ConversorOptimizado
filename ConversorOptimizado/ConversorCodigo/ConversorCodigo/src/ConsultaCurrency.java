import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCurrency {
    public MonedaAconvertir  buscarTasaDeConversion(String monedaBase,String monedaTarget){

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/bc7971ed062db906d6782382/pair/" + monedaBase + "/" + monedaTarget);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(),MonedaAconvertir.class);
        }
        catch (Exception  e){
            throw new RuntimeException("Codigo de moneda no valido");
        }
    }
}