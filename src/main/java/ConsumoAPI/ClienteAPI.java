package ConsumoAPI;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class ClienteAPI {
    private static final String API_KEY = "1b024613c820721231258107";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";
    private final HttpClient httpClient;
    private final Gson gson;

    public ClienteAPI() {
        // Construyendo el Cliente para Solicitudes (HttpClient)
        this.httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .build();
        this.gson = new Gson();
    }

    public RespuestaAPI obtenerTasasDeCambio(String monedaBase) throws IOException, InterruptedException {
        // Construyendo la solicitud (HttpRequest)
        String url = BASE_URL + API_KEY + "/latest/" + monedaBase;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .timeout(Duration.ofSeconds(30))
                .header("Accept", "application/json")
                .GET()
                .build();

        // Construyendo la respuesta (HttpResponse)
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        // Verificar el código de estado
        if (response.statusCode() != 200) {
            throw new RuntimeException("Error en la API: Código de estado " + response.statusCode());
        }

        // Analizando la respuesta en formato JSON con Gson
        return gson.fromJson(response.body(), RespuestaAPI.class);
    }

    public double obtenerTasaEspecifica(String monedaBase, String monedaDestino)
            throws IOException, InterruptedException {
        RespuestaAPI respuesta = obtenerTasasDeCambio(monedaBase);

        // Filtrando las monedas
        if (respuesta.getConversion_rates().containsKey(monedaDestino)) {
            return respuesta.getConversion_rates().get(monedaDestino);
        } else {
            throw new RuntimeException("modelos.Moneda destino no encontrada: " + monedaDestino);
        }
    }
}
