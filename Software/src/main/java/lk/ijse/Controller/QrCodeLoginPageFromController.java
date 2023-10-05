package lk.ijse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.DataBaseConnecter;
import lk.ijse.QrCode.QrCodeScanner;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class QrCodeLoginPageFromController implements Initializable {
    @FXML
    private AnchorPane Pane;

    public String Mother_name;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    void OnClickBack(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(this.getClass().getResource("/View/LoginPage.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) this.Pane.getScene().getWindow();
        stage.setTitle("DashBoard");
        stage.setScene(scene);
    }

    @FXML
    void OnClickScan(ActionEvent event) throws IOException {
        String[][] details = DataBaseConnecter.getDetails("user",5);
        QrCodeScanner.QrScanner();
        String value = QrCodeScanner.value;
        Mother_name = value;
        for (int i = 0; i < details.length; i++) {
            if (details[i][0].equals(value)) {
                Parent parent = FXMLLoader.load(this.getClass().getResource("/View/DashbordForm.fxml"));
                Scene scene = new Scene(parent);
                Stage stage = (Stage) this.Pane.getScene().getWindow();
                stage.setTitle("DashBoard");
                stage.setScene(scene);
            }
        }
    }
    
}
