package com.ngo_food.dashboard;

import com.google.cloud.firestore.DocumentSnapshot;
import com.ngo_food.controller.LoginController;
import com.ngo_food.firebaseConfig.DataService;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class UserPage {
    static String userName;
    private DataService dataService;
    VBox vb;
    private DonationForm donationForm;
    //private Home home;
    private Node vbox;

    public UserPage(DataService dataService,DonationForm donationForm) {
        this.dataService = dataService;
        this.donationForm= donationForm;
        //this.donationForm=home;
    }

    public Parent createUserScene(Runnable logoutHandler,DonationForm donationForm) {
        Button logoutButton = new Button("Logout");
        Label dataLabel = new Label();

        try {
            String key = LoginController.key;
            System.out.println("Value of key: " + key);
            DocumentSnapshot dataObject = dataService.getData("users", key);
            userName = dataObject.getString("username");
            System.out.println("username fetched: " + userName);
            dataLabel.setText(userName);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        logoutButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                logoutHandler.run();
            }
        });
        

        

      // Text message = new Text("Welcome " + dataLabel.getText());
        //message.setStyle("-fx-text-fill: white;-fx-font-weight:bold;-fx-font-size:60");

        vb = new VBox(350,logoutButton);
        vb.setStyle("-fx-background-color:DARKGREY");

        return vb;
    }

    
}
