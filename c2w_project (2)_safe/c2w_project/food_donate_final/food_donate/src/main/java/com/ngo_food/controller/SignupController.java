package com.ngo_food.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import com.ngo_food.firebaseConfig.DataService;

public class SignupController {

    private LoginController loginController;

    public SignupController(LoginController loginController) {
        this.loginController = loginController;
    }

    public Scene createSignupScene(Stage primaryStage) {
        Label userLabel = new Label("Enter Your Name:");
        TextField userTextField = new TextField();
        Label emailLabel = new Label("Email:");
        TextField emailTextField = new TextField();
        Label phoneLabel = new Label("Phone No:");
        TextField phoneTextField = new TextField();
        Label passLabel = new Label("Password:");
        PasswordField passField = new PasswordField();
        Button signupButton = new Button("Signup as Donar");
        Button signupButton1 = new Button("Signup as NGO");

        userLabel.setFont(Font.font("", FontWeight.BOLD, 20));
        emailLabel.setFont(Font.font("", FontWeight.BOLD, 20));
        phoneLabel.setFont(Font.font("", FontWeight.BOLD, 20));
        passLabel.setFont(Font.font("", FontWeight.BOLD, 20));

        signupButton.setFont(Font.font("", FontWeight.BOLD, 15));
        signupButton1.setFont(Font.font("", FontWeight.BOLD, 15));
        signupButton.setStyle("-fx-background-color:LIGHTBLUE;");
        signupButton1.setStyle("-fx-background-color:LIGHTBLUE;");
        signupButton.setPrefWidth(250);
        signupButton1.setPrefWidth(250);

        Button backButton = new Button("Back");
        backButton.setStyle("-fx-background-color:LIGHTBLUE");
        backButton.setFont(Font.font("", FontWeight.BOLD, 15));

        VBox fieldBox1 = new VBox(10, userLabel, userTextField);
        fieldBox1.setMaxSize(300, 30);

        VBox fieldBox2 = new VBox(10, emailLabel, emailTextField);
        fieldBox2.setMaxSize(300, 30);

        VBox fieldBox3 = new VBox(10, phoneLabel, phoneTextField);
        fieldBox3.setMaxSize(300, 30);

        VBox fieldBox4 = new VBox(10, passLabel, passField);
        fieldBox4.setMaxSize(300, 30);

        HBox buttonBox = new HBox(50, signupButton, signupButton1);
        buttonBox.setMaxSize(350, 30);
        buttonBox.setAlignment(Pos.TOP_LEFT);

        backButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                loginController.showLoginScene();
            }
        });

        signupButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                handleSignup(primaryStage, userTextField.getText(), passField.getText(), emailTextField.getText());
            }
        });

        signupButton1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                handleSignup(primaryStage, userTextField.getText(), passField.getText(), emailTextField.getText());
            }
        });

        VBox vbox = new VBox(25, fieldBox1, fieldBox2, fieldBox3, fieldBox4, buttonBox,backButton);
        vbox.setAlignment(Pos.CENTER);

        StackPane root = new StackPane();
        ImageView background = createBackgroundImageView("D:\\JavaFXProject\\c2w_project (2)_safe\\c2w_project\\food_donate_final\\food_donate\\src\\main\\java\\com\\Assets\\signup.jpg");
        background.setOpacity(0.4); // Set opacity for the background image
        background.fitWidthProperty().bind(primaryStage.widthProperty());
        background.fitHeightProperty().bind(primaryStage.heightProperty());

        root.getChildren().addAll(background, vbox);

        return new Scene(root, 1800, 1000);
    }

    private void handleSignup(Stage primaryStage, String username, String password, String email) {
        DataService dataService; // Local instance of DataService
        try {
            dataService = new DataService(); // Initialize DataService instance
            // Create a map to hold user data
            Map<String, Object> data = new HashMap<>();
            data.put("password", password);
            data.put("username", username);
            data.put("email", email);
            // Add user data to Firestore
            dataService.addData("users", username, data);
            System.out.println("User registered successfully");

            // Navigate back to the login scene
            loginController.showLoginScene();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try {
            dataService = new DataService(); // Initialize DataService instance
            // Create a map to hold user data
            Map<String, Object> data = new HashMap<>();
            data.put("password", password);
            data.put("username", username);
            // Add user data to Firestore
            dataService.addData("ngo", username, data);
            System.out.println("NGO registered successfully");

            // Navigate back to the login scene
            loginController.showLoginScene();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
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
}
