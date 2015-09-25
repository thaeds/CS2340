package Map;

import javafx.scene.image.ImageView;

/**
 * Created by Sergey on 9/24/15.
 */
public class River extends Tile {
    public River() {
        this.setIsOwned(false);
        this.setOwner(null);
        this.setEnergyPoints(2);
        this.setFoodPoints(4);
        this.setOrePoints(0);
        representation = new ImageView(getClass().getResource("river.png").toExternalForm());
    }
}
