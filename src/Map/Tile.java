package Map;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.*;

import java.io.Serializable;

/**
 * Created by Sergey on 9/24/15.
 */
public class Tile extends ImageView implements Serializable{
    private boolean isOwned;
    private int cost;
    private int FoodPoints;
    private int EnergyPoints;
    private int OrePoints;
    private Player owner;
    private Mule mule;
    private String identifier;
    public boolean isOwned() {
        return isOwned;
    }

    public Tile(String i) {
        this.identifier = i;
        this.setEnergyPoints(2);
        this.setFoodPoints(3);
        this.setOrePoints(1);
        this.setCost(100);
        isOwned = false;
        owner = null;
        this.setImage(new Image(getClass().getResource("plain.png").toExternalForm()));
    }
    public String getIdentifier() {
        return identifier;
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
        return mule != null;
    }

    public Mule getMule() {
        return mule;
    }

    public void setMule(Mule mule) {
        this.mule = mule;
    }
    @Override
    public String toString() {
        return identifier;
    }
    @Override
    public boolean equals(Object o) {
        return this.identifier.equals(((Tile) o).getIdentifier());
    }
    @Override
    public int hashCode() {
        return identifier.hashCode();
    }
}
