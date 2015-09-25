package Map;

import javafx.scene.image.ImageView;
import sample.*;

/**
 * Created by Sergey on 9/24/15.
 */
public class Tile {
    private boolean isOwned;
    private int cost;
    private int FoodPoints;
    private int EnergyPoints;
    private int OrePoints;
    private Player owner;
    public ImageView representation;

    public boolean isOwned() {
        return isOwned;
    }

    public Tile() {
        this.setEnergyPoints(2);
        this.setFoodPoints(3);
        this.setOrePoints(1);
        isOwned = false;
        owner = null;
        representation = new ImageView(getClass().getResource("plain.png").toExternalForm());
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
}
