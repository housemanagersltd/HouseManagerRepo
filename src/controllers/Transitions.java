package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Transitions {

    public static void open(String fxmlFileName, String title, ActionEvent actionEvent) throws IOException {
        Stage manageBuilding = new Stage ();
        Parent root = FXMLLoader.load(Transitions.class.getResource(fxmlFileName));
        manageBuilding.setTitle(title);
        manageBuilding.setScene(new Scene(root));
        manageBuilding.getIcons().add(new Image("./views/icon.png"));
        manageBuilding.setResizable(false);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
        manageBuilding.show();
    }
    public static void alertMessage (){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        //stage.getIcons().add(new Image(controllers.Transitions.class.getResource("/views/error.png").toString()));
        alert.setTitle("ATTENTION");
        alert.setHeaderText("Please select from the table!");
        alert.showAndWait();
    }
    public static void home(ActionEvent actionEvent) throws IOException {
        open("../views/HomeScreen.fxml", "Building Manager", actionEvent);

    }


}
