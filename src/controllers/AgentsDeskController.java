package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AgentsDeskController implements Initializable {
    @FXML
    public TableView agentsTableView;
    @FXML
    public TableColumn agentNameColumn;
    @FXML
    public TableColumn phoneNumberColumn;
    @FXML
    public Button backBtn;
    @FXML
    public Button deleteAgentBtn;
    @FXML
    public Button observeAgentBtn;
    @FXML
    public Button hireAgentBtn;
    @FXML
    public Text pleaseFillNameLabel;
    @FXML
    public TextField agentNameInput;
    @FXML
    public Label fillAllFieldsLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void hireAgentBtnAction(ActionEvent actionEvent) {
        if (agentNameInput.getText().isEmpty()){
            fillAllFieldsLabel.setText("Please fill all fields!");
        }
    }

    public void observeAgentAction(ActionEvent actionEvent) throws IOException {
        Transitions.open("../views/AgentWorkbenchScreen.fxml", "Agent Workbench", actionEvent);
    }

    public void deleteAgentBtnAction(ActionEvent actionEvent) {
    }

    //DONE
    public void backBtnAction(ActionEvent actionEvent) throws IOException {
        Transitions.home(actionEvent);
    }



}
