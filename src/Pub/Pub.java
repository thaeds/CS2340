package Pub;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import sample.Context;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;

/**
 * Created by Sergey on 10/2/15.
 */
public class Pub {
    @FXML
    private Pane pubWindow;
    @FXML
    private ImageView v = new ImageView();
    @FXML
    private Button exitPub;
    @FXML
    public void initialize() {
    }
    @FXML
    private void exitPub() {
        System.out.println("clicked on exit pub");
        Context.loadMap();
        Stage curStage = (Stage)pubWindow.getScene().getWindow();
        curStage.close();
    }
}
