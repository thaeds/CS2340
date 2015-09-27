package Map;

import sample.Player;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Created by Sergey on 9/24/15.
 */
public class Turn {

private ArrayDeque<Player> players;

    public Turn(ArrayList<Player> p ) {
        players.addAll(p);
    }

    public Player nextTurn() {
        Player p = players.poll();
        players.add(p);
        return p;
    }
}
