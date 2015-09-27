package sample;

import javafx.scene.paint.Color;
import Map.*;
import java.util.ArrayList;

/**
 * M.U.L.E. 2340 Project
 *
 * This is the class for the player objects in the game;
 *
 *
 * @author Joseph Hooper
 * @version 1.0.0
 */
public class Player {

        String name;
        String race;
        Color color;
    ArrayList<Tile> tiles = new ArrayList<>();

    public String getName() {
        return name;
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

    public int getNumberOfTiles() {
        return numberOfTiles;
    }

    public void setNumberOfTiles(int numberOfTiles) {
        this.numberOfTiles = numberOfTiles;
    }

    int numberOfTiles;
    public ArrayList<Tile> getTiles() {
        return tiles;
    }

    public Player(String name, String race, Color color) {
        this.name = name;
        this.race = race;
        this.color = color;
        this.numberOfTiles = 0;
        }
    @Override
    public String toString() {
        return "Name: " + name + "\n| Race: " + race ;
    }
}
