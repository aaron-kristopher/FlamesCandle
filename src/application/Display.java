package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Display extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        try {

            Parent root = FXMLLoader
                    .load(getClass().getResource("front-page.fxml"));
            Scene scene = new Scene(root);

            Image icon = new Image("resources/FlamesCandleLogo.png");

            stage.setResizable(false);
            stage.setTitle("FLAMES");
            stage.getIcons().add(icon);
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
