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

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    private Stage mainMap;
}
