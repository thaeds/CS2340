package Map;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by Sergey on 9/24/15.
 * @author Sergey
 * @version 1.0
 * Mountain that extends tile and has its mountain value of Energy/Ore/Food
 * It also has image of mountain.png
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
