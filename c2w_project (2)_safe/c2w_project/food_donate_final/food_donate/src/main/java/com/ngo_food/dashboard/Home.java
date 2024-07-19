// package com.ngo_food.dashboard;

// import com.ngo_food.controller.LoginController;

// import javafx.event.ActionEvent;
// import javafx.event.EventHandler;
// import javafx.geometry.Pos;
// import javafx.scene.Scene;
// import javafx.scene.control.Button;
// import javafx.scene.layout.VBox;
// import javafx.stage.Stage;

// public class Home {

//     private Stage primaryStage;
//     private Object dataService;
    

// private LoginController loginController;

//     public Home(LoginController loginController){
//         this.loginController= loginController;
//     }
    
//     public Scene showHomeScene(Stage primaryStage) {
//         Button abountButton = new Button("About");
//         Button donarButton = new Button("Donate");
//         Button accepButton = new Button("Accept");

    
    



//        donarButton.setOnAction(new EventHandler<ActionEvent>() {
//             @Override
//             public void handle(ActionEvent event) {
//                // handleLogin(userTextField.getText(), passField.getText());
//                 //showDonationScene();
//                 //userTextField.clear();
//                 //passField.clear();
//             }
//         });
    

//     VBox vb = new VBox(20, abountButton, donarButton, accepButton);
//     vb.setStyle(
//                 "-fx-background-image:url('https://s3.us-west-2.amazonaws.com/images.unsplash.com/application-1720246650495-8366564e5d11image')");
//         vb.setAlignment(Pos.CENTER);
//     return new Scene(vb,800,800);
//     }

// }
