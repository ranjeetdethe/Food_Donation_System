package com.ngo_food.controller;

import com.ngo_food.firebaseConfig.DataService;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ForgotPasswordApp {
    private LoginController loginController;

    public ForgotPasswordApp(LoginController loginController) {
        this.loginController = loginController;
    }

    public Scene forgotpass(Stage primaryStage) {
        primaryStage.setTitle("Forgot Password");

        Label emailLabel = new Label("Enter your email:");
        TextField emailField = new TextField();
        emailField.setPrefWidth(10);
        emailField.setMaxWidth(350);
        Button sendButton = new Button("Send Reset Link");

        emailLabel.setFont(Font.font("", FontWeight.BOLD, 20));
        sendButton.setStyle("-fx-background-color:LIGHTBLUE");
        sendButton.setFont(Font.font("", FontWeight.BOLD, 20));

        Button backButton = new Button("Back");
        backButton.setStyle("-fx-background-color:LIGHTBLUE");
        backButton.setFont(Font.font("", FontWeight.BOLD, 20));

        sendButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String email = emailField.getText();
                sendResetLink(email);

                // Create and show the alert box
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Reset Link Sent");
                alert.setHeaderText(null);
                alert.setContentText("A reset link has been sent to " + email);
                alert.showAndWait();
            }
        });

        backButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                loginController.showLoginScene();
            }
        });

        VBox layout = new VBox(10, emailLabel, emailField, backButton, sendButton);
        layout.setAlignment(Pos.CENTER);

        StackPane root = new StackPane();
        root.setAlignment(Pos.CENTER);

        ImageView background = createBackgroundImageView("D:\\JavaFXProject\\c2w_project (2)_safe\\c2w_project\\food_donate_final\\food_donate\\src\\main\\java\\com\\Assets\\forgot.jpg");
        background.fitWidthProperty().bind(primaryStage.widthProperty());
        background.fitHeightProperty().bind(primaryStage.heightProperty());

        root.getChildren().addAll(background, layout);

        return new Scene(root, 1800, 1000);
    }

    private ImageView createBackgroundImageView(String imagePath) {
        Image backgroundImage = null;
        try {
            backgroundImage = new Image(new FileInputStream(imagePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.setPreserveRatio(false);
        return backgroundImageView;
    }

    private void sendResetLink(String email) {
        DataService dataService;
        System.out.println("Reset link sent to: " + email);
        loginController.showLoginScene();
    }
}
