package Map;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import sample.*;
/**
 * Created by Sergey on 9/24/15.
 */
public class Town extends Tile {
    public Town() {
        this.setIsOwned(false);
        this.setOwner(new Player("GAME","GAME", Color.LIGHTGREEN));
        this.setCost(Integer.MAX_VALUE);
        this.setImage(new Image(getClass().getResource("town.png").toExternalForm()));
    }
    @Override
    public void setOwner(Player p) {}
}
