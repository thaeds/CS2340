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

    /**
     * Constructor for standard Tile
     *
     * @param Tile identifier string
     */
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

    /**
     * Getter for string indentifier
     *
     * @return indentifier of tile
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * Getter for score of tile
     *
     * @return score of tile
     */
    public int getScore() {
        return EnergyPoints + FoodPoints + OrePoints;
    }

    /**
     * Determines if tile is owned or not
     *
     * @return boolean stating if tile is owned
     */
    public void setIsOwned(boolean isOwned) {

        this.isOwned = isOwned;
    }

    /**
     * Getter for cost of tile
     *
     * @return cost of tile
     */
    public int getCost() {
        return cost;
    }

    /**
     * Setter for cost of tile
     *
     * @param cost the cost of tile
     */
    public void setCost(int cost) {
        this.cost = cost;
    }

    /**
     * Getter for food points
     *
     * @return food points
     */
    public int getFoodPoints() {
        return FoodPoints;
    }

    /**
     * Setter for food points of tile
     *
     * @param foodPoints the food points associated with tile
     */
    public void setFoodPoints(int foodPoints) {
        FoodPoints = foodPoints;
    }

    /**
     * Getter for energy points
     *
     * @return energy points
     */
    public int getEnergyPoints() {
        return EnergyPoints;
    }

    /**
     * Setter for energy points of tile
     *
     * @param energyPoints the energy points associated with tile
     */
    public void setEnergyPoints(int energyPoints) {
        EnergyPoints = energyPoints;
    }

    /**
     * Getter for ore points
     *
     * @return ore points
     */
    public int getOrePoints() {
        return OrePoints;
    }

    /**
     * Setter for ore points of tile
     *
     * @param orePoints the ore points associated with tile
     */
    public void setOrePoints(int orePoints) {
        OrePoints = orePoints;
    }

    /**
     * Getter for owner of tile
     *
     * @return player that owns tiles
     */
    public Player getOwner() {
        return owner;
    }

    /**
     * Sets the owner of the tile
     *
     * @param owner the Player being set
     */
    public void setOwner(Player owner) {
        if(owner != null) {
            this.owner = owner;
        }
        System.out.println("This tile's owner" + this.owner);
    }

    /**
     * Checks is tile has mule
     *
     * @return boolean stating if tile has mule or not
     */
    public boolean hasMule() {
        return mule != null;
    }

    /**
     * Getter for Mule of tile
     *
     * @return Mule associated with tile
     */
    public Mule getMule() {
        return mule;
    }

    /**
     * Sets the mule of the tile
     *
     * @param mule the mule being set
     */
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
