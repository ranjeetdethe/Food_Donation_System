package com.ngo_food.controller;
import com.ngo_food.controller.LoginController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.ExecutionException;

import com.ngo_food.dashboard.UserPage;
import com.ngo_food.dashboard.AboutUs;
import com.ngo_food.dashboard.ContactUs;
import com.ngo_food.dashboard.DonationForm;
import com.ngo_food.dashboard.NGOPage;
import com.ngo_food.firebaseConfig.DataService;

public class LoginController {

    private Stage primaryStage;
    private Scene loginScene;
    private Scene userScene;
    private DataService dataService;
    private ForgotPasswordApp ForgotPasswordApp;
    private DonationForm donationForm;
    private NGOPage ngoPage;
    public static String key;

    public LoginController(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.dataService = new DataService();
        this.ForgotPasswordApp = new ForgotPasswordApp(null);
        //this.donationForm= donationForm;

        initScenes();
    }

    private void initScenes() {
        initLoginScene();
    }

    private void initLoginScene() {
        double textFieldWidth = 350;

        Label userLabel = new Label("Username");
        userLabel.setFont(Font.font("", FontWeight.BOLD, 20));

        TextField userTextField = new TextField();
        userTextField.setMaxWidth(textFieldWidth);

        Label passLabel = new Label("Password");
        passLabel.setFont(Font.font("", FontWeight.BOLD, 20));

        PasswordField passField = new PasswordField();
        passField.setMaxWidth(textFieldWidth);

        Button loginButton = new Button("Donor Login");
        loginButton.setStyle("-fx-background-color: LIGHTBLUE;");

        Button ngoButton = new Button("NGO Login");
        ngoButton.setStyle("-fx-background-color: LIGHTBLUE;");

        Button signupButton = new Button("Signup");
        signupButton.setStyle("-fx-background-color: LIGHTBLUE;");

        Button forgotButton = new Button("Forgot Password?");
        forgotButton.setStyle("-fx-background-color: LIGHTBLUE;");

        Button aboutUsButton = new Button("About Us");
        Button contactButton = new Button("Contact Us");

       // userTextField.setMaxHeight(textFieldWidth);

        signupButton.setFont(Font.font("", FontWeight.BOLD, 18));
        loginButton.setFont(Font.font("", FontWeight.BOLD, 18));
        forgotButton.setFont(Font.font("", FontWeight.BOLD, 18));
        ngoButton.setFont(Font.font("", FontWeight.BOLD, 18));
        aboutUsButton.setFont(Font.font("", FontWeight.BOLD, 18));
        aboutUsButton.setStyle("-fx-background-color: LIGHTBLUE;");
        contactButton.setFont(Font.font("", FontWeight.BOLD, 20));
        contactButton.setStyle("-fx-background-color: LIGHTBLUE;");

        userLabel.setPrefWidth(textFieldWidth);
        passLabel.setPrefWidth(textFieldWidth);

        ImageView background = createBackgroundImageView("D:\\JavaFXProject\\c2w_project (2)_safe\\c2w_project\\food_donate_final\\food_donate\\src\\main\\java\\com\\Assets\\main.png");
        background.fitWidthProperty().bind(primaryStage.widthProperty());
        background.fitHeightProperty().bind(primaryStage.heightProperty());

        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                handleLogin(userTextField.getText(), passField.getText());
                showDonationScene();
                userTextField.clear();
                passField.clear();
            }
        });

        ngoButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                handleLogin(userTextField.getText(), passField.getText());
                showNGOScene();
                
            }
        });

        aboutUsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showAboutUsScene();
            }
        });
        contactButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event){
                showContactUsScene();
            }
        });

        signupButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showSignupScene();
                userTextField.clear();
                passField.clear();
            }
        });

        forgotButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showForgotPassword();
            }
        });

        userLabel.setStyle("-fx-text-fill: black;");
        passLabel.setStyle("-fx-text-fill: black;");

        VBox fieldBox1 = new VBox(15, userLabel, userTextField);
        fieldBox1.setMaxSize(300, 30);
        fieldBox1.setStyle("-fx-padding: 10;");
        VBox fieldBox2 = new VBox(15, passLabel, passField);
        fieldBox2.setMaxSize(300, 30);
        HBox buttonBox = new HBox(40, loginButton, ngoButton);
        buttonBox.setMaxSize(350, 30);
        buttonBox.setAlignment(Pos.CENTER);
        HBox buttonBox1 = new HBox(20, signupButton, forgotButton);
        buttonBox1.setMaxSize(400, 30);
        buttonBox1.setAlignment(Pos.CENTER);

        VBox vbox = new VBox(25, fieldBox1, fieldBox2, buttonBox, buttonBox1,contactButton);
        vbox.setPadding(new Insets(200, 0, 600, 1200));

        HBox vb = new HBox(20,contactButton,aboutUsButton);
        vb.setAlignment(Pos.TOP_RIGHT);
        vb.setPadding(new Insets(20));
        
        // Adding label at bottom center
        Label footerLabel = new Label("Share a Meal, Share a Smile");
        footerLabel.setFont(Font.font("", FontWeight.BOLD, 40));
        footerLabel.setTextFill(Color.BLACK);

        StackPane footerPane = new StackPane(footerLabel);
        footerPane.setAlignment(Pos.BOTTOM_CENTER);
        footerPane.setPadding(new Insets(10, 0, 20, 0));

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(background, vb, vbox, footerPane);

        loginScene = new Scene(stackPane, 1800, 1000);
    }

    private void initUserScene() {
        UserPage userPage = new UserPage(dataService, donationForm);
        userScene = new Scene(userPage.createUserScene(this::handleLogout, donationForm));
    }

    public Scene getLoginScene() {
        return loginScene;
    }

    public void showLoginScene() {
        primaryStage.setScene(loginScene);
        primaryStage.setTitle("Login");
        primaryStage.show();
    }

    private void handleLogin(String username, String password) {
        try {
            if (dataService.authenticateUser(username, password)) {
                key = username;
                initUserScene();
                primaryStage.setScene(userScene);
                primaryStage.setTitle("User Dashboard");
            } else {
                key = null;
                System.out.println("Invalid credentials");
            }
        } catch (ExecutionException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    private void showSignupScene() {
        SignupController signupController = new SignupController(this);
        Scene signupScene = signupController.createSignupScene(primaryStage);
        primaryStage.setScene(signupScene);
        primaryStage.setTitle("Signup");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private void showAboutUsScene(){
        AboutUs aboutUs = new AboutUs(this);
        Scene aboutUsScene = aboutUs.aboutUsScene(primaryStage);
        primaryStage.setScene(aboutUsScene);
        primaryStage.setTitle("About Us");
        primaryStage.show();
    }
    
    private void showContactUsScene(){
        ContactUs contactUs = new ContactUs(this);
        Scene contactUsScene= contactUs.contactUsScene(primaryStage);
        primaryStage.setScene(contactUsScene);
        primaryStage.setTitle("Contact Us");
        primaryStage.show();
    }

    private void showForgotPassword() {
        ForgotPasswordApp forgotPasswordApp = new ForgotPasswordApp(this);
        Scene forgotpassScene = forgotPasswordApp.forgotpass(primaryStage);
        primaryStage.setScene(forgotpassScene);
        primaryStage.setTitle("Forgot Password");
        primaryStage.show();
    }

    private void showDonationScene() {
        DonationForm donationForm = new DonationForm(this);
        Scene donationFormScene = donationForm.donationformScene(primaryStage);
        primaryStage.setScene(donationFormScene);
        primaryStage.setTitle("Donation Form");
        primaryStage.show();
    }

    private void handleLogout() {
        primaryStage.setScene(loginScene);
        primaryStage.setTitle("Login");
        primaryStage.setResizable(false);
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

    private void showNGOScene() {
        VBox vBox = NGOPage.loadProjectDetails();
        Scene ngoScene = new Scene(vBox, 1800, 1000);
        primaryStage.setScene(ngoScene);
        primaryStage.setTitle("NGO Scene");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    
}
