package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FrontPageController {

    @FXML
    TextField userNameInput;
    @FXML
    TextField crushNameInput;
    @FXML
    Button submitButton;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchResultPage(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("result-page.fxml"));
        root = loader.load();

        ResultPageController resultPageController = loader.getController();
        resultPageController.getRelationship(FlamesCandle.runFlames(userNameInput.getText(), crushNameInput.getText()));

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
