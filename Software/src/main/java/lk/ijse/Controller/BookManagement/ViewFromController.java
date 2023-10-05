package lk.ijse.Controller.BookManagement;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import lk.ijse.Controller.BookManagementFromController;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewFromController extends BookManagementFromController implements Initializable {

    @FXML
    private Label BookID;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /*BookID.setText(getName());
        System.out.println(na);*/
    }
}
