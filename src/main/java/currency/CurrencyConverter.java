package currency;

import java.io.IOException;

public class CurrencyConverter {

    public static double convert(String fromCurrency, String toCurrency, double amount) {
        try {
            // Get exchange rate from the API client
            double exchangeRate = ApiClient.getExchangeRate(fromCurrency, toCurrency);

            // Perform conversion
            return amount * exchangeRate;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return -1; // Return -1 to indicate an error
        }
    }
}
