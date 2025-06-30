package controller;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginPage {

    public TextField txtPassword;
    public TextField txtUserName;
    public Button btnLogin;

    public void btnLogin_OnMouseClick(MouseEvent mouseEvent) throws IOException {
        String userName = txtUserName.getText();
        String password = txtPassword.getText();

        if(userName.equals("Ahmed") && password.equals("123")){

            Stage stage = new Stage();
            Parent root = FXMLLoader.load(this.getClass().getResource("/view/welcomeScreen.fxml"));
            Scene mainScene = new Scene(root);
            stage.setScene(mainScene);
            stage.setTitle("Muse Group");
            stage.resizableProperty().setValue(false);
            Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
            //primaryStage.setWidth(screenBounds.getWidth());
            //primaryStage.setHeight(screenBounds.getHeight());
            stage.show();


        }else {
            new Alert(Alert.AlertType.ERROR,"The username or password is incorrect", ButtonType.OK).show();
        }
    }
}
