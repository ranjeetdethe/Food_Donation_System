package com.ngo_food.initialize;

import com.ngo_food.controller.LoginController;
import com.ngo_food.dashboard.DonationForm;

import javafx.application.Application;
import javafx.stage.Stage;

public class InitializeApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        LoginController loginController = new LoginController(primaryStage);
        //DonationForm donationForm = new DonationForm(loginController);

        primaryStage.setScene(loginController.getLoginScene());
    
       // primaryStage.setScene(null);

        primaryStage.setTitle("Login");

        primaryStage.show();
    }
}