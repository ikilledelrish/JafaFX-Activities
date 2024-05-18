package application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Second extends GridPane {

    public Second(Stage primaryStage, Scene loginScene) {
        this.setAlignment(javafx.geometry.Pos.CENTER);
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(25, 25, 25, 25));

        Label welcomeLabel = new Label("WELCOME AMIGO!");
        welcomeLabel.setTextFill(Color.WHITE);
        welcomeLabel.setFont(Font.font("Lithos Black", FontWeight.BOLD, 80));
        this.add(welcomeLabel, 0, 0);
        
        Button backButton = new Button("Back");
        backButton.setTextFill(Color.WHITE); // Set the text color to white
        backButton.setStyle("-fx-background-color: transparent;"); // Set the background color to transparent
        this.add(backButton, 0, 1);

        // Adjusting the position of the back button using pixel values
        backButton.setTranslateX(-240); // Adjust X-axis position
        backButton.setTranslateY(-365); // Adjust Y-axis position

        backButton.setOnAction(e -> primaryStage.setScene(loginScene));

        this.setStyle("-fx-background-image: url('application/Background.png'); " +
                      "-fx-background-size: cover;");

        loginScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    }
}
