package lk.ijse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lk.ijse.Controller.Model.Contact;
import lk.ijse.DataBaseConnecter;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

class User{
    String Name;
    int Count;

}

public class DashbordFormController implements Initializable {

    @FXML
    private AnchorPane Pane;

    @FXML
    private Label B_name;

    @FXML
    private Label B_name1;

    @FXML
    private Label B_name2;

    @FXML
    private Label B_name3;

    @FXML
    private Label B_name4;

    @FXML
    private Label B_name5;

    @FXML
    private Label B_name6;

    @FXML
    private Label B_name7;

    @FXML
    private Label B_name8;

    @FXML
    private Label Book_count;

    @FXML
    private Label Members_count;

    @FXML
    private Label Nane1;

    @FXML
    private Label Nane10;

    @FXML
    private Label Nane2;

    @FXML
    private Label Nane3;

    @FXML
    private Label Nane4;

    @FXML
    private Label Nane5;

    @FXML
    private Label Nane6;

    @FXML
    private Label Nane7;

    @FXML
    private Label Nane8;

    @FXML
    private Label Nane9;

    @FXML
    private Label Total;

    @FXML
    private Label U_ID1;

    @FXML
    private Label U_ID10;

    @FXML
    private Label U_ID2;

    @FXML
    private Label U_ID3;

    @FXML
    private Label U_ID4;

    @FXML
    private Label U_ID5;

    @FXML
    private Label U_ID6;

    @FXML
    private Label U_ID7;

    @FXML
    private Label U_ID8;

    @FXML
    private Label U_ID9;



    @FXML
    private VBox RankingUser;

    private List<Contact> contacts(){
        List<Contact> list = new ArrayList<>();
        Contact contact = new Contact();

        contact.setName("Ashen");
        contact.setU_ID("U001");
        list.add(contact);

        return list;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ArrayList<Label> U_IdArrays = new ArrayList<>();

        U_IdArrays.add(U_ID1);
        U_IdArrays.add(U_ID2);
        U_IdArrays.add(U_ID3);
        U_IdArrays.add(U_ID4);
        U_IdArrays.add(U_ID5);
        U_IdArrays.add(U_ID6);
        U_IdArrays.add(U_ID7);
        U_IdArrays.add(U_ID8);
        U_IdArrays.add(U_ID9);
        U_IdArrays.add(U_ID10);

        ArrayList<Label> UnameArrays = new ArrayList<>();

        UnameArrays.add(Nane1);
        UnameArrays.add(Nane2);
        UnameArrays.add(Nane3);
        UnameArrays.add(Nane4);
        UnameArrays.add(Nane5);
        UnameArrays.add(Nane6);
        UnameArrays.add(Nane7);
        UnameArrays.add(Nane8);
        UnameArrays.add(Nane9);
        UnameArrays.add(Nane10);

        ArrayList<Label> BookCount = new ArrayList<>();
        BookCount.add(B_name);
        BookCount.add(B_name1);
        BookCount.add(B_name2);
        BookCount.add(B_name3);
        BookCount.add(B_name4);
        BookCount.add(B_name5);
        BookCount.add(B_name6);
        BookCount.add(B_name7);
        BookCount.add(B_name8);



        String[][] UserandBook = DataBaseConnecter.getDetails("UserandBook",4);

        int[] getCount = new int[UserandBook.length];
        int[] bcount= new int[10];

        String[] name = new String[10];//users Count
        String[] book = new String[10];//book Count

        for (int i = 0; i < UserandBook.length; i++) {
            name[i] = "U00"+i;
            book[i] = "B00"+i;
        }

        User[] users = new User[10];//User Count
        User[] books = new User[10];//book count

        for (int i = 0; i < name.length; i++) {
            books[i] = new User();
            users[i] = new User();
            users[i].Name = name[i];
            books[i].Name = book[i];
            for (int j = 0; j < UserandBook.length; j++) {
                if (name[i].equals(UserandBook[j][0])) {
                    getCount[i]++;
                    bcount[i]++;
                }
            }
            users[i].Count = getCount[i];
            books[i].Count = bcount[i];
        }

        for (int i = 0; i <getCount.length; i++) {
            getCount[i] = users[i].Count;
            bcount[i] = books[i].Count;
        }

        getCount = MaxtoMin(getCount);
        bcount = MaxtoMin(bcount);
        users = remakeArrays(users,getCount);
        books = remakeArrays(books,bcount);

        for (int i = 0; i < users.length; i++) {
            U_IdArrays.get(i).setText(users[i].Name);
            UnameArrays.get(i).setText(""+users[i].Count);
        }

        for (int i = 0; i < 9; i++) {
            BookCount.get(i).setText(books[i].Name);
        }


        /*List<Contact> contacts = new ArrayList<>(contacts());
        for(int i=0; i<contacts.size(); i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/View/Contact/ContactItem.fxml"));

            try {
                HBox hBox = fxmlLoader.load();
                ContactItemConroller contactItemConroller = fxmlLoader.getController();
                contactItemConroller.setData(contacts.get(i));
                RankingUser.getChildren().add(hBox);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }*/
        Book_count.setText(book.length+"");
        Members_count.setText(""+name.length);
        Total.setText("1000");
    }
    public static int[] MaxtoMin(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no two elements were swapped in inner loop, the array is already sorted
            if (!swapped) {
                break;
            }
        }
        return arr;
    }

    public User[] remakeArrays(User[] users,int[] ints){

        User[] temp = new User[users.length];
        for (int i = 0; i < users.length; i++) {
            temp[i] = new User();
            for (int j = 0; j < users.length; j++) {
                if (ints[i] == users[j].Count){
                    temp[i].Name = users[j].Name;
                    temp[i].Count = users[j].Count;
                    break;
                }
            }
        }
        return temp;
    }
    @FXML
    void BooksbtnOnAtion(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(this.getClass().getResource("/View/BookManagementFrom.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) this.Pane.getScene().getWindow();
        stage.setTitle("Books Management");
        stage.setScene(scene);
    }
    @FXML
    void memberbtnOnAction(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(this.getClass().getResource("/View/MembersManagementForm.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) this.Pane.getScene().getWindow();
        stage.setTitle("Books Management");
        stage.setScene(scene);
    }
}
