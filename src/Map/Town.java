package Map;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import sample.*;
/**
 * Created by Sergey on 9/24/15.
 */


/**
 * Constructor for Town Tile
 *
 * @param Tile identifier string
 */
public class Town extends Tile {
    public Town(String i) {
        super(i);
        this.setIsOwned(false);
        this.setOwner(new Player("GAME","GAME", Color.LIGHTGREEN));
        this.setCost(Integer.MAX_VALUE);
        this.setImage(new Image(getClass().getResource("town.png").toExternalForm()));
    }
    @Override
    public void setOwner(Player p) {}
}
