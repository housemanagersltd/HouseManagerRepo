package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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
    public TableColumn commonPartsColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

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
    }

    public void observeBuildingBtnAction(ActionEvent actionEvent) throws IOException {
        Transitions.open("../views/ObserveBuildingScreen.fxml", "Observe Building", actionEvent);
    }

    public void createContractBtnAction(ActionEvent actionEvent) {
        if (addressInput.getText().isEmpty() || floorsInput.getText().isEmpty() || commonPartsInput.getText().isEmpty()){
            pleaseFillAllFieldsLabel.setText("Please fill all fields!");
        }else{
            System.out.println("WRITE SOME CODE HERE!");
        }
    }


}
