package Town;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

/**
 * Created by Alex on 9/24/15.
 */
public class Building extends ImageView {
    public Building(String filename) {
        this.setImage(new Image(getClass().getResource(filename).toExternalForm()));
    }
}
