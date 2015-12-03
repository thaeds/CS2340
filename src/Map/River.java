package Map;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by Sergey on 9/24/15.
 */

/**
 * Constructor for River Tile
 *
 * @param Tile identifier string
 */
public class River extends Tile {
    public River(String i) {
        super(i);
        this.setIsOwned(false);
        this.setOwner(null);
        this.setEnergyPoints(2);
        this.setFoodPoints(4);
        this.setOrePoints(0);
        this.setCost(100);
        this.setImage(new Image(getClass().getResource("river.png").toExternalForm()));
    }
}
