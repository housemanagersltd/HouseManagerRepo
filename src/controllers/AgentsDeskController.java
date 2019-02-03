package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import models.Agent;
import models.DBmethods.AgentMethods;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AgentsDeskController implements Initializable {
    @FXML
    public TableView<Agent> agentsTableView;
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

    private static Agent selectedAgent;
    public static Agent getSelectedAgent(){
        return selectedAgent;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        final ObservableList<Agent> agentData = FXCollections.observableArrayList(AgentMethods.getAgents());

        agentNameColumn.setCellValueFactory(
                new PropertyValueFactory<>("name"));

        agentsTableView.setItems(agentData);

    }

    public void hireAgentBtnAction(ActionEvent actionEvent) {
        if (agentNameInput.getText().isEmpty()) {
            fillAllFieldsLabel.setText("Please fill all fields!");
        } else {
            String name;
            name = agentNameInput.getText();
            AgentMethods.addAgent(name);
            ObservableList<Agent> data = FXCollections.observableArrayList(AgentMethods.getAgents());
            agentsTableView.setItems(data);
        }
    }



    public void observeAgentAction(ActionEvent actionEvent) throws IOException {

        selectedAgent = agentsTableView.getSelectionModel().getSelectedItem();
        if (selectedAgent != null) {
            Transitions.open("../views/AgentWorkbenchScreen.fxml", "Agent Workbench", actionEvent);
        }else{
            Transitions.alertMessage();
        }
    }

    public void deleteAgentBtnAction(ActionEvent actionEvent) {
        Agent selectedObject = agentsTableView.getSelectionModel().getSelectedItem();
        if (selectedObject != null) {
            agentsTableView.getItems().removeAll(selectedObject);
            AgentMethods.deleleteAgent(selectedObject.getIdAgent());
        }else{
            Transitions.alertMessage();
        }
    }

    public void backBtnAction(ActionEvent actionEvent) throws IOException {
        Transitions.home(actionEvent);
    }


}
