package Map;

import sample.Context;
import sample.Player;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Created by Sergey on 9/24/15.
 */
public class Turn /**implements Runnable*/{

private ArrayDeque<Player> players;
private int currentTurn = 0;

    public Turn(ArrayList<Player> p ) {
        players = new ArrayDeque<>();
        System.out.print(Context.getPlayers());
        players.addAll(Context.getPlayers());
    }

    public Player nextTurn() {
        Player p = players.poll();
        players.add(p);
        currentTurn++;
        Context.setCurrentPlayer(p);
        return p;
    }

    public int getCurrentTurn() {
        return currentTurn;
    }

    /**@Override
    public void run(){
        System.out.println("Turn thread is running");
        while(true) {
            try {
                System.out.println("Turn thread is running");
                nextTurn();
                Thread.sleep(50000);
            } catch (Exception e) {
                System.out.println("Unknown exception!");
            }
        }
    }*/
}
