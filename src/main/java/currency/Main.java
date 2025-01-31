package currency;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Load the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/currency/UI.fxml"));
            Parent root = loader.load();

            // Set the stage
            primaryStage.setTitle("Currency Converter");
            primaryStage.setScene(new Scene(root, 400, 300));
            primaryStage.show();

            // Set the icon
            Image icon = new Image(getClass().getResourceAsStream("/currency/images/logo.png"));
            primaryStage.getIcons().add(icon);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args); // Launch the JavaFX application
    }
}
