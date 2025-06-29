import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.geometry.Rectangle2D;
import javafx.stage.StageStyle;

import java.io.IOException;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/welcomeScreen.fxml"));
        Scene mainScene = new Scene(root);
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Muse Group");
        primaryStage.resizableProperty().setValue(true);
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();

//        primaryStage.setWidth(screenBounds.getWidth());
//        primaryStage.setHeight(screenBounds.getHeight());
////        primaryStage.setWidth(1200);
////        primaryStage.setHeight(800);

        Image icon = new Image(getClass().getResourceAsStream("/resource/logo.png"));
        primaryStage.getIcons().add(icon);
        primaryStage.show();
    }
}
