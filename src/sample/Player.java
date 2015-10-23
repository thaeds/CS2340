package sample;

import javafx.scene.paint.Color;
import Map.*;
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
public class Player implements Comparable {

    String name;
    String race;
    Color color;

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getOre() {
        return ore;
    }

    public void setOre(int ore) {
        this.ore = ore;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    int food = 8;
    int ore = 0;
    int energy = 4;

    public boolean isLowest() {
        return isLowest;
    }

    public void setIsLowest(boolean isLowest) {
        this.isLowest = isLowest;
    }

    boolean isLowest = false;

    public Mule getMule() {
        return mule;
    }

    public void setMule(Mule m) {
        this.mule = m;
    }

    Mule mule;
    int currentEnergy = 0;

    public int getCurrentEnergy() {
        return currentEnergy;
    }

    public void setCurrentEnergy(int currentEnergy) {
        this.currentEnergy = currentEnergy;
    }

    ArrayList<Tile> tiles = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void addTile(Tile t) {
        tiles.add(t);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    int balance;

    public ArrayList<Tile> getTiles() {
        return tiles;
    }

    public int getNumberOfTiles() {
        return tiles.size();
    }

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

    public Player(String name, String race, Color color) {
        this.name = name;
        this.race = race;
        this.color = color;
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
}
