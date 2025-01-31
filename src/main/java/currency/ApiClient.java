package currency;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject; // Add a JSON library to parse API responses

public class ApiClient {

    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/";

    public static double getExchangeRate(String fromCurrency, String toCurrency) throws IOException, InterruptedException {
        // Build the API URL
        String url = API_URL + fromCurrency;

        // Create an HTTP client
        HttpClient client = HttpClient.newHttpClient();

        // Build an HTTP GET request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        // Send the request and get the response
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Parse the JSON response
        JSONObject jsonResponse = new JSONObject(response.body());

        // Extract the exchange rate
        if (jsonResponse.has("rates")) {
            JSONObject rates = jsonResponse.getJSONObject("rates");
            return rates.getDouble(toCurrency);
        } else {
            throw new IllegalArgumentException("Invalid response from the API");
        }
    }
}
