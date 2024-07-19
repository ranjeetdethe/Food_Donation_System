// package com.ngo_food.dashboard;

// import java.io.FileInputStream;
// import java.io.FileNotFoundException;
// import java.time.LocalDate;
// import java.util.HashMap;
// import java.util.Map;

// import com.ngo_food.controller.LoginController;
// import com.ngo_food.firebaseConfig.DataService;

// import javafx.application.Application;
// import javafx.event.ActionEvent;
// import javafx.event.EventHandler;
// import javafx.geometry.Insets;
// import javafx.geometry.Pos;
// import javafx.scene.Scene;
// import javafx.scene.control.Button;
// import javafx.scene.control.Label;
// import javafx.scene.control.TextField;
// import javafx.scene.image.Image;
// import javafx.scene.image.ImageView;
// import javafx.scene.layout.StackPane;
// import javafx.scene.layout.VBox;
// import javafx.scene.paint.Color;
// import javafx.scene.text.Font;
// import javafx.scene.text.FontWeight;
// import javafx.stage.Stage;

// public class DonationForm {

//     private LoginController loginController;

//     public DonationForm(LoginController loginController) {
//         this.loginController = loginController;
//     }

//     public Scene donationformScene(Stage primaryStage) {
//         Label foodtypeLabel = new Label("Enter Your Food Type:");
//         TextField foodtypeTextField = new TextField();
//         Label cookdateLabel = new Label("Cooking Date");
//         TextField cookingdateTextField = new TextField();
//         TextField availableTextField = new TextField();
//         Label availableLabel = new Label("Availability");
//         TextField QuantityTextField = new TextField();
//         Label QuantityLabel = new Label("Quantity");
//         TextField locationTextField = new TextField();
//         Label locationLabel = new Label("Location");

//         foodtypeLabel.setFont(Font.font("", FontWeight.BOLD, 15));
//         cookdateLabel.setFont(Font.font("", FontWeight.BOLD, 15));
//         availableLabel.setFont(Font.font("", FontWeight.BOLD, 15));
//         locationLabel.setFont(Font.font("", FontWeight.BOLD, 15));
//         QuantityLabel.setFont(Font.font("", FontWeight.BOLD, 15));

//         foodtypeTextField.setMaxWidth(350);
//         cookingdateTextField.setMaxWidth(350);
//         availableTextField.setMaxWidth(350);
//         locationTextField.setMaxWidth(350);
//         QuantityTextField.setMaxWidth(350);

//         VBox fieldBox1 = new VBox(10, foodtypeLabel, foodtypeTextField);
//         fieldBox1.setMaxSize(300, 30);

//         VBox fieldBox2 = new VBox(10, cookdateLabel, cookingdateTextField);
//         fieldBox2.setMaxSize(300, 30);

//         VBox fieldBox3 = new VBox(10, availableLabel, availableTextField);
//         fieldBox3.setMaxSize(300, 30);

//         VBox fieldBox4 = new VBox(10, QuantityLabel, QuantityTextField);
//         fieldBox4.setMaxSize(300, 30);

//         VBox fieldBox5 = new VBox(10, locationLabel, locationTextField);
//         fieldBox5.setMaxSize(300, 30);

//         Button addButton = new Button("Donate");
//         addButton.setAlignment(Pos.CENTER);
//         addButton.setStyle("-fx-background-color:LIGHTBLUE;");

//         addButton.setOnAction(new EventHandler<ActionEvent>() {
//             @Override
//             public void handle(ActionEvent event) {
//                 handleAddButton(primaryStage, foodtypeTextField.getText(), cookingdateTextField.getText(), availableTextField.getText(), QuantityTextField.getText(), locationTextField.getText());
//             }
//         });

//         VBox vbox = new VBox(25, fieldBox1, fieldBox2, fieldBox3, fieldBox4, fieldBox5, addButton);
//         //vbox.setPadding(new Insets(50));
//         vbox.setAlignment(Pos.CENTER);

//         // Add the sticker image
//         ImageView stickerImageView = createStickerImageView("c2w_project\\food_donate_final\\food_donate\\src\\main\\java\\com\\Assets\\sticker.jpg");
//         stickerImageView.setFitWidth(100);
//         stickerImageView.setFitHeight(100);

//         StackPane stackPane = new StackPane();
//         stackPane.getChildren().addAll(vbox, stickerImageView);
//         StackPane.setAlignment(stickerImageView, Pos.TOP_RIGHT);
//        // StackPane.setMargin(stickerImageView, new Insets(100,100,100,100));
//         stackPane.setAlignment(Pos.TOP_CENTER);
//         return new Scene(stackPane, 800, 800);
//     }

//     private void handleAddButton(Stage primaryStage, String foodtype, String cookingDate, String availability, String quantity, String location) {
//         DataService dataService;
//         try {
//             dataService = new DataService();
//             Map<String, Object> data = new HashMap<>();
//             data.put("foodtype", foodtype);
//             data.put("cookingDate", cookingDate);
//             data.put("availability", availability);
//             data.put("quantity", quantity);
//             data.put("location", location);
//             data.put("timestamp", LocalDate.now().toString());
//             // Add user data to Firestore
//             dataService.addData("Food Information", foodtype, data);

