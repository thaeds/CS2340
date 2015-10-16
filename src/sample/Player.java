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
        if(getNumberOfTiles() == 0) {
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
        this.balance = 300;
        }
    @Override
    public String toString() {
        return "Name: " + name + "Balance: " + balance + "\n| Race: " + race;
    }
    @Override
    public int compareTo(Object o) {
        Player p = (Player) o;
        return this.getScore() - p.getScore();
    }
    public int calculateProduction() {
        int prod = 0;
        for(Tile t : tiles) {
            if (t.hasMule() && t.getEnergyPoints() > 0) {
                prod += t.getOrePoints();
            }
        }
        return prod;
    }
}
