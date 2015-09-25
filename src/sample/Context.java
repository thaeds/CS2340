package sample;

import java.util.ArrayList;

/**
 * Created by Sergey on 9/25/15.
 */
public class Context {
    private static ArrayList<Player> players;
    public static void setPlayers(ArrayList<Player> p) {
        players = p;
    }
    public static ArrayList<Player> getPlayers() {
        return players;
    }
}
