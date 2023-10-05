package lk.ijse;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class Launcher extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) throws Exception{
        Parent parent = FXMLLoader.load(this.getClass().getResource("/View/LoginPage.fxml"));
        Scene scene = new Scene(parent);
        stage.setTitle("Login Page");
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
    }
}