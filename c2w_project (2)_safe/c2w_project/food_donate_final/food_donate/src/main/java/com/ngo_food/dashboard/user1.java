package com.ngo_food.dashboard;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class user1 extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("PodAI Clone");

        showLoginPage();
    }

    private void showLoginPage() {
        VBox loginLayout = new VBox(10);
        loginLayout.setAlignment(Pos.CENTER);
        loginLayout.setPadding(new Insets(20));
        loginLayout.setStyle("-fx-background-color: rgba(255, 255, 255, 0.6); -fx-background-radius: 10;");

        Label usernameLabel = new Label("Username:");
        usernameLabel.setStyle("-fx-font-size: 12pt;");
        TextField usernameField = new TextField();
        usernameField.setMaxWidth(200);

        Label passwordLabel = new Label("Password:");
        passwordLabel.setStyle("-fx-font-size: 12pt;");
        PasswordField passwordField = new PasswordField();
        passwordField.setMaxWidth(200);

        Button loginButton = new Button("Login");
        loginButton.setStyle("-fx-font-size: 12pt; -fx-background-color: #4CAF50; -fx-text-fill: white;");
        loginButton.setPrefWidth(100);
       

        Button signupButton = new Button("Sign Up");
        signupButton.setStyle("-fx-font-size: 12pt; -fx-background-color: #2196F3; -fx-text-fill: white;");
        signupButton.setPrefWidth(100);
        signupButton.setOnAction(e -> showSignupPage());

        loginLayout.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField, loginButton, signupButton);

        StackPane root = new StackPane();
        root.setAlignment(Pos.CENTER);
        ImageView background = createBackgroundImageView("D:\\JavaFXProject\\c2w_project (2)_safe\\c2w_project\\food_donate_final\\food_donate\\src\\main\\java\\com\\Assets\\donate.jpg");
        background.fitWidthProperty().bind(primaryStage.widthProperty());
        background.fitHeightProperty().bind(primaryStage.heightProperty());
        root.getChildren().addAll(background, loginLayout);

        Scene loginScene = new Scene(root, 600, 400);
        primaryStage.setScene(loginScene);
        primaryStage.show();
    }

    private void showSignupPage() {
        VBox signupLayout = new VBox(10);
        signupLayout.setAlignment(Pos.CENTER);
        signupLayout.setPadding(new Insets(20));
        signupLayout.setStyle("-fx-background-color: rgba(255, 255, 255, 0.6); -fx-background-radius: 10;");

        Label fullNameLabel = new Label("Full Name:");
        fullNameLabel.setStyle("-fx-font-size: 12pt;");
        TextField fullNameField = new TextField();
        fullNameField.setMaxWidth(200);

        Label contactLabel = new Label("Contact Number:");
        contactLabel.setStyle("-fx-font-size: 12pt;");
        TextField contactField = new TextField();
        contactField.setMaxWidth(200);

        Label addressLabel = new Label("Address:");
        addressLabel.setStyle("-fx-font-size: 12pt;");
        TextField addressField = new TextField();
        addressField.setMaxWidth(200);

        Label genderLabel = new Label("Gender:");
        genderLabel.setStyle("-fx-font-size: 12pt;");
        ComboBox<String> genderComboBox = new ComboBox<>();
        genderComboBox.getItems().addAll("Male", "Female", "Other");
        genderComboBox.setMaxWidth(200);

        Label emailLabel = new Label("Email:");
        emailLabel.setStyle("-fx-font-size: 12pt;");
        TextField emailField = new TextField();
        emailField.setMaxWidth(200);

        Label dobLabel = new Label("Date of Birth:");
        dobLabel.setStyle("-fx-font-size: 12pt;");
        TextField dobField = new TextField();
        dobField.setMaxWidth(200);

        Label collegeNameLabel = new Label("College Name:");
        collegeNameLabel.setStyle("-fx-font-size: 12pt;");
        TextField collegeNameField = new TextField();
        collegeNameField.setMaxWidth(200);

        Label academicYearLabel = new Label("Academic Year:");
        academicYearLabel.setStyle("-fx-font-size: 12pt;");
        TextField academicYearField = new TextField();
        academicYearField.setMaxWidth(200);

        Label passoutYearLabel = new Label("Passout Year:");
        passoutYearLabel.setStyle("-fx-font-size: 12pt;");
        TextField passoutYearField = new TextField();
        passoutYearField.setMaxWidth(200);

        Label qualificationLabel = new Label("Current Qualification:");
        qualificationLabel.setStyle("-fx-font-size: 12pt;");
        TextField qualificationField = new TextField();
        qualificationField.setMaxWidth(200);

        Label cgpaLabel = new Label("CGPA:");
        cgpaLabel.setStyle("-fx-font-size: 12pt;");
        TextField cgpaField = new TextField();
        cgpaField.setMaxWidth(200);

        Button signupButton = new Button("Submit");
        signupButton.setStyle("-fx-font-size: 12pt; -fx-background-color: #4CAF50; -fx-text-fill: white;");
        signupButton.setMaxWidth(200);


        Button backButton = new Button("Back");
        backButton.setStyle("-fx-font-size: 12pt; -fx-background-color: #F44336; -fx-text-fill: white;");
        backButton.setMaxWidth(200);
        backButton.setOnAction(e -> showLoginPage());

        signupLayout.getChildren().addAll(fullNameLabel, fullNameField, contactLabel, contactField, addressLabel, addressField, genderLabel, genderComboBox, emailLabel, emailField, dobLabel, dobField, collegeNameLabel, collegeNameField, academicYearLabel, academicYearField, passoutYearLabel, passoutYearField, qualificationLabel, qualificationField, cgpaLabel, cgpaField, signupButton, backButton);

        StackPane root = new StackPane();
        root.setAlignment(Pos.CENTER);
        ImageView background = createBackgroundImageView("demo/src/main/resources/img/image.jpg");
        background.fitWidthProperty().bind(primaryStage.widthProperty());
        background.fitHeightProperty().bind(primaryStage.heightProperty());
        root.getChildren().addAll(background, signupLayout);

        Scene signupScene = new Scene(root, 600, 400);
        primaryStage.setScene(signupScene);
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

    public static void main(String[] args) {
        launch(args);
    }
}