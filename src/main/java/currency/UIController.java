package currency;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class UIController {

    @FXML
    private ComboBox<String> fromCurrencyBox;

    @FXML
    private ComboBox<String> toCurrencyBox;

    @FXML
    private TextField amountField;

    @FXML
    private Button convertButton;

    @FXML
    private Label resultLabel;

    @FXML
    private Label errorLabel;

    @FXML
    public void initialize() {
        // Populate the ComboBoxes with some common currencies
        fromCurrencyBox.getItems().addAll("USD", "EUR", "INR", "GBP", "JPY", "CAD");
        toCurrencyBox.getItems().addAll("USD", "EUR", "INR", "GBP", "JPY", "CAD");

        // Set default values
        fromCurrencyBox.setValue("USD");
        toCurrencyBox.setValue("INR");

        // Set action for the convert button
        convertButton.setOnAction(event -> convertCurrency());
    }

    private void convertCurrency() {
        try {
            String fromCurrency = fromCurrencyBox.getValue();
            String toCurrency = toCurrencyBox.getValue();
            double amount = Double.parseDouble(amountField.getText());

            // Ensure amount is valid
            if (amount <= 0) {
                errorLabel.setText("Amount must be greater than 0.");
                resultLabel.setText("");
                return;
            }

            // Perform conversion
            double convertedAmount = CurrencyConverter.convert(fromCurrency, toCurrency, amount);

            // Display result
            if (convertedAmount != -1) {
                resultLabel.setText(String.format("%.2f %s = %.2f %s", amount, fromCurrency, convertedAmount, toCurrency));
                errorLabel.setText("");
            } else {
                errorLabel.setText("Conversion failed. Check your internet connection.");
            }
        } catch (NumberFormatException e) {
            errorLabel.setText("Invalid amount. Please enter a number.");
            resultLabel.setText("");
        }
    }
}
