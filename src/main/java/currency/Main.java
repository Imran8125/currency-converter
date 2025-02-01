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
            // Debug: Print the resource path
            System.out.println("Attempting to load icon from: " + getClass().getResource("/currency/images/logo.png"));
            
            // Try alternative resource loading
            var iconStream = Main.class.getResourceAsStream("/currency/images/logo.png");
            if (iconStream != null) {
                Image icon = new Image(iconStream);
                primaryStage.getIcons().add(icon);
            } else {
                System.err.println("Could not load icon - resource not found");
            }
            
            // Load the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/currency/UI.fxml"));
            Parent root = loader.load();

            // Set the stage
            primaryStage.setTitle("Currency Converter");
            primaryStage.setScene(new Scene(root));
            primaryStage.setResizable(false);  // Optional: prevent window resizing
            primaryStage.show();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