//             System.out.println("Donated successfully");

//             loginController.showLoginScene();

//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }

//     private ImageView createStickerImageView(String imagePath) {
//         Image stickerImage = null;
//         try {
//             stickerImage = new Image(new FileInputStream(imagePath));
//         } catch (FileNotFoundException e) {
//             e.printStackTrace();
//         }
//         ImageView stickerImageView = new ImageView(stickerImage);
//         stickerImageView.setPreserveRatio(true);
//         return stickerImageView;
//     }
// }
package com.ngo_food.dashboard;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.ngo_food.controller.LoginController;
import com.ngo_food.firebaseConfig.DataService;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class DonationForm {
    private GridPane view;

    private LoginController loginController;

    public DonationForm(LoginController loginController) {
        this.loginController = loginController;
    }

    public Scene donationformScene(Stage primaryStage) {
        view = new GridPane();
        Label foodtypeLabel = new Label("Enter Your Food Type:");
        TextField foodtypeTextField = new TextField();
        foodtypeLabel.setFont(Font.font("", FontWeight.BOLD, 20));

        Label cookdateLabel = new Label("Cooking Date:");
        DatePicker cookingDatePicker = new DatePicker();
        cookingDatePicker.setMaxWidth(350);
        cookdateLabel.setFont(Font.font("", FontWeight.BOLD, 20));

        Label quantityLabel = new Label("Quantity:");
        TextField quantityTextField = new TextField();
        quantityTextField.setMaxWidth(350);
        quantityLabel.setFont(Font.font("", FontWeight.BOLD, 20));

        Label locationLabel = new Label("Location:");
        TextField locationTextField = new TextField();
        locationTextField.setMaxWidth(350);
        locationLabel.setFont(Font.font("", FontWeight.BOLD, 20));

        VBox fieldBox1 = new VBox(10, foodtypeLabel, foodtypeTextField);
        fieldBox1.setMaxSize(300, 30);

        VBox fieldBox2 = new VBox(10, cookdateLabel, cookingDatePicker);
        fieldBox2.setMaxSize(300, 30);

        VBox fieldBox4 = new VBox(10, quantityLabel, quantityTextField);
        fieldBox4.setMaxSize(300, 30);

        VBox fieldBox5 = new VBox(10, locationLabel, locationTextField);
        fieldBox5.setMaxSize(300, 30);

        Button addButton = new Button("Add");
        addButton.setAlignment(Pos.CENTER);
        addButton.setFont(Font.font("", FontWeight.BOLD, 18));
        addButton.setStyle("-fx-background-color: LIGHTBLUE;");

        addButton.setOnAction(event -> {
            handleAddButton(primaryStage, foodtypeTextField.getText(), cookingDatePicker.getValue(), quantityTextField.getText(), locationTextField.getText());
        });

        Label donateNowLabel = new Label("Donate Now");
        donateNowLabel.setFont(new Font("Arial", 24));
        donateNowLabel.setTextFill(Color.WHITE);
        donateNowLabel.setBackground(new Background(new BackgroundFill(Color.DARKBLUE, new CornerRadii(5), Insets.EMPTY)));
        donateNowLabel.setPadding(new Insets(10));
        donateNowLabel.setAlignment(Pos.CENTER);

        VBox vbox = new VBox(25, donateNowLabel, fieldBox1, fieldBox2, fieldBox4, fieldBox5, addButton);
        vbox.setAlignment(Pos.CENTER);
      //  vbox.setStyle("-fx-background-color: LIGHTYELLOW; -fx-border-color: BLACK; -fx-border-width: 2; //-fx-border-radius: 10; -fx-padding: 20;");

        StackPane root = new StackPane();
        root.setAlignment(Pos.CENTER);
        ImageView background = createBackgroundImageView("D:\\JavaFXProject\\c2w_project (2)_safe\\c2w_project\\food_donate_final\\food_donate\\src\\main\\java\\com\\Assets\\donationFOrm.jpg");
        background.setOpacity(0.5); // Set the opacity of the background image to less than 1.0
        background.fitWidthProperty().bind(primaryStage.widthProperty());
        background.fitHeightProperty().bind(primaryStage.heightProperty());
        root.getChildren().addAll(background, vbox);

        return new Scene(root, 1800, 1000);
    }

    private void handleAddButton(Stage primaryStage, String foodtype, LocalDate cookingDate, String quantity, String location) {
        DataService dataService;
        try {
            dataService = new DataService();
            Map<String, Object> data = new HashMap<>();
            data.put("foodtype", foodtype);
            data.put("cookingdate", cookingDate != null ? cookingDate.toString() : "");
            data.put("quantity", quantity);
            data.put("location", location);
            data.put("timestamp", LocalDate.now().toString());

            dataService.addData("Food Information", foodtype, data);

            // Show popup message
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Thank You");
            alert.setHeaderText(null);
            alert.setContentText("Thank you for donating!");
            alert.showAndWait();

            System.out.println("Donated successfully");
            loginController.showLoginScene();

        } catch (Exception e) {
            e.printStackTrace();
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
