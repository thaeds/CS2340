package Map;

import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;

/**
 * Created by Sergey on 9/24/15.
 * @author Sergey
 * @version 1.0
 * River that extends Tile and has its river vaule of Energy/Ore/Food
 * It also has image of river.png
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
