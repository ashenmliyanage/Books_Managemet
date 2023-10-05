package lk.ijse.Controller.MemberManagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.DataBaseConnecter;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddMemberFormController implements Initializable {
    @FXML
    private TextField Address;

    @FXML
    private TextField ID;

    @FXML
    private TextField Name;

    @FXML
    private TextField Num;

    @FXML
    private TextField Pass;

    private String BookID;

    public String getBookID() {
        return BookID;
    }

    public void setBookID(String bookID) {
        BookID = bookID;
    }

    @FXML
    void btnOnActhion(ActionEvent event) {
        DataBaseConnecter.setDetails("INSERT INTO library_management.member (Username, UserId, Address, Password, Number)\n" +
                "VALUES ('"+Name.getText()+"', '"+ID.getText()+"', '"+Address.getText()+"', '"+Pass.getText()+"', "+Num.getText()+");");
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[][] member = DataBaseConnecter.getDetails("books",4);
        String BookID = "B"+(member.length+1);
        setBookID(BookID);
        ID.setText(getBookID());
    }
    @FXML
    private AnchorPane Pane;

    @FXML
    void backOnActhion(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(this.getClass().getResource("/View/MembersManagementForm.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) this.Pane.getScene().getWindow();
        stage.setTitle("DashBoard");
        stage.setScene(scene);
    }
}
