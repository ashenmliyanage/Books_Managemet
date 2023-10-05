package lk.ijse.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import lk.ijse.Controller.Model.Contact;

import java.net.URL;
import java.util.ResourceBundle;

public class ContactItemConroller implements Initializable {


    @FXML
    private Label Name;

    @FXML
    private Label U_ID;

    public void setData(Contact contact){
        Name.setText(contact.getName());
        U_ID.setText(contact.getU_ID());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
