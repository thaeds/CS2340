package Map;

import javafx.scene.image.ImageView;
import sample.*;
/**
 * Created by Sergey on 9/24/15.
 */
public class Town extends Tile {
    public Town() {
        this.setIsOwned(false);
        representation = new ImageView(getClass().getResource("town.png").toExternalForm());
    }
    @Override
    public void setOwner(Player p) {}
}
