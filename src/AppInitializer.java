import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.geometry.Rectangle2D;

import java.io.IOException;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent root = FXMLLoader.load(this.getClass().getResource("/view/loginPage.fxml"));
        Scene mainScene = new Scene(root);
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Muse Group");
        primaryStage.resizableProperty().setValue(false);
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        //primaryStage.setWidth(screenBounds.getWidth());
        //primaryStage.setHeight(screenBounds.getHeight());
        primaryStage.setWidth(600);
        primaryStage.setHeight(400);
        //Image icon = new Image(getClass().getResourceAsStream("/resource/logo.png"));
        //primaryStage.getIcons().add(icon);
        primaryStage.show();

    }
}
