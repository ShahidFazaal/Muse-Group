package controller;

import javafx.animation.KeyFrame;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class WelcomeScreen {
    public ImageView imgMuse;
    public ImageView imgAltaiab;
    public Label lblCompanyName;
    public TilePane tpAltaiab;
    public TilePane tpMuse;
    public Label lblTime;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");



    public void initialize() {
        // Create a Timeline to update the time every second
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), event -> {
                    // Get the current time and update the label
                    LocalTime currentTime = LocalTime.now();
                    lblTime.setText(currentTime.format(formatter));
                })
        );

        timeline.setCycleCount(Timeline.INDEFINITE); // Repeat indefinitely
        timeline.play(); // Start the timeline

    }

    public void mouseEnteredAnimation(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) mouseEvent.getSource();

            switch (icon.getId()) {
                case "imgAltaiab":
                    lblCompanyName.setText("ALTAIAB ALASLI RESTAURANT & KITCHEN");
                    break;
                case "imgMuse":
                    lblCompanyName.setText("THE MUSE UAE BOUTIQUE SPA");
                    break;
            }

            ScaleTransition scaleT =new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1.2);
            scaleT.setToY(1.2);
            scaleT.play();

            DropShadow glow = new DropShadow();
            glow.setColor(Color.CORNFLOWERBLUE);
            glow.setWidth(20);
            glow.setHeight(20);
            glow.setRadius(20);
            icon.setEffect(glow);
        }
    }

    public void mouseExitAnimation(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) mouseEvent.getSource();
            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1);
            scaleT.setToY(1);
            scaleT.play();

            icon.setEffect(null);
            lblCompanyName.setText("مرحبًا بكم في مجموعة ميوز");
        }
    }

    public void onMouseClick(MouseEvent mouseEvent) {
        Platform.exit();
    }

    public void navigateToUserCredential(MouseEvent mouseEvent) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/MuseGroupDashboard.fxml"));
        Scene mainScene = new Scene(root);
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Muse Group");
        primaryStage.resizableProperty().setValue(true);
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        primaryStage.setMaximized(true);
//        primaryStage.setWidth(screenBounds.getWidth());
//        primaryStage.setHeight(screenBounds.getHeight());
////        primaryStage.setWidth(1200);
////        primaryStage.setHeight(800);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        Image icon = new Image(getClass().getResourceAsStream("/resource/logo.png"));
        primaryStage.getIcons().add(icon);
        primaryStage.show();
    }
}
