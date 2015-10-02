package Pub;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by Sergey on 10/2/15.
 */
public class Pub {
    @FXML
    private ImageView v = new ImageView();
    @FXML
    public void initialize() {
        v.setImage(new Image(getClass().getResource("Pub/pubinside.jpg").toExternalForm()));
    }
}
