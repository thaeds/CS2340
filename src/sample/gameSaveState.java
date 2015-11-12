package sample;

import Map.MapController;
import javafx.stage.Stage;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Sergey on 10/29/15.
 */
public class gameSaveState implements Serializable {
    private ArrayList<Player> players;
    private Player currentPlayer;
    private int currentRound;

    public int getCurrentRound() {
        return currentRound;
    }

    public void setCurrentRound(int currentRound) {
        this.currentRound = currentRound;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> p) {
        players = p;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player c) {
        currentPlayer = c;
    }

    private Stage mainMap;
}
