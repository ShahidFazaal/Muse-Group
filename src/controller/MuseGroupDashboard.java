package controller;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MuseGroupDashboard {

    public Button btnSettings;
    public Button btnEmployees;
    public Button btnPayroll;
    public Button btnLeave;
    public Button btnTraining;
    public Button btnJobs;
    public Button btnVisa;
    public Button btnLogs;
    public Button btnMinimize;
    public Button btnExit;
    public StackPane MuseGroupDashboard;
    public AnchorPane apEmployees;
    public AnchorPane apSetting;
    public Button btnNewEmployee;
    public TableView tbleEmployees;
    public ComboBox cmbLetterType;
    public ComboBox cmbResidency;
    public Button btnSearch;
    public TextField txtEmployeeID;


    public void initialize(){
        ObservableList customers = cmbResidency.getItems();
        customers.add("Visit Visa");
        customers.add("Residency Visa");
        customers.add("No Visa");
        customers.add("Processing");

        ObservableList LetterType = cmbLetterType.getItems();
        LetterType.add("Warning Letter");
        LetterType.add("Termination Letter");
        LetterType.add("Offer Letter");

    }

    public void SwithForm(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btnSettings ){
            if (!btnSettings.getStyleClass().contains("clicked")) {
                btnSettings.getStyleClass().add("clicked"); // Add clicked state
                apSetting.setVisible(true);
                apEmployees.setVisible(false);
                btnEmployees.getStyleClass().remove("clicked");
                btnPayroll.getStyleClass().remove("clicked");
                btnLeave.getStyleClass().remove("clicked");
                btnTraining.getStyleClass().remove("clicked");
                btnJobs.getStyleClass().remove("clicked");
                btnVisa.getStyleClass().remove("clicked");
                btnLogs.getStyleClass().remove("clicked");
            }
            /*btnSettings.setStyle("-fx-background-color: linear-gradient(to bottom right, grey,black);");
            btnEmployees.setStyle("-fx-background-color: transparent");
            btnPayroll.setStyle("-fx-background-color: transparent");
            btnLeave.setStyle("-fx-background-color: transparent");
            btnTraining.setStyle("-fx-background-color: transparent");
            btnJobs.setStyle("-fx-background-color: transparent");
            btnVisa.setStyle("-fx-background-color: transparent");
            btnLogs.setStyle("-fx-background-color: transparent");*/

        }else if (actionEvent.getSource() == btnEmployees){
            if (!btnEmployees.getStyleClass().contains("clicked")) {
                btnEmployees.getStyleClass().add("clicked"); // Add clicked state
                apSetting.setVisible(false);
                apEmployees.setVisible(true);
                btnSettings.getStyleClass().remove("clicked");
                btnPayroll.getStyleClass().remove("clicked");
                btnLeave.getStyleClass().remove("clicked");
                btnTraining.getStyleClass().remove("clicked");
                btnJobs.getStyleClass().remove("clicked");
                btnVisa.getStyleClass().remove("clicked");
                btnLogs.getStyleClass().remove("clicked");
            }
            /*btnEmployees.setStyle("-fx-background-color: linear-gradient(to bottom right, grey,black);");
            btnSettings.setStyle("-fx-background-color: transparent");
            btnPayroll.setStyle("-fx-background-color: transparent");
            btnLeave.setStyle("-fx-background-color: transparent");
            btnTraining.setStyle("-fx-background-color: transparent");
            btnJobs.setStyle("-fx-background-color: transparent");
            btnVisa.setStyle("-fx-background-color: transparent");
            btnLogs.setStyle("-fx-background-color: transparent");*/

        }else if (actionEvent.getSource() == btnPayroll){
            if (!btnPayroll.getStyleClass().contains("clicked")) {
                btnPayroll.getStyleClass().add("clicked"); // Add clicked state
                btnSettings.getStyleClass().remove("clicked");
                btnEmployees.getStyleClass().remove("clicked");
                btnLeave.getStyleClass().remove("clicked");
                btnTraining.getStyleClass().remove("clicked");
                btnJobs.getStyleClass().remove("clicked");
                btnVisa.getStyleClass().remove("clicked");
                btnLogs.getStyleClass().remove("clicked");
            }
          /*  btnPayroll.setStyle("-fx-background-color: linear-gradient(to bottom right, grey,black);");
            btnEmployees.setStyle("-fx-background-color: transparent");
            btnSettings.setStyle("-fx-background-color: transparent");
            btnLeave.setStyle("-fx-background-color: transparent");
            btnTraining.setStyle("-fx-background-color: transparent");
            btnJobs.setStyle("-fx-background-color: transparent");
            btnVisa.setStyle("-fx-background-color: transparent");
            btnLogs.setStyle("-fx-background-color: transparent");*/

        }else if (actionEvent.getSource() == btnLeave){
            if (!btnLeave.getStyleClass().contains("clicked")) {
                btnLeave.getStyleClass().add("clicked"); // Add clicked state
                btnSettings.getStyleClass().remove("clicked");
                btnEmployees.getStyleClass().remove("clicked");
                btnPayroll.getStyleClass().remove("clicked");
                btnTraining.getStyleClass().remove("clicked");
                btnJobs.getStyleClass().remove("clicked");
                btnVisa.getStyleClass().remove("clicked");
                btnLogs.getStyleClass().remove("clicked");
            }
           /* btnLeave.setStyle("-fx-background-color: linear-gradient(to bottom right, grey,black);");
            btnEmployees.setStyle("-fx-background-color: transparent");
            btnSettings.setStyle("-fx-background-color: transparent");
            btnPayroll.setStyle("-fx-background-color: transparent");
            btnTraining.setStyle("-fx-background-color: transparent");
            btnJobs.setStyle("-fx-background-color: transparent");
            btnVisa.setStyle("-fx-background-color: transparent");
            btnLogs.setStyle("-fx-background-color: transparent");*/

        }else if (actionEvent.getSource() == btnTraining){
            if (!btnTraining.getStyleClass().contains("clicked")) {
                btnTraining.getStyleClass().add("clicked"); // Add clicked state
                btnSettings.getStyleClass().remove("clicked");
                btnEmployees.getStyleClass().remove("clicked");
                btnPayroll.getStyleClass().remove("clicked");
                btnLeave.getStyleClass().remove("clicked");
                btnJobs.getStyleClass().remove("clicked");
                btnVisa.getStyleClass().remove("clicked");
                btnLogs.getStyleClass().remove("clicked");
            }
           /* btnTraining.setStyle("-fx-background-color: linear-gradient(to bottom right, grey,black);");
            btnEmployees.setStyle("-fx-background-color: transparent");
            btnSettings.setStyle("-fx-background-color: transparent");
            btnPayroll.setStyle("-fx-background-color: transparent");
            btnLeave.setStyle("-fx-background-color: transparent");
            btnJobs.setStyle("-fx-background-color: transparent");
            btnVisa.setStyle("-fx-background-color: transparent");
            btnLogs.setStyle("-fx-background-color: transparent");*/

        }else if (actionEvent.getSource() == btnJobs){
            if (!btnJobs.getStyleClass().contains("clicked")) {
                btnJobs.getStyleClass().add("clicked"); // Add clicked state
                btnSettings.getStyleClass().remove("clicked");
                btnEmployees.getStyleClass().remove("clicked");
                btnPayroll.getStyleClass().remove("clicked");
                btnLeave.getStyleClass().remove("clicked");
                btnTraining.getStyleClass().remove("clicked");
                btnVisa.getStyleClass().remove("clicked");
                btnLogs.getStyleClass().remove("clicked");
            }
            /*btnJobs.setStyle("-fx-background-color: linear-gradient(to bottom right, grey,black);");
            btnEmployees.setStyle("-fx-background-color: transparent");
            btnSettings.setStyle("-fx-background-color: transparent");
            btnPayroll.setStyle("-fx-background-color: transparent");
            btnLeave.setStyle("-fx-background-color: transparent");
            btnTraining.setStyle("-fx-background-color: transparent");
            btnVisa.setStyle("-fx-background-color: transparent");
            btnLogs.setStyle("-fx-background-color: transparent");*/

        }else if (actionEvent.getSource() == btnVisa){
            if (!btnVisa.getStyleClass().contains("clicked")) {
                btnVisa.getStyleClass().add("clicked"); // Add clicked state
                btnSettings.getStyleClass().remove("clicked");
                btnEmployees.getStyleClass().remove("clicked");
                btnPayroll.getStyleClass().remove("clicked");
                btnLeave.getStyleClass().remove("clicked");
                btnTraining.getStyleClass().remove("clicked");
                btnJobs.getStyleClass().remove("clicked");
                btnLogs.getStyleClass().remove("clicked");
            }
           /* btnVisa.setStyle("-fx-background-color: linear-gradient(to bottom right, grey,black);");
            btnEmployees.setStyle("-fx-background-color: transparent");
            btnSettings.setStyle("-fx-background-color: transparent");
            btnPayroll.setStyle("-fx-background-color: transparent");
            btnLeave.setStyle("-fx-background-color: transparent");
            btnTraining.setStyle("-fx-background-color: transparent");
            btnJobs.setStyle("-fx-background-color: transparent");
            btnLogs.setStyle("-fx-background-color: transparent");*/

        }else if (actionEvent.getSource() == btnLogs){
            if (!btnLogs.getStyleClass().contains("clicked")) {
                btnLogs.getStyleClass().add("clicked"); // Add clicked state
                btnSettings.getStyleClass().remove("clicked");
                btnEmployees.getStyleClass().remove("clicked");
                btnPayroll.getStyleClass().remove("clicked");
                btnLeave.getStyleClass().remove("clicked");
                btnTraining.getStyleClass().remove("clicked");
                btnJobs.getStyleClass().remove("clicked");
                btnVisa.getStyleClass().remove("clicked");
            }
            /*btnLogs.setStyle("-fx-background-color: linear-gradient(to bottom right, grey,black);");
            btnEmployees.setStyle("-fx-background-color: transparent");
            btnSettings.setStyle("-fx-background-color: transparent");
            btnPayroll.setStyle("-fx-background-color: transparent");
            btnLeave.setStyle("-fx-background-color: transparent");
            btnTraining.setStyle("-fx-background-color: transparent");
            btnJobs.setStyle("-fx-background-color: transparent");
            btnVisa.setStyle("-fx-background-color: transparent");*/

        }

    }

    public void leftPanel_OnMouseEntered(MouseEvent mouseEvent) {
        if(mouseEvent.equals(true)){

        }
    }

    public void leftPanel_OnMouseExit(MouseEvent mouseEvent) {
    }

    public void btnMinimizeAndClose_OnAction(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btnExit){
            Stage primaryStage = (Stage) this.MuseGroupDashboard.getScene().getWindow();
            FadeTransition fadeOut = new FadeTransition(Duration.seconds(0.2), primaryStage.getScene().getRoot());
            fadeOut.setFromValue(1.0);
            fadeOut.setToValue(0.0);
            fadeOut.setOnFinished(e -> primaryStage.close());
            fadeOut.play();
        }else {
            Stage primaryStage = (Stage) this.MuseGroupDashboard.getScene().getWindow();
            primaryStage.iconifiedProperty().addListener((observable, wasIconified, isNowIconified) -> {
                if (!isNowIconified) {
                    // Window has been restored, apply fade-in effect
                    FadeTransition fadeIn = new FadeTransition(Duration.seconds(0.5), primaryStage.getScene().getRoot());
                    fadeIn.setFromValue(0.0);
                    fadeIn.setToValue(1.0);
                    fadeIn.play();
                }
            });
            primaryStage.setIconified(true);
        }
    }

    public void btnNewEmployee_OnMouseClick(MouseEvent mouseEvent) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/addEmployees.fxml"));
        Scene mainScene = new Scene(root);
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Muse Group");
        primaryStage.resizableProperty().setValue(true);
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        Image icon = new Image(getClass().getResourceAsStream("/resource/logo.png"));
        primaryStage.getIcons().add(icon);
        primaryStage.show();

    }
}
