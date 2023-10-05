package lk.ijse.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.DataBaseConnecter;

import java.io.IOException;

public class LoginPageFormController {
    @FXML
    private AnchorPane Pane;

    @FXML
    private Label UserNameIncorrect;

    @FXML
    private Label PassowordIncorrect;

    @FXML
    private JFXButton Loginbtn;

    @FXML
    private PasswordField Password;

    @FXML
    private TextField UserName;



    @FXML
    void LoginBtnOnAction(ActionEvent event) throws IOException {
        String UserName = this.UserName.getText();
        String Password = this.Password.getText();
        String[][] UserDetails = DataBaseConnecter.getDetails("User",5);

        //System.out.println(UserName + "\n" + Password);

        for (int i = 0; i < UserDetails.length; i++) {
            if (UserName.equals(UserDetails[i][0])) {
                    UserNameIncorrect.setOpacity(0);
                if (Password.equals(UserDetails[i][4])) {
                    PassowordIncorrect.setOpacity(0);
                    //System.out.println("Log");
                    Parent parent = FXMLLoader.load(this.getClass().getResource("/View/DashbordForm.fxml"));
                    Scene scene = new Scene(parent);
                    Stage stage = (Stage) this.Pane.getScene().getWindow();
                    stage.setTitle("DashBoard");
                    stage.setScene(scene);
                }
                else {
                    PassowordIncorrect.setText("Password is incorrect ! ");
                }
            }
            else {
                UserNameIncorrect.setText("Username is incorrect ! ");
            }
        }
    }
    @FXML
    void ScanbtnOnActhion(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(this.getClass().getResource("/View/QrCodeLoginPageFrom.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) this.Pane.getScene().getWindow();
        stage.setTitle("DashBoard");
        stage.setScene(scene);
    }
}
