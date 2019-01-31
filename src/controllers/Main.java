package controllers;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

//TODO INITIALIZABLE FOR STATISTICS MAYBE
public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../views/HomeScreen.fxml"));
        primaryStage.setTitle("Building Manager");
        primaryStage.getIcons().add(new Image("./views/icon.png"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
//String fxmlFileName, String title, ActionEvent actionEvent
    public void agentDeskBtnAction(ActionEvent actionEvent) throws IOException {
        Transitions.open("../views/AgentDesk.fxml", "Agent Desk", actionEvent);
    }
}
