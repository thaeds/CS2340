package Map;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by Sergey on 9/24/15.
 */

/**
 * Constructor for Mountain Tile
 *
 * @param Tile identifier string
 */
public class Mountain extends Tile {
    public Mountain(String i) {
        super(i);
        this.setEnergyPoints(1);
        this.setFoodPoints(1);
        this.setOrePoints(2);
        this.setOwner(null);
        this.setIsOwned(false);
        this.setCost(100);
        this.setImage(new Image(getClass().getResource("mountain.png").toExternalForm()));
    }
}
