package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Agent;
import models.Building;
import models.DBmethods.AgentMethods;
import models.DBmethods.BuildingMethods;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AgentWorkbenchController implements Initializable {
    @FXML
    public Label pleaseFillAllFieldsLabel;
    @FXML
    public TextField addressInput;
    @FXML
    public TextField floorsInput;
    @FXML
    public TextField commonPartsInput;
    @FXML
    public TextField numApInput;
    @FXML
    public Button createContractBtn;
    @FXML
    public Button backBtn;
    @FXML
    public Button homeBtn;
    @FXML
    public Label agentNameLabel;
    @FXML
    public Label salaryLabel;
    @FXML
    public Button salaryBtn;
    @FXML
    public Button deleteBuildingBtn;
    @FXML
    public Button observeBuildingBtn;
    @FXML
    public TableView buildingsTableView;
    @FXML
    public TableColumn buildingAddressColumn;
    @FXML
    public TableColumn floorsColumn;
    @FXML
    public TableColumn commonPartColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Agent agi = AgentsDeskController.getSelectedAgent();
        int agiID = agi.getIdAgent();
        final ObservableList<Building> agentData = FXCollections.observableArrayList(BuildingMethods.getBuildingsWithAgent(agiID));
        salaryLabel.setText("Make calculation");
        agentNameLabel.setText(agi.getName());
        buildingAddressColumn.setCellValueFactory(
                new PropertyValueFactory<>("address"));
        floorsColumn.setCellValueFactory(
                new PropertyValueFactory<>("numberOfFloors"));
        commonPartColumn.setCellValueFactory(
                new PropertyValueFactory<>("commonParts"));


        buildingsTableView.setItems(agentData);


    }

    public void backBtnAction(ActionEvent actionEvent) throws IOException {
        Transitions.open("../views/AgentDesk.fxml", "Agent Desk", actionEvent);
    }

    public void homeBtnAction(ActionEvent actionEvent) throws IOException {
        Transitions.home(actionEvent);
    }

    public void salaryBtnAction(ActionEvent actionEvent) {
    }

    public void deleteBuildingBtnAction(ActionEvent actionEvent) {
        Building selectedObject = (Building) buildingsTableView.getSelectionModel().getSelectedItem();
        if (selectedObject != null) {
            buildingsTableView.getItems().removeAll(selectedObject);
            AgentMethods.deleleteAgent(selectedObject.getIdBuilding());
        }else{
            Transitions.alertMessage();
        }
    }

    public void observeBuildingBtnAction(ActionEvent actionEvent) throws IOException {
        Transitions.open("../views/ObserveBuildingScreen.fxml", "Observe Building", actionEvent);
    }

    public void createContractBtnAction(ActionEvent actionEvent) {
        Agent ag = AgentMethods.getOne(AgentsDeskController.getSelectedAgent().getIdAgent());
        final ObservableList<Building> bData = FXCollections.observableArrayList(BuildingMethods.getBuildingsWithAgent(ag.getIdAgent()));
        if (addressInput.getText().isEmpty() || floorsInput.getText().isEmpty() || numApInput.getText().isEmpty() || commonPartsInput.getText().isEmpty()) {
            pleaseFillAllFieldsLabel.setText("Please fill all fields!");
        } else {
            String a = addressInput.getText();
            int b = Integer.valueOf(floorsInput.getText());
            int c = Integer.valueOf(commonPartsInput.getText());
            int d = Integer.valueOf(numApInput.getText());
            int e = Integer.valueOf(numApInput.getText());
            Integer agID = ag.getIdAgent();
            BuildingMethods.addBuilding(a, b, c, d, e, agID);
            pleaseFillAllFieldsLabel.setText("Contract SIGNED!");
        }
    }


}
