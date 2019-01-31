package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class ObserveBuildingController {
    @FXML
    public Button backBtn;
    @FXML
    public Button homeBtn;
    @FXML
    public Label buildingAddressLabel;
    @FXML
    public Label taxPerResidentLabel;
    @FXML
    public Label amountPaidLabel;
    @FXML
    public TableView apartmentsTableView;
    @FXML
    public TableColumn familyNameColumn;
    @FXML
    public TableColumn numberColumn;
    @FXML
    public TextField familyNameInput;
    @FXML
    public ComboBox comboBoxFreeApartments;
    @FXML
    public Button addApartmentBtn;
    @FXML
    public Label fillAllInputsLabel;
    public Button disableApartmentBtn;
    public Button observeApartmentBtn;


    public void backBtnAction(ActionEvent actionEvent) throws IOException {
        Transitions.open("../views/AgentWorkbenchScreen.fxml", "Agent AgentWorkbench", actionEvent);
    }
    public void homeBtnAction(ActionEvent actionEvent) throws IOException {
        Transitions.home(actionEvent);
    }

    public void comboBoxFreeApartmentsAction(ActionEvent actionEvent) {

    }

    public void addApartmentBtnAction(ActionEvent actionEvent) {
        if (familyNameInput.getText().isEmpty()){
            fillAllInputsLabel.setText("Please fill all inputs!");
        }else{
            System.out.println("WRITE SOME CODE HERE!");
        }
    }

    public void disableApartmentBtnAction(ActionEvent actionEvent) {
    }

    public void observeApartmentBtnAction(ActionEvent actionEvent) throws IOException {
        Transitions.open("../views/ObserveApartmentScreen.fxml", "Observe Apartment", actionEvent);
    }
}
