package com.ngo_food.dashboard;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Map;
// import java.util.concurrent.ExecutionException;

// import com.google.api.core.ApiFuture;
// import com.google.cloud.firestore.CollectionReference;
// import com.google.cloud.firestore.DocumentSnapshot;
// import com.google.cloud.firestore.Query;
// import com.google.cloud.firestore.QuerySnapshot;
// import com.ngo_food.controller.LoginController;
// import com.ngo_food.firebaseConfig.DataService;

// import javafx.event.ActionEvent;
// import javafx.event.EventHandler;
// import javafx.geometry.Pos;
// import javafx.scene.Scene;
// import javafx.scene.control.Button;
// import javafx.scene.control.Label;
// import javafx.scene.control.TextField;
// import javafx.scene.layout.HBox;
// import javafx.scene.layout.VBox;
// import javafx.stage.Stage;

// public class NGOPage {
//     private LoginController loginController;

//     public NGOPage(LoginController loginController){
//         this.loginController= loginController;
//     }


//     public Scene NGOPageScene(Stage primaryStage) {
//         // Label foodtypeLabel = new Label("Enter Your Food Type:");
//         // TextField foodtypeTextField = new TextField(str=getText());
//         // Label cookdateLabel = new Label("Cooking Date");
//         // TextField cookingdateTextField = new TextField();
//         // Label CookingDate = new Label("Expirey Date");
//         // TextField availableTextField = new TextField();
//         // Label availableLabel = new Label("Availablity");
//         // TextField QuantityTextField = new TextField();
//         // Label QuantityLabel = new Label("Quantity");
//         // TextField locationTextField = new TextField();

        
//         // HBox hb = new HBox(foodtypeLabel,foodtypeTextField,cookdateLabel,cookingdateTextField,CookingDate,availableLabel,availableTextField,QuantityLabel,QuantityTextField,loactionLabel,locationTextField);
        
//         Button AcceptButton = new Button("Accept");
//         AcceptButton.setAlignment(Pos.CENTER);

//         AcceptButton.setOnAction(new EventHandler<ActionEvent>() {
//             @Override
//             public void handle(ActionEvent event) {
                
//             }
//         });
//         Button DeclineButton = new Button("Decline");
//         DeclineButton.setAlignment(Pos.CENTER);

//         DeclineButton.setOnAction(new EventHandler<ActionEvent>() {
//             @Override
//             public void handle(ActionEvent event) {
                
//             }
//         });
//         return new Scene(AcceptButton,450,500);
//     }
    

//     public List<Map<String, Object>> getDataInDescendingOrder(String collectionName,
//             String orderByField) throws ExecutionException, InterruptedException {
//         List<Map<String, Object>> documentsList = new ArrayList<>();

//         // Create a query against the collection
//         CollectionReference collection = DataService.db.collection(collectionName);
//         Query query = collection.orderBy(orderByField, Query.Direction.DESCENDING);

//         // Execute the query
//         ApiFuture<QuerySnapshot> querySnapshot = query.get();

//         for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
//             documentsList.add(document.getData());
//         }

//         return documentsList;
//     }
    

//     public static VBox loadProjectDetails() {
//         VBox vbox = new VBox();
//         vbox.setSpacing(10);
//         try {
//             vbox.getChildren().clear(); // Clear existing cards
//             List<Map<String, Object>> projectDetails = DataService.getDataInDescendingOrder("Food Information",
//                     "timestamp");
//             for (Map<String, Object> projectDetail : projectDetails) {
//                 System.out.println(projectDetail.get("foodtype"));
//             }
//         } catch (ExecutionException | InterruptedException ex) {    
//             ex.printStackTrace();
//         }
//         return vbox;
//     }



//     public Scene createNGOScene(Stage primaryStage) {
//         throw new UnsupportedOperationException("Unimplemented method 'createNGOScene'");
//     }
// }

//     // public static void main(String[] args) {
//     //     NGOPage ngo = new NGOPage();
//     //     try {
//     //         ngo.getDataInDescendingOrder("Food Information", "Burger");
//     //     } catch (ExecutionException e) {
//     //         // TODO Auto-generated catch block
//     //         e.printStackTrace();
//     //     } catch (InterruptedException e) {
//     //         // TODO Auto-generated catch block
//     //         e.printStackTrace();
//     //     }
//     // }

// import com.google.api.core.ApiFuture;
// import com.google.cloud.firestore.CollectionReference;
// import com.google.cloud.firestore.DocumentSnapshot;
// import com.google.cloud.firestore.Query;
// import com.google.cloud.firestore.QuerySnapshot;
// import com.ngo_food.firebaseConfig.DataService;

// import javafx.scene.control.Label;
// import javafx.scene.layout.VBox;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Map;
// import java.util.concurrent.ExecutionException;

// public class NGOPage {
//     // Constructor and other methods as before...

//     public static VBox loadProjectDetails() {
//         VBox vbox = new VBox();
//         vbox.setSpacing(10);
        
//         try {
//             // vbox.getChildren().clear(); // Clear existing cards
//             List<Map<String, Object>> projectDetails = getDataInDescendingOrder("Food Information", "timestamp");
            
//             for (Map<String, Object> projectDetail : projectDetails) {
                
//                 Label foodLabel = new Label((String) projectDetail.get("foodtype"));
//                 Label avLabel = new Label ((String)projectDetail.get("Availablity"));
//                 Label qLabel = new Label ((String)projectDetail.get("Quantity"));
//                 Label cLabel = new Label ((String)projectDetail.get("cookingdate"));
//                 Label loLabel = new Label ((String)projectDetail.get("location"));
                

//                 vbox.getChildren().addAll(foodLabel,avLabel,qLabel,cLabel,loLabel);
//             }
//         } catch (ExecutionException | InterruptedException ex) {
//             ex.printStackTrace();
//         }
        
