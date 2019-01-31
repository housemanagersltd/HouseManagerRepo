package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ObserveApartmentController implements Initializable {

    @FXML
    public Button backBtn;
    @FXML
    public Label familyNameLabel;
    @FXML
    public Label numberOfApartmentLabel;
    @FXML
    public Button deleteApartmentBtn;
    @FXML
    public Button payTaxBtn;
    @FXML
    public CheckBox selectAllResidentsCheck;
    @FXML
    public TableView residentsTableView;
    @FXML
    public TableColumn nameColumn;
    @FXML
    public TableColumn hasPaidColumn;
    @FXML
    public TableColumn statusColumn;
    @FXML
    public Button addResident;
    @FXML
    public Label fillAllFieldsLabel;
    @FXML
    public Button homeBtn;
    @FXML
    public RadioButton retiredRadio;
    @FXML
    public RadioButton childRadio;
    @FXML
    public RadioButton disabledRadio;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        final ToggleGroup group = new ToggleGroup();
        retiredRadio.setToggleGroup(group);
        childRadio.setToggleGroup(group);
        disabledRadio.setToggleGroup(group);
        retiredRadio.setUserData("Retired");
        childRadio.setUserData("Child");
        disabledRadio.setUserData("Disabled");


        //radioButtons();
    }
    public String radioButtons(){
        if (retiredRadio.isSelected()){
            //System.out.println(group.getSelectedToggle().getUserData().toString());
            return "Retired";
        }else if(childRadio.isSelected()){
            System.out.println("Child");
            return "Child";
        }else if(disabledRadio.isSelected()){
            System.out.println("Disabled");
           return "Disabled";
        }else{
            return "";
        }
    }
    public void addResidentAction(ActionEvent actionEvent) {

    }

    public void disabledCheckBoxAction(ActionEvent actionEvent) {

    }

    public void childCheckBoxAction(ActionEvent actionEvent) {

    }

    public void retiredCheckBoxAction(ActionEvent actionEvent) {

    }

    public void selectAllResidentsCheckAction(ActionEvent actionEvent) {

    }

    public void payTaxBtnAction(ActionEvent actionEvent) {

    }

    public void deleteApartmentBtnAction(ActionEvent actionEvent) {

    }
    //DONE
    public void backBtnAction(ActionEvent actionEvent) throws IOException {
        Transitions.open("../views/ObserveBuildingScreen.fxml", "Observe Building", actionEvent);
    }
    //DONE
    public void homeBtnAction(ActionEvent actionEvent) throws IOException {
        Transitions.home(actionEvent);
    }
}
