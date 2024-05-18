import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create root pane
        BorderPane root = new BorderPane();
        root.setMinSize(400, 400);

        // Set background image
        root.setBackground(new Background(new BackgroundImage(
                new Image("file:Background.png", 400, 400, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));

        // Create title label
        Label titleLabel = new Label("EXPLORE");
        titleLabel.getStyleClass().add("title");

        // Create input fields
        TextField usernameInput = new TextField();
        usernameInput.setPromptText("Username");
        usernameInput.getStyleClass().add("input");

        TextField passwordInput = new TextField();
        passwordInput.setPromptText("Password");
        passwordInput.getStyleClass().add("input");

        // Create buttons
        Button signUpButton = new Button("Sign up");
        signUpButton.getStyleClass().add("login-btn");

        Button signInButton = new Button("Sign in");
        signInButton.getStyleClass().add("login-btn");
        signInButton.setOnAction(event -> signIn());

        // Create forgot password label
        Label forgotPasswordLabel = new Label("Forgot Password?");
        forgotPasswordLabel.getStyleClass().add("forgot");

        // Create social media buttons
        Button googleButton = new Button("", new javafx.scene.image.ImageView(new Image("google-icon.png")));
        googleButton.getStyleClass().add("social-media-btn");

        Button facebookButton = new Button("", new javafx.scene.image.ImageView(new Image("facebook-icon.png")));
        facebookButton.getStyleClass().add("social-media-btn");

        Button appleButton = new Button("", new javafx.scene.image.ImageView(new Image("apple-icon.png")));
        appleButton.getStyleClass().add("social-media-btn");

        // Add components to the root pane
        root.setTop(titleLabel);
        root.setCenter(createCenterPane(usernameInput, passwordInput, signUpButton, signInButton, forgotPasswordLabel));
        root.setBottom(createBottomPane(googleButton, facebookButton, appleButton));

        // Create scene and set style
        Scene scene = new Scene(root);
        scene.getStylesheets().add("application.css");

        // Set stage properties
        primaryStage.setTitle("Login Page");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void signIn() {
        // Add your sign-in logic here
    }

    private VBox createCenterPane(TextField usernameInput, TextField passwordInput, Button signUpButton, Button signInButton, Label forgotPasswordLabel) {
        VBox centerPane = new VBox(10);
        centerPane.getStyleClass().add("card");
        centerPane.getChildren().addAll(
                createInputContainer(usernameInput, "fas-user"),
                createInputContainer(passwordInput, "fas-unlock-alt"),
                signUpButton,
                signInButton,
                forgotPasswordLabel
        );
        return centerPane;
    }

    private HBox createInputContainer(TextField inputField, String iconClass) {
        HBox inputContainer = new HBox();
        inputContainer.getStyleClass().add("input-container");
        inputContainer.getChildren().addAll(
                inputField,
                new javafx.scene.image.ImageView(new Image("file:" + iconClass + ".png"))
        );
        return inputContainer;
    }

    private HBox createBottomPane(Button googleButton, Button facebookButton, Button appleButton) {
        HBox bottomPane = new HBox(10);
        bottomPane.getStyleClass().add("social-media-pane");
        bottomPane.getChildren().addAll(
                new Label("or"),
                createSocialMediaLabel(),
                googleButton,
                facebookButton,
                appleButton
        );
        return bottomPane;
    }

    private Label createSocialMediaLabel() {
        Label socialMediaLabel = new Label("Sign in with your social media account");
        socialMediaLabel.getStyleClass().add("social-media");
        return socialMediaLabel;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
