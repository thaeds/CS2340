package sample;

import java.util.ArrayList;

/**
 * Created by Sergey on 9/25/15.
 */
public class Context {
    private static ArrayList<Player> players;
    private static Player currentPlayer;
    public static Player getCurrentPlayer() {
        return currentPlayer;
    }
    public static void setCurrentPlayer(Player p) {
        System.out.println("Current Player" + p.toString());
        currentPlayer = p;
    }
    public static void setPlayers(ArrayList<Player> p) {
        players = p;
    }
    public static ArrayList<Player> getPlayers() {
        return players;
    }
}
