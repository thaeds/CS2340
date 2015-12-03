package sample;

import javafx.scene.paint.Color;
import Map.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 * M.U.L.E. 2340 Project
 *
 * This is the class for the player objects in the game;
 *
 *
 * @author Joseph Hooper
 * @version 1.0.0
 */
public class Player implements Comparable, Serializable {

    String name;
    String race;
    String stringColor;
    double red;
    double green;
    double blue;
    double opacity;
    transient Color color;

    /**
     * Gets player food
     *
     * @return the amount of food player has
     */
    public int getFood() {
        return food;
    }

    /**
     * Gets player color
     *
     * @return the player color as a string
     */
    public String getStringColor() {
        return stringColor;
    }

    /**
     * Gets player green value
     *
     * @return green value
     */
    public double getGreen() {
        return green;
    }

    /**
     * Gets player red value
     *
     * @return red value
     */
    public double getRed() {
        return red;
    }

    /**
     * Gets player blue value
     *
     * @return blue value
     */
    public double getBlue() {
        return blue;
    }

    /**
     * Gets player opcaity value
     *
     * @return opacity value
     */
    public double getOpacity() {
        return opacity;
    }

    /**
     * Sets player food
     *
     * @param food food being set
     */
    public void setFood(int food) {
        this.food = food;
    }

    /**
     * Gets player ore amount
     *
     * @return ore value
     */
    public int getOre() {
        return ore;
    }

    /**
     * Sets player ore
     *
     * @param ore energy being set
     */
    public void setOre(int ore) {
        this.ore = ore;
    }

    /**
     * Gets player energy amount
     *
     * @return energy value
     */
    public int getEnergy() {
        return energy;
    }

    /**
     * Sets player energy
     *
     * @param energy energy being set
     */
    public void setEnergy(int energy) {
        this.energy = energy;
    }

        int food = 8;
    int ore = 0;
    int energy = 4;

    /**
     * Checks if player is lowest among players
     *
     * @return  boolean stating if player is lowest or not
     */
    public boolean isLowest() {
        return isLowest;
    }

    /**
     * Sets player if player is lowest among players
     *
     * @param isLowest boolean stating if player is lowest or not
     */
    public void setIsLowest(boolean isLowest) {
        this.isLowest = isLowest;
    }

    boolean isLowest = false;

    /**
     * Gets player mule
     *
     * @return player mule
     */
    public Mule getMule() {
        return mule;
    }

    /**
     * Sets player mule
     *
     * @param m mule being set
     */
    public void setMule(Mule m) {
        this.mule = m;
    }

    Mule mule;
    int currentEnergy = 0;

    /**
     * Gets player energy amount
     *
     * @return energy value
     */
    public int getCurrentEnergy() {
        return currentEnergy;
    }

    /**
     * Sets player current energy
     *
     * @param currentEnergy current energy being set
     */
    public void setCurrentEnergy(int currentEnergy) {
        this.currentEnergy = currentEnergy;
    }

    ArrayList<Tile> tiles = new ArrayList<>();

    /**
     * Gets player name
     *
     * @return player name
     */
    public String getName() {
        return name;
    }

    /**
     * Adds  tile to list of owned by player
     *
     * @param t tile being added
     */
    public void addTile(Tile t) {
        tiles.add(t);
    }

    /**
     * Sets player name
     *
     * @param name  name being set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets player race
     *
     * @return player race
     */
    public String getRace() {
        return race;
    }

    /**
     * Sets player race
     *
     * @param race race being set
     */
    public void setRace(String race) {
        this.race = race;
    }

    /**
     * Gets player color value
     *
     * @return color value
     */
    public Color getColor() {
        return color;
    }

    /**
     * Sets player color
     *
     * @param color  color being set
     */
    public void setColor(Color color) {
        this.color = color;
        this.stringColor = color.toString();
        System.out.println("COLOR : " + stringColor);
    }

    /**
     * Gets player money balance
     *
     * @return player energy balance
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Sets player money
     *
     * @param balance  money being set
     */
    public void setBalance(int balance) {
        this.balance = balance;
    }

    int balance;

    /**
     * Gets player tiles
     *
     * @return list of tiles owned by players
     */
    public ArrayList<Tile> getTiles() {
        return tiles;
    }

    /**
     * Gets number of tiles players have
     *
     * @return number of tiles players have
     */
    public int getNumberOfTiles() {
        return tiles.size();
    }

    /**
     * Gets player score
     *
     * @return player score
     */
    public int getScore() {
        if (getNumberOfTiles() == 0) {
            return 0;
        } else {
            int i = 0;
            for (Tile t : tiles) {
                i = i + t.getScore();
            }
            return i;
        }
    }

    /**
     * Player constructor
     */
    public Player(String name, String race, Color color) {
        this.name = name;
        this.race = race;
        this.color = color;
        this.red = color.getRed();
        this.blue = color.getBlue();
        this.green = color.getGreen();
        this.opacity = color.getOpacity();
        this.balance = 10000;
    }

    @Override
    public String toString() {
        return "Name: " + name + "Balance: " + balance + "\n| Race: " + race;
    }

    @Override
    public int compareTo(Object o) {
        Player p = (Player) o;
        return p.getScore() - this.getScore();
    }

    /**
     * Produces resources from tiles with mules
     */
    public void production() {
        for (Tile t : tiles) {
            if(t.hasMule()) {
                if (t.getMule().getClass() == Map.OreMule.class) {
                    if (t.getClass() != Map.Mountain.class) continue;
                    if (this.getEnergy() < 1) continue;
                    this.setFood(this.getFood() + 1);
                    this.setOre(this.getOre() + 2);
                } else if (t.getMule().getClass() == Map.FoodMule.class) {
                    if (t.getClass() != Map.River.class) continue;
                    if (this.getEnergy() < 1) continue;
                    this.setFood(this.getFood() + 4);
                    this.setEnergy(this.getOre() + 1);
                } else if (t.getMule().getClass() == Map.EnergyMule.class) {
                    if (t.getClass() != Map.Tile.class) continue;
                    if (this.getEnergy() < 1) continue;
                    this.setFood(this.getFood() + 2);
                    this.setEnergy(this.getEnergy() + 2);
                    this.setEnergy(this.getOre() + 1);
                }
            }
        }
        System.out.println("Your resources were set to:");
        System.out.println("Food: " + this.getFood());
        System.out.println("Energy: " + this.getEnergy());
        System.out.println("Ore: " + this.getOre());
    }
    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Player)) {
            return false;
        } else {
            Player play = (Player) o;
            if (this.name.equals(play.getName())) {
                if (this.race.equals(play.getRace())) {
                    if (this.color.equals(play.getColor())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
