package Map;

import sample.Context;
import sample.Player;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;


/**
 * Created by Sergey on 9/24/15.
 */

public class Turn {
    private PriorityQueue<Player> players;
    private ArrayList<Player> passedPlayers = new ArrayList<>();

    public Turn() {
        players = new PriorityQueue<>();
        players.addAll(Context.getPlayers());
    }

    public Player nextTurn() {
        if (players.peek() == null) {
            players.addAll(passedPlayers);
            Player z = players.peek();
            z.setIsLowest(true);
            return nextTurn();
        } else {
            Player current = players.poll();
            passedPlayers.add(current);
            Context.setCurrentPlayer(current);
            return current;
        }
    }

}
