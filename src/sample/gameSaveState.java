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

    /**
     * Gets current round
     *
     * @return the current round
     */
    public int getCurrentRound() {
        return currentRound;
    }

    /**
     * Sets current round
     *
     * @param currentRound the round being set
     */
    public void setCurrentRound(int currentRound) {
        this.currentRound = currentRound;
    }

    /**
     * Gets the list of active players
     *
     * @return the list of active players
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * Sets list of active players
     *
     * @param p list of active players being set
     */
    public void setPlayers(ArrayList<Player> p) {
        players = p;
    }

    /**
     * Gets current player
     *
     * @return current player
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * sets current player
     *
     * @param player being set
     */
    public void setCurrentPlayer(Player c) {
        currentPlayer = c;
    }

    private Stage mainMap;
}
