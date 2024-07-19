package com.ngo_food.controller;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HomePage extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Home Page with Dashboard");

        // Header
        VBox header = createHeader();

        // Navigation buttons
        HBox navigationButtons = createNavigationButtons();

        // Dashboard section
        VBox dashboard = createDashboard();

        // Create a border pane layout
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(header); // Header at the top
        borderPane.setLeft(navigationButtons); // Navigation buttons on the left
        borderPane.setCenter(dashboard); // Dashboard in the center

        Scene scene = new Scene(borderPane, 800, 600); // Set the size of the scene
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private VBox createHeader() {
        VBox header = new VBox();
        header.setPadding(new Insets(20, 10, 20, 10)); // Padding around the header
        header.setStyle("-fx-background-color: #336699;"); // Set background color

        Text title = new Text("Welcome to My App");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        title.setStyle("-fx-fill: white;"); // Text color

        header.getChildren().add(title);

        return header;
    }

    private HBox createNavigationButtons() {
        Button button1 = new Button("Button 1");
        Button button2 = new Button("Button 2");
        Button button3 = new Button("Button 3");

        // Set actions for the buttons (not implemented in this example)
        button1.setOnAction(e -> {
            // Define actions for button 1
        });
        button2.setOnAction(e -> {
            // Define actions for button 2
        });
        button3.setOnAction(e -> {
            // Define actions for button 3
        });

        HBox buttonBox = new HBox(10); // spacing between buttons
        buttonBox.getChildren().addAll(button1, button2, button3);
        buttonBox.setPadding(new Insets(20, 10, 20, 10)); // Padding around the buttons
        buttonBox.setStyle("-fx-background-color: #f0f0f0;"); // Set background color

        return buttonBox;
    }

    private VBox createDashboard() {
        VBox dashboard = new VBox();
        dashboard.setPadding(new Insets(20));
        dashboard.setStyle("-fx-background-color: #e0e0e0;"); // Set background color

        Text dashboardTitle = new Text("Dashboard");
        dashboardTitle.setFont(Font.font("Arial", FontWeight.BOLD, 18));

        // Add charts, statistics, or other dashboard components here
        Text placeholderText = new Text("Placeholder for Dashboard Content");
        placeholderText.setFont(Font.font("Arial", 14));

        dashboard.getChildren().addAll(dashboardTitle, placeholderText);

        return dashboard;
    }

    public static void main(String[] args) {
        launch(args);
    }
}