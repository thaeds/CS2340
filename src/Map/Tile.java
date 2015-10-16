package Map;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.*;

/**
 * Created by Sergey on 9/24/15.
 */
public class Tile extends ImageView {
    private boolean isOwned;
    private int cost;
    private int FoodPoints;
    private int EnergyPoints;
    private int OrePoints;
    private boolean hasMule;
    private Player owner;

    public boolean isOwned() {
        return isOwned;
    }

    public Tile() {
        this.setEnergyPoints(2);
        this.setFoodPoints(3);
        this.setOrePoints(1);
        this.setCost(100);
        isOwned = false;
        hasMule = false;
        owner = null;
        this.setImage(new Image(getClass().getResource("plain.png").toExternalForm()));
    }

    public int getScore() {
        return EnergyPoints + FoodPoints + OrePoints;
    }

    public void setIsOwned(boolean isOwned) {

        this.isOwned = isOwned;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getFoodPoints() {
        return FoodPoints;
    }

    public void setFoodPoints(int foodPoints) {
        FoodPoints = foodPoints;
    }

    public int getEnergyPoints() {
        return EnergyPoints;
    }

    public void setEnergyPoints(int energyPoints) {
        EnergyPoints = energyPoints;
    }

    public int getOrePoints() {
        return OrePoints;
    }

    public void setOrePoints(int orePoints) {
        OrePoints = orePoints;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        owner = owner;
    }
    public boolean hasMule() {
        return hasMule;
    }
    public void setMule(boolean b) {
        hasMule = b;
    }
}
