import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class Transitions {

    public static void open(String fxmlFileName, String title, ActionEvent actionEvent) throws IOException {
        Stage manageParksStage = new Stage ();
        Parent root = FXMLLoader.load(Transitions.class.getResource(fxmlFileName));
        manageParksStage.setTitle(title);
        manageParksStage.setScene(new Scene(root));
        manageParksStage.setResizable(false);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
        manageParksStage.show();
    }
    public static void alertMessage (){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
       // stage.getIcons().add(new Image(Transitions.class.getResource("/views/error.png").toString()));
        alert.setTitle("ATTENTION");
        alert.setHeaderText("Please select from the table!");
        alert.showAndWait();
    }



}
