import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarDinero {
    public DineroAPI convertirDinero(String valor) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/99cb11694365e07b31f66a0c/latest/" + valor);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), DineroAPI.class);
        }catch (Exception e){
            throw new RuntimeException("No hay valor");
        }
    }
}
