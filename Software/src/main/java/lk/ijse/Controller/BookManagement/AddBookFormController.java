package lk.ijse.Controller.BookManagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import lk.ijse.DataBaseConnecter;

import java.net.URL;
import java.util.ResourceBundle;

public class AddBookFormController implements Initializable {

    @FXML
    private TextField DIS;

    @FXML
    private TextField ID;

    @FXML
    private TextField LOC;

    @FXML
    private TextField Name;

    private String BookID;

    public String getBookID() {
        return BookID;
    }

    public void setBookID(String bookID) {
        BookID = bookID;
    }

    @FXML
    void addButtonOnAction(ActionEvent event) {
        DataBaseConnecter.setDetails("INSERT INTO library_management.books (BookName, Book_ID, Dis, LOC)\n" +
                "VALUES ('"+Name.getText()+"', '"+getBookID()+"', '"+DIS.getText()+"', '"+LOC.getText()+"');");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[][] Books = DataBaseConnecter.getDetails("books",4);
        String BookID = "B"+(Books.length+1);
        setBookID(BookID);
        ID.setText(getBookID());
    }
}
