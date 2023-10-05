package lk.ijse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lk.ijse.Controller.Model.Contact;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class BookManagementFromController implements Initializable {
    @FXML
    private TextField searchbar;
    public String Name;

    public String getName() {
        return this.Name;
    }

    public void setName(String name) {
        this.Name = name;
    }
    public String na;
    @FXML
    private AnchorPane Pane;

    @FXML
    void AddbtnOnAction(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(this.getClass().getResource("/View/AddBookForm.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) this.Pane.getScene().getWindow();
        stage.setTitle("Books Management");
        stage.setScene(scene);
    }

    @FXML
    void serachOnAtion(ActionEvent event) throws IOException {

        String[] Book= new String[10];

        for (int i = 0; i < Book.length; i++) {
            Book[i] = "B00"+(i+1);
        }
        String BookName = this.searchbar.getText();
        for (int i = 0; i < Book.length; i++) {
            if (Book[i].equals(BookName)) {
                setName(BookName);
                na = BookName;
                System.out.println(getName());
                Parent parent = FXMLLoader.load(this.getClass().getResource("/View/BookViewPopUp/ViewFrom.fxml"));
                Scene scene = new Scene(parent);
                Stage stage = new Stage();
                stage.setTitle("Login Page");
                stage.centerOnScreen();
                stage.setScene(scene);
                stage.show();
            }
        }
    }


    @FXML
    void OnclckDashbord(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(this.getClass().getResource("/View/DashbordForm.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) this.Pane.getScene().getWindow();
        stage.setTitle("Books Management");
        stage.setScene(scene);
    }

    private List<Contact> contacts(){
        List<Contact> list = new ArrayList<>();
        Contact contact = new Contact();

        contact.setName("Ashen");
        contact.setU_ID("U001");
        list.add(contact);

        contact.setU_ID("New");
        contact.setName("nreee");

        return list;
    }


    @FXML
    void memberbtnOnActhion(ActionEvent event) {

    }

    @FXML
    private VBox BD;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /*List<Contact> contacts = new ArrayList<>(contacts());
        for(int i=0; i<contacts.size(); i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/View/Contact/ContactItem.fxml"));

            try {
                HBox hBox = fxmlLoader.load();
                ContactItemConroller contactItemConroller = fxmlLoader.getController();
                contactItemConroller.setData(contacts.get(i));
                BD.getChildren().add(hBox);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }*/
    }
}
