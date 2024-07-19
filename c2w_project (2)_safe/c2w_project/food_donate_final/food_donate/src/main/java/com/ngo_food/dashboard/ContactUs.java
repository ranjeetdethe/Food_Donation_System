package com.ngo_food.dashboard;

import com.ngo_food.controller.LoginController;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ContactUs {

    private LoginController loginController;

    public ContactUs(LoginController loginController) {
        this.loginController = loginController;
    }

    public Scene contactUsScene(Stage primaryStage) {
        Label nameLabel = new Label("Name:");
        nameLabel.setFont(Font.font("", FontWeight.BOLD, 20));
        TextField nameTextField = new TextField();
        nameTextField.setMaxWidth(450);

        Label emailLabel = new Label("Email:");
        emailLabel.setFont(Font.font("", FontWeight.BOLD, 20));
        TextField emailTextField = new TextField();
        emailTextField.setMaxWidth(450);

        Label subjectLabel = new Label("Subject:");
        subjectLabel.setFont(Font.font("", FontWeight.BOLD, 20));
        TextField subjectTextField = new TextField();
        subjectTextField.setMaxWidth(450);

        Label messageLabel = new Label("Message:");
        messageLabel.setFont(Font.font("", FontWeight.BOLD, 20));
        TextArea messageTextArea = new TextArea();
        messageTextArea.setMaxWidth(450);
        messageTextArea.setPrefRowCount(5);

        Button sendButton = new Button("Send");
        sendButton.setStyle("-fx-background-color: LIGHTBLUE;");
        sendButton.setFont(Font.font("", FontWeight.BOLD, 20));
        sendButton.setOnAction((ActionEvent event) -> {
            handleSendButton(nameTextField.getText(), emailTextField.getText(), subjectTextField.getText(), messageTextArea.getText());
        });

        Button backButton = new Button("Back");
        backButton.setStyle("-fx-background-color: LIGHTBLUE;");
        backButton.setFont(Font.font("", FontWeight.BOLD, 20));
        backButton.setOnAction((ActionEvent event) -> {
            loginController.showLoginScene();
        });

        ImageView logo = createLogoImageView("c2w_project\\food_donate_final\\food_donate\\src\\main\\java\\com\\Assets\\logo_contact.png");

        VBox vbox = new VBox(10, logo, nameLabel, nameTextField, emailLabel, emailTextField, subjectLabel, subjectTextField, messageLabel, messageTextArea, sendButton, backButton);
        vbox.setPadding(new Insets(20));
        vbox.setStyle("-fx-background-color: #D9EDF8; -fx-background-image: url('D:\\food_donate_final\\food_donate\\src\\main\\resources\\Image1.jpg'); -fx-background-size: cover;");
        vbox.setAlignment(Pos.CENTER);

        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(vbox);

        return new Scene(stackPane, 1800, 1000);
    }

    private void handleSendButton(String name, String email, String subject, String message) {
        // Handle sending the contact information (e.g., send an email, save to database, etc.)
        // For this example, we'll just show a confirmation alert
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Contact Us");
        alert.setHeaderText(null);
        alert.setContentText("Thank you for contacting us, " + name + "!");
        alert.showAndWait();
    }

    private ImageView createLogoImageView(String imagePath) {
        Image logoImage = new Image("file:" + imagePath);
        ImageView logoImageView = new ImageView(logoImage);
        logoImageView.setFitWidth(200);  // Adjust the size as needed
        logoImageView.setFitHeight(200); // Adjust the size as needed
        logoImageView.setPreserveRatio(true);
        return logoImageView;
    }
}
