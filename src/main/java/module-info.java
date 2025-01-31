module currency {
    requires javafx.controls; // Required for JavaFX controls like buttons, labels, etc.
    requires javafx.fxml;     // Required for FXML-based UI
    requires java.net.http;  // Required for making HTTP requests (using HttpClient)
    requires org.json;  // Add this line
    requires transitive javafx.graphics;  // Change to transitive
    
    opens currency to javafx.fxml, javafx.graphics;  // Add javafx.graphics here
    exports currency;  // This is sufficient since Main is in the currency package
}