//         return vbox;
//     }

//     public static List<Map<String, Object>> getDataInDescendingOrder(String collectionName, String orderByField)
//             throws ExecutionException, InterruptedException {
//         List<Map<String, Object>> documentsList = new ArrayList<>();

//         // Create a query against the collection
//         CollectionReference collection = DataService.db.collection(collectionName);
//         Query query = collection.orderBy(orderByField, Query.Direction.DESCENDING);

//         // Execute the query
//         ApiFuture<QuerySnapshot> querySnapshot = query.get();

//         for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
//             documentsList.add(document.getData());
//             System.out.println(document.get("location"));
//             System.out.println(document.get("foodType"));
//         }

//         return documentsList;

    
//     }
    
// }
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QuerySnapshot;
import com.ngo_food.controller.LoginController;
import com.ngo_food.firebaseConfig.DataService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class NGOPage {

    private static LoginController loginController;

    public NGOPage(LoginController loginController) {
        this.loginController= loginController;
    }

    public static VBox loadProjectDetails() {
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10));

        TableView<ProjectDetail> tableView = new TableView<>();
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn<ProjectDetail, String> foodTypeColumn = new TableColumn<>("Food Type");
        foodTypeColumn.setCellValueFactory(new PropertyValueFactory<>("foodType"));

        TableColumn<ProjectDetail, String> cookingDateColumn = new TableColumn<>("Cooking Date");
        cookingDateColumn.setCellValueFactory(new PropertyValueFactory<>("cookingDate"));

        TableColumn<ProjectDetail, String> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        TableColumn<ProjectDetail, String> locationColumn = new TableColumn<>("Location");
        locationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));

        TableColumn<ProjectDetail, Void> actionsColumn = new TableColumn<>("Actions");
        actionsColumn.setCellFactory(param -> new TableCell<ProjectDetail, Void>() {
            private final Button acceptButton = new Button("Accept");
            private final Button declineButton = new Button("Decline");

            {
                acceptButton.setStyle("-fx-background-color: green; -fx-text-fill: white;");
                declineButton.setStyle("-fx-background-color: red; -fx-text-fill: white;");

                acceptButton.setOnAction(event -> {
                    ProjectDetail projectDetail = getTableView().getItems().get(getIndex());
                    handleAcceptButton(projectDetail);
                });

                declineButton.setOnAction(event -> {
                    ProjectDetail projectDetail = getTableView().getItems().get(getIndex());
                    handleDeclineButton(projectDetail);
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    HBox hbox = new HBox(acceptButton, declineButton);
                    hbox.setSpacing(10);
                    setGraphic(hbox);
                }
            }
        });

        tableView.getColumns().addAll(foodTypeColumn, cookingDateColumn, quantityColumn, locationColumn, actionsColumn);

        try {
            ObservableList<ProjectDetail> projectDetails = FXCollections.observableArrayList();
            List<Map<String, Object>> data = getDataInDescendingOrder("Food Information", "timestamp");

            for (Map<String, Object> projectDetail : data) {
                ProjectDetail detail = new ProjectDetail(
                        (String) projectDetail.get("foodtype"),
                        (String) projectDetail.get("cookingdate"),
                        (String) projectDetail.get("quantity"),
                        (String) projectDetail.get("location")
                );
                projectDetails.add(detail);
            }

            tableView.setItems(projectDetails);
        } catch (ExecutionException | InterruptedException ex) {
            ex.printStackTrace();
        }

        Button backButton = new Button("Back");
        backButton.setStyle("-fx-background-color: LIGHTBLUE");

        backButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                loginController.showLoginScene();
            }
        });

        vbox.getChildren().addAll(tableView, backButton);
        return vbox;
    }

    public static List<Map<String, Object>> getDataInDescendingOrder(String collectionName, String orderByField)
            throws ExecutionException, InterruptedException {
        List<Map<String, Object>> documentsList = new ArrayList<>();

        CollectionReference collection = DataService.db.collection(collectionName);
        Query query = collection.orderBy(orderByField, Query.Direction.DESCENDING);

        ApiFuture<QuerySnapshot> querySnapshot = query.get();

        for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
            documentsList.add(document.getData());
        }

        return documentsList;
    }

    private static void handleAcceptButton(ProjectDetail projectDetail) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Donation Accepted");
        alert.setHeaderText(null);
        alert.setContentText("Thank you for donating!");

        alert.showAndWait();

        System.out.println("Accepted: " + projectDetail.getFoodType());
        // Add your logic here
    }

    private static void handleDeclineButton(ProjectDetail projectDetail) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm Decline");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to decline this donation?");

        ButtonType yesButton = new ButtonType("Yes", ButtonBar.ButtonData.YES);
        ButtonType noButton = new ButtonType("No", ButtonBar.ButtonData.NO);

        alert.getButtonTypes().setAll(yesButton, noButton);

        // Handling the result of the confirmation dialog
        alert.showAndWait().ifPresent(buttonType -> {
            if (buttonType == yesButton) {
                // Perform decline action
                System.out.println("Declined: " + projectDetail.getFoodType());
                // Navigate back to the login scene
                loginController.showLoginScene();
            }
        });
    }

    public static class ProjectDetail {
        private final String foodType;
        private final String cookingDate;
        private final String quantity;
        private final String location;

        public ProjectDetail(String foodType, String cookingDate, String quantity, String location) {
            this.foodType = foodType;
            this.cookingDate = cookingDate;
            this.quantity = quantity;
            this.location = location;
        }

        public String getFoodType() {
            return foodType;
        }

        public String getCookingDate() {
            return cookingDate;
        }

        public String getQuantity() {
            return quantity;
        }

        public String getLocation() {
            return location;
        }
    }
}
