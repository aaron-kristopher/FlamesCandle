package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ResultPageController {

    private Stage stage;
    private Scene scene;
    private Parent root;
    private String relationship;

    @FXML
    Button tryAgainButton;
    @FXML
    Button revealRelationship;

    public void showRelationship() {
        revealRelationship.setText(relationship);
    }

    public void getRelationship(String status) {
        relationship = status;
    }

    public void tryAgain(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("front-page.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
