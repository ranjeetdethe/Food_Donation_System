package com.ngo_food.dashboard;

import com.ngo_food.controller.LoginController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class AboutUs  {

    private LoginController loginController;

    public AboutUs(LoginController loginController) {
        this.loginController = loginController;
    }

   // @Override
    public Scene aboutUsScene(Stage primaryStage) {
        primaryStage.setTitle("About Us");

        // Original about us content
        String aboutUsText = "A teacher is not only a source of knowledge, but a teacher\n" +
                "who inspires, motivates and nurtures the potential in every student.\n" +"Good teachers know how to bring out the best in students and Motivate and \n"+"Encourage the students for Better Future. We all are lucky to have a teacher like Shashi sir...\n" +
                "Thanks Core2Web Family..!!";

        // Team members' names
        String[] teamMembers = {"Devika Thosar","Ranjeet Dethe"};
    

        // Create the label for About Us content
        Label aboutUsLabel = new Label(aboutUsText);
        aboutUsLabel.setFont(Font.font("ARIAL", FontWeight.BOLD, 22));

        // Create the label for team members
        StringBuilder teamMembersText = new StringBuilder("Team Members:\n");
        for (String member : teamMembers) {
            teamMembersText.append(member).append("\n");
        }
        Label teamMembersLabel = new Label(teamMembersText.toString());
        teamMembersLabel.setFont(Font.font("ARIAL", FontWeight.BOLD, 20));

        // Load the logo image and set it to a circular shape
        ImageView logoImageView = createImageView("D:\\JavaFXProject\\c2w_project (2)_safe\\c2w_project\\food_donate_final\\food_donate\\src\\main\\java\\com\\Assets\\Shasi SIr.jpg");
        double radius = 200; // Radius for the circular logo
        Circle clip = new Circle(radius, radius, radius);
        logoImageView.setClip(clip);
        logoImageView.setFitWidth(radius * 2);
        logoImageView.setFitHeight(radius * 2);

        // Create the back button
        Button backButton = new Button("Back");
        backButton.setStyle("-fx-background-color: LIGHTBLUE;");
        backButton.setFont(Font.font("", FontWeight.BOLD, 20));
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                // Implement the logic to go back to the login scene
            }
        });

        // Create a VBox to hold logo, message, team members, and button
        VBox vb = new VBox(20, logoImageView, aboutUsLabel, teamMembersLabel, backButton);
        vb.setPadding(new Insets(20));
        vb.setAlignment(Pos.CENTER);

        // Create a StackPane to hold the VBox and set background color
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(vb);
        stackPane.setStyle("-fx-background-color: #AFCBD5");

        Scene scene = new Scene(stackPane, 1800, 1000);
        primaryStage.setScene(scene);
        primaryStage.show();
        return scene  ;
    }

    private ImageView createImageView(String imagePath) {
        Image image = null;
        try {
            image = new Image(new FileInputStream(imagePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        return imageView;
    }

}
