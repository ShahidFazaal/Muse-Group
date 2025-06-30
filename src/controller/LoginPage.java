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
import javafx.scene.layout.HBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import util.DBConnection;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginPage {

    public TextField txtPassword;
    public TextField txtUserName;
    public Button btnLogin;
    public HBox log;

    public void btnLogin_OnMouseClick(MouseEvent mouseEvent) throws IOException, SQLException {
        String userName = txtUserName.getText();
        String password = txtPassword.getText();
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement("select * from users");
        ResultSet resultSet = preparedStatement.executeQuery();
        Parent homeRoot = FXMLLoader.load(this.getClass().getResource("/view/MuseGroupDashboard.fxml"));
        if (resultSet.next()){
            String un = resultSet.getString(3);
            String pw = resultSet.getString(4);
            if (userName.equals(un) && password.equals(pw)){
                Stage stage = new Stage();
                Scene scene = new Scene(homeRoot);
                stage.setScene(scene);
                stage.show();
                log.getScene().getWindow().hide();




//                Parent homeRoot = FXMLLoader.load(getClass().getResource("Home.fxml"));
//                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//                stage.setScene(new Scene(homeRoot));
//                stage.setTitle("Home");
//                stage.show();
            }else {
                new Alert(Alert.AlertType.ERROR, "Incorrect Password").show();
            }





    }else {
            new Alert(Alert.AlertType.ERROR,"The username or password is incorrect", ButtonType.OK).show();
        }
    }
}
